package com.example.market.controllers;

import com.example.market.enumm.Status;
import com.example.market.models.Cart;
import com.example.market.models.Order;
import com.example.market.models.Person;
import com.example.market.models.Product;
import com.example.market.repositories.CartRepository;
import com.example.market.repositories.OrderRepository;
import com.example.market.repositories.ProductRepository;
import com.example.market.security.PersonDetails;
import com.example.market.services.PersonService;
import com.example.market.services.ProductService;
import com.example.market.util.PersonValidate;
import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class MainController {
    private  final PersonValidate personValidate;
    private final PersonService personService;
    private final ProductService productService;
    private final ProductRepository productRepository;
    private final CartRepository cartRepository;
    private final OrderRepository orderRepository;
    public MainController(PersonValidate personValidate, PersonService personService, ProductService productService, ProductRepository productRepository, CartRepository cartRepository, OrderRepository orderRepository) {
        this.personValidate = personValidate;
        this.personService = personService;
        this.productService = productService;
        this.productRepository = productRepository;
        this.cartRepository = cartRepository;
        this.orderRepository = orderRepository;
    }

    @GetMapping("/account")
    public String index(Model model){
        //получаем obj Auth -> w/ SpringContextHolder обращаемся к контексту и на нем вызываем метод Auth. Из сессии получаемп obj, которйы был положен в данную сессию после аутен.пользователя
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();
        System.out.println(personDetails.getPerson());
        //получение роли
        String role = personDetails.getPerson().getRole().toString();
        if(role.equals("ROLE_ADMIN")) {
            return "redirect:/admin";
        }
        //данные для теста
        System.out.println("user ID: "+personDetails.getPerson().getId());
        System.out.println("user login: "+personDetails.getPerson().getLogin());
        System.out.println("user password: "+personDetails.getPerson().getPassword());
        System.out.println("user role: "+personDetails.getPerson().getRole());
        System.out.println(personDetails);
        //
        model.addAttribute("products", productService.getAllProduct());
        return "user/index";
    }

    //регистрация
    @GetMapping("/reg")
    public String registration(@ModelAttribute("person") Person person){
        return "reg";
    }
    @PostMapping("/reg")
    public String registrationResult(
            @ModelAttribute("person")@Valid Person person,
            BindingResult bindingResult){

        personValidate.validate(person, bindingResult);
        if (bindingResult.hasErrors()){
            return "reg";
        }
        personService.register(person);
        return "redirect:/account";
    }

    //получение полной информации о товаре по id
    @GetMapping("/account/product/info/{id}")
    public String productInfo(@PathVariable("id") int id, Model model){
        model.addAttribute("product", productService.getProductId(id));
        return "/user/info";
    }

    //поиск
    @PostMapping("/account/search")
    public String productSearch(
            @RequestParam("search") String search,
            @RequestParam("priceFrom") String priceFrom,
            @RequestParam("priceTo") String priceTo,
            @RequestParam(value="price", required = false, defaultValue = "") String price,
            @RequestParam(value="searchcategory", required = false, defaultValue = "") String searchcategory,
            Model model){
        model.addAttribute("products", productService.getAllProduct());

        if(!priceFrom.isEmpty() & !priceTo.isEmpty()) {
            if (!price.isEmpty()) {
                if (price.equals("sort_by_asc_price")) {
                    if (!searchcategory.isEmpty()) {
                        if (searchcategory.equals("furniture")) {
                            model.addAttribute("search_product", productRepository.findByTitleAndCategoryOrderByPriceAsc(search.toLowerCase(), Float.parseFloat(priceFrom), Float.parseFloat(priceTo), 1));
                        } else if (searchcategory.equals("appliance")) {
                            model.addAttribute("search_product", productRepository.findByTitleAndCategoryOrderByPriceAsc(search.toLowerCase(), Float.parseFloat(priceFrom), Float.parseFloat(priceTo), 3));
                        } else if (searchcategory.equals("clothes")) {
                            model.addAttribute("search_product", productRepository.findByTitleAndCategoryOrderByPriceAsc(search.toLowerCase(), Float.parseFloat(priceFrom), Float.parseFloat(priceTo), 2));
                        }
                    } else {
                        model.addAttribute("search_product", productRepository.findByTitleOrderByPriceAsc(search.toLowerCase(), Float.parseFloat(priceFrom), Float.parseFloat(priceTo)));
                    }
                } else if (price.equals("sort_by_desc_price")) {
                    if (!searchcategory.isEmpty()) {
                        if (searchcategory.equals("furniture")) {
                            model.addAttribute("search_product", productRepository.findByTitleAndCategoryOrderByPriceDesc(search.toLowerCase(), Float.parseFloat(priceFrom), Float.parseFloat(priceTo), 1));
                        } else if (searchcategory.equals("appliance")) {
                            model.addAttribute("search_product", productRepository.findByTitleAndCategoryOrderByPriceDesc(search.toLowerCase(), Float.parseFloat(priceFrom), Float.parseFloat(priceTo), 3));
                        } else if (searchcategory.equals("clothes")) {
                            model.addAttribute("search_product", productRepository.findByTitleAndCategoryOrderByPriceDesc(search.toLowerCase(), Float.parseFloat(priceFrom), Float.parseFloat(priceTo), 2));
                        }
                    } else {
                        model.addAttribute("search_product", productRepository.findByTitleOrderByPriceDesc(search.toLowerCase(), Float.parseFloat(priceFrom), Float.parseFloat(priceTo)));
                    }
                }
            } else {
                model.addAttribute("search_product", productRepository.findByTitleAndPriceGreaterThanEqualAndPriceLessThanEqual(search.toLowerCase(), Float.parseFloat(priceFrom), Float.parseFloat(priceTo)));
            }
        } else {
            model.addAttribute("search_product", productRepository.findByTitleContainingIgnoreCase(search));
        }

        model.addAttribute("value_search", search);
        model.addAttribute("value_priceFrom", priceFrom);
        model.addAttribute("value_priceTo", priceTo);

        return "user/index";
    }

    //cart
    @GetMapping("/cart/add/{id}")
    public String addProductInCart(
            @PathVariable("id")int id,
            Model model){
        //получить продукт по id
        Product product = productService.getProductId(id);
        //извлечь объект аутен.пользователя
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // получаем person из объекта аут.пользователя
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();

        //извлекаем id пользотваеля из объекта
        int id_person = personDetails.getPerson().getId();
        //формируем новую корзину
        Cart cart = new Cart(id_person, product.getId());
        //cохраняем корзину
        cartRepository.save(cart);

        return "redirect:/account";
    }

    @GetMapping("/cart")
    public String cart(Model model) {
        //извлечь объект аутен.пользователя
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // получаем person из объекта аут.пользователя
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();
        //извлекаем id пользотваеля из объекта
        int id_person = personDetails.getPerson().getId();

        List<Cart> cartList = cartRepository.findByPersonId((id_person));
        List<Product> productList = new ArrayList<>();
        //переборка продуктов
        for (Cart item: cartList) {
            productList.add(productService.getProductId(item.getProductId()));
        }
        //итог корзины
        float totalPrice= 0;
        for (Product item: productList) {
            totalPrice += item.getPrice();
        }
        model.addAttribute("total_price", totalPrice);
        model.addAttribute("cart_product", productList);

        return "/user/cart";
    }

    @GetMapping("/cart/delete/{id}")
    public String deleteProductFromCart(Model model, @PathVariable("id") int id){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();
        int id_person = personDetails.getPerson().getId();

        List<Cart> cartList = cartRepository.findByPersonId((id_person));
        List<Product> productList = new ArrayList<>();

        for (Cart item: cartList) {
            productList.add(productService.getProductId(item.getProductId()));
        }

        cartRepository.deleteCartByProductId(id);

        return "redirect:/cart";
    }

    @GetMapping("/order/create")
    public String order(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();
        int id_person = personDetails.getPerson().getId();

        List<Cart> cartList = cartRepository.findByPersonId((id_person));
        List<Product> productList = new ArrayList<>();

        for (Cart item: cartList) {
            productList.add(productService.getProductId(item.getProductId()));
        }

        float totalPrice= 0;
        for (Product item: productList) {
            totalPrice += item.getPrice();
        }

        String uuid = UUID.randomUUID().toString();

        for (Product product: productList) {
            Order newOrder = new Order(uuid, product, personDetails.getPerson(), 1, product.getPrice(), Status.Принят);
            orderRepository.save(newOrder);
            cartRepository.deleteCartByProductId(product.getId());
        }

        return "redirect:/orders";
    }


    //вывести заказы
    @GetMapping("/orders")
    public String userOrder(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();
        List<Order> orderList = orderRepository.findByPerson(personDetails.getPerson());

        model.addAttribute("orders", orderList);

        return "user/orders";
    }

}

