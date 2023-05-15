package com.example.market.controllers;

import com.example.market.enumm.Status;
import com.example.market.models.*;
import com.example.market.repositories.ProductRepository;
import com.example.market.security.PersonDetails;
import com.example.market.services.CartService;
import com.example.market.services.OrderService;
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
    private final PersonValidate personValidate;
    private final PersonService personService;
    private final ProductService productService;
    private final ProductRepository productRepository;
    private final CartService cartService;
    private final OrderService orderService;
    public MainController(PersonValidate personValidate, PersonService personService, ProductService productService, ProductRepository productRepository, CartService cartService, OrderService orderService) {
        this.personValidate = personValidate;
        this.personService = personService;
        this.productService = productService;
        this.productRepository = productRepository;
        this.cartService = cartService;
        this.orderService = orderService;
    }

    //Открыть главную страницу после авторизации
    @GetMapping("/account")
    public String index(Model model){
        //Получаем объект Аутентификациис помощью SpringContextHolder, обращаемся к контексту и на нем вызываем метод Auth.
        //Из сессии получаем объект, который был положен в данную сессию после аутенификации пользователя
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();

        System.out.println("Проверка аккаунта после Auth");
        //получение роли
        String role = personDetails.getPerson().getRole();
        if(role.equals("ROLE_ADMIN")) {
            //данные для теста
            System.out.println("user login: " +personDetails.getPerson().getLogin());
            System.out.println("user role: " + personDetails.getPerson().getRole());
            return "redirect:/admin";
        }
        //данные для теста
        System.out.println("user login: "+personDetails.getPerson().getLogin());
        System.out.println("user role: "+personDetails.getPerson().getRole());
        //
        model.addAttribute("products", productService.getAllProduct());
        //пооложить объект из authentication для вывода на экран
        model.addAttribute("userAuth", personDetails.getPerson());
        return "/user/userIndex";
    }

    //Регистрация get
    @GetMapping("/reg")
    public String registration(@ModelAttribute("person") Person person){
        return "reg";
    }
    //Регистрация post
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


    //Корзина: добавить товар в корзину
    @GetMapping("/cart/add/{id}")
    public String addProductInCart(
            @PathVariable("id")int id){
        //получить продукт по id
        Product product = productService.getProductId(id);
        //извлечь объект аутен.пользователя
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // получаем person из объекта аут.пользователя
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();

        //извлекаем id пользователя из объекта
        int id_person = personDetails.getPerson().getId();
        //формируем новую корзину
        Cart cart = new Cart(id_person, product.getId());
        //cохраняем корзину
        cartService.saveCart(cart);

        return "redirect:/account";
    }

    //Корзина: формирование
    @GetMapping("/cart")
    public String cart(Model model) {
        //извлечь объект аутен. пользователя
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // получаем person из объекта аут. пользователя
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();
        //извлекаем id пользователя из объекта
        int id_person = personDetails.getPerson().getId();

        List<Cart> cartList = cartService.findByPersonId(id_person);
        List<Product> productList = new ArrayList<>();

        //переборка элементов корзина
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

    //КОРЗИНА: удалить товары по id
    @GetMapping("/cart/delete/{id}")
    public String deleteProductFromCart(@PathVariable("id") int id){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();
        int id_person = personDetails.getPerson().getId();

        List<Cart> cartList = cartService.findByPersonId(id_person);
        List<Product> productList = new ArrayList<>();

        //получить продукты из корзины по id товара
        for (Cart item: cartList) {
            productList.add(productService.getProductId(item.getProductId()));
        }

        cartService.deleteItemFromCart(id);

        return "redirect:/cart";
    }

    //ЗАКАЗ: создать
    @GetMapping("/order/create")
    public String order(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();
        int id_person = personDetails.getPerson().getId();

        List<Cart> cartList = cartService.findByPersonId(id_person);
        List<Product> productList = new ArrayList<>();

        //получить продукты из корзины по id товара
        for (Cart item: cartList) {
            productList.add(productService.getProductId(item.getProductId()));
        }

        //итоговая цена заказа
        float totalPrice = 0;
        for (Product item: productList) {
            totalPrice += item.getPrice();
        }
        //добавить соли
        String uuid = UUID.randomUUID().toString();

        for (Product product: productList) {
            Order newOrder = new Order(uuid, product, personDetails.getPerson(), 1, product.getPrice(), Status.Принят);
            orderService.saveOrder(newOrder);
            //orderRepository.save(newOrder);

            //очистить корзину
            cartService.deleteItemFromCart(product.getId());
        }

        return "redirect:/orders";
    }


//    //Пользователь: вывести все заказы
//    @GetMapping("/orders")
//    public String userOrder(Model model){
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();
//        List<Order> orderList = orderService.findOrderByPerson(personDetails.getPerson());
//
//        //List<Order> orderList = orderRepository.findByPerson(personDetails.getPerson());
//
//        model.addAttribute("userOrders", orderList);
//        model.addAttribute("userAuth", personDetails.getPerson());
//        return "user/orders";
//    }


    //поиск товаров для user (работает)
    @PostMapping("/user/search")
    public String userProductSearch(
            @RequestParam("titleRequest") String titleRequest,
            @RequestParam("priceFrom") String priceFrom,
            @RequestParam("priceTo") String priceTo,
            @RequestParam(value="priceSort", required = false, defaultValue = "") String priceSort,
            @RequestParam(value="categorySelect", required = false, defaultValue = "") String categorySelect,
            Model model){
        model.addAttribute("products", productService.getAllProduct());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();
        model.addAttribute("userAuth", personDetails.getPerson());

        //3
        //по части названия, цене "от и до", категория или без нее, с сортировкой
        if(!titleRequest.isEmpty()) {
            if (!priceFrom.isEmpty() & !priceTo.isEmpty()) {
                if (priceSort.equals("priceSortByASC")) {
                    if (!categorySelect.isEmpty()) {
                        switch (categorySelect) {
                            case "furniture" ->
                                model.addAttribute("productFound", productRepository.findByTitleAndCategoryOrderByPriceAsc(titleRequest, Float.parseFloat(priceFrom), Float.parseFloat(priceTo), 1));
                            case "clothes" ->
                                    model.addAttribute("productFound", productRepository.findByTitleAndCategoryOrderByPriceAsc(titleRequest, Float.parseFloat(priceFrom), Float.parseFloat(priceTo), 2));
                            case "appliance" ->
                                    model.addAttribute("productFound", productRepository.findByTitleAndCategoryOrderByPriceAsc(titleRequest, Float.parseFloat(priceFrom), Float.parseFloat(priceTo), 3));
                        }
                    } else {
                        model.addAttribute("productFound", productRepository.findByTitleOrderByPriceAsc(titleRequest, Float.parseFloat(priceFrom), Float.parseFloat(priceTo)));
                    }
                } else {
                    //desc
                    if (!categorySelect.isEmpty()) {
                        switch (categorySelect) {
                            case "furniture" ->
                                    model.addAttribute("productFound", productRepository.findByTitleAndCategoryOrderByPriceDesc(titleRequest, Float.parseFloat(priceFrom), Float.parseFloat(priceTo), 1));
                            case "clothes" ->
                                    model.addAttribute("productFound", productRepository.findByTitleAndCategoryOrderByPriceDesc(titleRequest, Float.parseFloat(priceFrom), Float.parseFloat(priceTo), 2));
                            case "appliance" ->
                                    model.addAttribute("productFound", productRepository.findByTitleAndCategoryOrderByPriceDesc(titleRequest, Float.parseFloat(priceFrom), Float.parseFloat(priceTo), 3));
                        }
                    } else {
                        model.addAttribute("productFound", productRepository.findByTitleOrderByPriceDesc(titleRequest, Float.parseFloat(priceFrom), Float.parseFloat(priceTo)));
                    }
                }
            }
        }

        //2
        //по части названия, категории, и сортировка по цене
        if(!titleRequest.isEmpty()) {
            if(!categorySelect.isEmpty()) {
                if(priceSort.isEmpty() || priceSort.equals("priceSortByASC")) {
                    switch (categorySelect) {
                        case "furniture" ->
                                model.addAttribute("productFound", productRepository.findByTitleContainingIgnoreCaseAndCategoryOrderByPriceAsc(titleRequest, 1));
                        case "clothes" ->
                                model.addAttribute("productFound", productRepository.findByTitleContainingIgnoreCaseAndCategoryOrderByPriceAsc(titleRequest,2));
                        case "appliance" ->
                                model.addAttribute("productFound", productRepository.findByTitleContainingIgnoreCaseAndCategoryOrderByPriceAsc(titleRequest,3));
                    }
                } else {
                    switch (categorySelect) {
                        case "furniture" ->
                                model.addAttribute("productFound", productRepository.findByTitleContainingIgnoreCaseAndCategoryOrderByPriceDesc(titleRequest, 1));
                        case "clothes" ->
                                model.addAttribute("productFound", productRepository.findByTitleContainingIgnoreCaseAndCategoryOrderByPriceDesc(titleRequest,2));
                        case "appliance" ->
                                model.addAttribute("productFound", productRepository.findByTitleContainingIgnoreCaseAndCategoryOrderByPriceDesc(titleRequest,3));
                    }
                }
            } else {
                model.addAttribute("productFound", productRepository.findByTitleContainingIgnoreCase(titleRequest));
            }
        } else

        //2
        //по цене "от и до", категории и сортировка по цене -
        if(!priceFrom.isEmpty() & !priceTo.isEmpty() & !categorySelect.isEmpty() & (priceSort.equals("priceSortByASC") || priceSort.isEmpty())
            ){
            switch(categorySelect){
                case "furniture" ->
                    model.addAttribute("productFound", productRepository.findByCategoryAndPriceAndOrderByPriceAsc(Float.parseFloat(priceFrom), Float.parseFloat(priceTo), 1));
                case "clothes" ->
                        model.addAttribute("productFound", productRepository.findByCategoryAndPriceAndOrderByPriceAsc(Float.parseFloat(priceFrom), Float.parseFloat(priceTo), 2));
                case "appliance" ->
                        model.addAttribute("productFound", productRepository.findByCategoryAndPriceAndOrderByPriceAsc(Float.parseFloat(priceFrom), Float.parseFloat(priceTo), 3));
            }
        } else if(!priceFrom.isEmpty() & !priceTo.isEmpty() & !categorySelect.isEmpty() & priceSort.equals("priceSortByDESC")) {
            switch (categorySelect) {
                case "furniture" ->
                        model.addAttribute("productFound", productRepository.findByCategoryAndPriceAndOrderByPriceDesc(Float.parseFloat(priceFrom), Float.parseFloat(priceTo), 1));
                case "clothes" ->
                        model.addAttribute("productFound", productRepository.findByCategoryAndPriceAndOrderByPriceDesc(Float.parseFloat(priceFrom), Float.parseFloat(priceTo), 2));
                case "appliance" ->
                        model.addAttribute("productFound", productRepository.findByCategoryAndPriceAndOrderByPriceDesc(Float.parseFloat(priceFrom), Float.parseFloat(priceTo), 3));
            }
        }

        //1
        //по части названия и сортировка по цене +
        if(!titleRequest.isEmpty() & (priceSort.isEmpty() || priceSort.equals("priceSortByASC"))) {
            model.addAttribute("productFound", productRepository.findByTitleContainingIgnoreCaseOrderByPriceAsc(titleRequest));
        } else
        if (!titleRequest.isEmpty() & priceSort.equals("priceSortByDESC")) {
            model.addAttribute("productFound", productRepository.findByTitleContainingIgnoreCaseOrderByPriceDesc(titleRequest));
        }

        //1
        //по категории (остальные графы пустые) и сортировка по цене +
        if(!categorySelect.isEmpty()
                //& priceFrom.isEmpty() &priceTo.isEmpty() & titleRequest.isEmpty()
                & (priceSort.equals("priceSortByASC") || priceSort.isEmpty())
        ){
            switch (categorySelect) {
                case "furniture" ->
                        model.addAttribute("productFound", productRepository.findByCategoryAndOrderByPriceAsc(1));
                case "clothes" ->
                        model.addAttribute("productFound", productRepository.findByCategoryAndOrderByPriceAsc(2));
                case "appliance" ->
                        model.addAttribute("productFound", productRepository.findByCategoryAndOrderByPriceAsc(3));
            }
        } else if (!categorySelect.isEmpty()
                //& titleRequest.isEmpty() & priceFrom.isEmpty() &priceTo.isEmpty()
                & priceSort.equals("priceSortByDESC")
        ){
            switch (categorySelect) {
                case "furniture" ->
                        model.addAttribute("productFound", productRepository.findByCategoryAndOrderByPriceDesc(1));
                case "clothes" ->
                        model.addAttribute("productFound", productRepository.findByCategoryAndOrderByPriceDesc(2));
                case "appliance" ->
                        model.addAttribute("productFound", productRepository.findByCategoryAndOrderByPriceDesc(3));
            }
        }

        //1
        //по цене "от и до" и сортировка по цене +
        if(!priceFrom.isEmpty() & !priceTo.isEmpty() & (priceSort.equals("priceSortByASC") || priceSort.isEmpty())
            ){
            model.addAttribute("productFound", productRepository.findByPriceAndOrderByPriceAsc(Float.parseFloat(priceFrom), Float.parseFloat(priceTo)));
        } else if (!priceFrom.isEmpty() & !priceTo.isEmpty() & (priceSort.equals("priceSortByDESC"))
        ){
            model.addAttribute("productFound", productRepository.findByPriceAndOrderByPriceDesc(Float.parseFloat(priceFrom), Float.parseFloat(priceTo)));
        }

        model.addAttribute("value_priceSort", priceSort);
        model.addAttribute("value_titleTyped", titleRequest);
        model.addAttribute("value_priceFrom", priceFrom);
        model.addAttribute("value_priceTo", priceTo);

        return "/user/userIndex";
    }



}

