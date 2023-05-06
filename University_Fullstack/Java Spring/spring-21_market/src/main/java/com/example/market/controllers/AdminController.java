package com.example.market.controllers;
import com.example.market.models.*;
import com.example.market.repositories.CategoryRepository;
import com.example.market.services.OrderService;
import com.example.market.services.PersonService;
import com.example.market.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.example.market.enumm.Status;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class AdminController {
    private final ProductService productService;
    @Value("${upload.path}")
    private String uploadPath;

    private final CategoryRepository categoryRepository;
    private final PersonService personService;
    private final OrderService orderService;

    public AdminController(ProductService productService, CategoryRepository categoryRepository, PersonService personService, OrderService orderService) {
        this.productService = productService;
        this.categoryRepository = categoryRepository;
        this.personService = personService;
        this.orderService = orderService;
    }
    @GetMapping("/admin")
    public String admin(){
        return "/admin/terminal";
    }

    @GetMapping("/admin/products")
    public String products(Model model){
        model.addAttribute("products", productService.getAllProduct());
        return "admin/products";
    }

    //ТОВАР: добавление позиции
    @GetMapping("/admin/product/add")
    public String addProduct(Model model){
        model.addAttribute("product", new Product());
        model.addAttribute("category", categoryRepository.findAll());
        return "product/addProduct";
    }

    //добавление товара
    @PostMapping("/admin/product/add")
    public String addProduct(
            @ModelAttribute("product") @Valid Product product,
            BindingResult bindingResult,
            @RequestParam("file_1")MultipartFile file_1,
            @RequestParam("file_2")MultipartFile file_2,
            @RequestParam("file_3")MultipartFile file_3,
            @RequestParam("file_4")MultipartFile file_4,
            @RequestParam("file_5")MultipartFile file_5,
            @RequestParam("category") int category,
            Model model
            ) throws IOException {
        Category category_db = categoryRepository.findById(category).orElseThrow();
        System.out.println(category_db.getTitle());
        if(bindingResult.hasErrors()){
            model.addAttribute("category", categoryRepository.findAll());
            return "product/addProduct";
        }
        //загрузка изобр и задание уник.имени
        if(file_1 != null) {
            File uploadDir = new File(uploadPath);
            if(!uploadDir.exists()){
                uploadDir.mkdir();
            }
            String uuidFile = UUID.randomUUID().toString();
            String resultFileName = uuidFile + "." + file_1.getOriginalFilename();
            file_1.transferTo(new File(uploadPath+"/"+resultFileName));
            Image image = new Image();
            image.setProduct(product);
            image.setFileName(resultFileName);
            product.addImageToProduct(image);
        }
        if(file_2 != null) {
            File uploadDir = new File(uploadPath);
            if(!uploadDir.exists()){
                uploadDir.mkdir();
            }
            String uuidFile = UUID.randomUUID().toString();
            String resultFileName = uuidFile + "." + file_2.getOriginalFilename();
            file_2.transferTo(new File(uploadPath+"/"+resultFileName));
            Image image = new Image();
            image.setProduct(product);
            image.setFileName(resultFileName);
            product.addImageToProduct(image);
        }
        if(file_3 != null) {
            File uploadDir = new File(uploadPath);
            if(!uploadDir.exists()){
                uploadDir.mkdir();
            }
            String uuidFile = UUID.randomUUID().toString();
            String resultFileName = uuidFile + "." + file_3.getOriginalFilename();
            file_3.transferTo(new File(uploadPath+"/"+resultFileName));
            Image image = new Image();
            image.setProduct(product);
            image.setFileName(resultFileName);
            product.addImageToProduct(image);
        }
        if(file_4 != null) {
            File uploadDir = new File(uploadPath);
            if(!uploadDir.exists()){
                uploadDir.mkdir();
            }
            String uuidFile = UUID.randomUUID().toString();
            String resultFileName = uuidFile + "." + file_4.getOriginalFilename();
            file_4.transferTo(new File(uploadPath+"/"+resultFileName));
            Image image = new Image();
            image.setProduct(product);
            image.setFileName(resultFileName);
            product.addImageToProduct(image);
        }
        if(file_5 != null) {
            File uploadDir = new File(uploadPath);
            if(!uploadDir.exists()){
                uploadDir.mkdir();
            }
            String uuidFile = UUID.randomUUID().toString();
            String resultFileName = uuidFile + "." + file_5.getOriginalFilename();
            file_5.transferTo(new File(uploadPath+"/"+resultFileName));
            Image image = new Image();
            image.setProduct(product);
            image.setFileName(resultFileName);
            product.addImageToProduct(image);
        }

        productService.saveProduct(product, category_db);
        return "redirect:/admin";
    }
    //удаление товара по id
    @GetMapping("/admin/product/delete/{id}")
    public String deleteProduct(@PathVariable("id") int id){
        productService.deleteProduct(id);
        return "redirect:/admin";
    }
    //получение товара по id для редактирования
    @GetMapping("/admin/product/edit/{id}")
    public String editProduct(
            Model model,
            @PathVariable("id")int id) {
        model.addAttribute("product", productService.getProductId(id));
        model.addAttribute("category", categoryRepository.findAll());
        return "product/editProduct";
    }

    //редактирование товара по id и update
    @PostMapping("/admin/product/edit/{id}")
    public String editProduct(
            @ModelAttribute("product")
            @Valid Product product,
            BindingResult bindingResult,
            @PathVariable("id") int id,
            Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("category", categoryRepository.findAll());
            return "product/editProduct";
        }
        productService.updateProduct(id, product);
        return "redirect:/admin";
    }

    //USERS
    //получить список пользователей
    @GetMapping("/admin/users")
    public String getAllPerson(Model model){
        model.addAttribute("userList", personService.getAllPerson());

        return "/admin/users";
    }

    //получить информацию по пользователю (работает)
    @GetMapping("/user/info/{id}")
    public String personInfo(@PathVariable("id") int id, Model model){
        //получить информацию по пользователе по его id
        model.addAttribute("user", personService.getPersonId(id));

        //получить заказы пользователя по его id
        model.addAttribute("userOrderList", orderService.findByPersonId(id));
        System.out.println("Открыта информация о пользователе");

        return "/admin/user/userInfo";
    }

    //получение пользователя по id для редактирования (работает)
    @GetMapping("/admin/user/edit/{id}")
    public String personEdit(
            Model model,
            @PathVariable("id") int id) {
        model.addAttribute("user", personService.getPersonId(id));
        System.out.println("Получен пользователь для редактирования");
        return "admin/user/userEdit";
    }

    //обновление пользователя НЕ РАБОТАЕТ!
    @PostMapping("/admin/user/edit/{id}")
    public String personUpdate(
            @ModelAttribute("user")
            @Valid Person person,
            BindingResult bindingResult,
            @PathVariable("id") int id,
            Model model){
        if (bindingResult.hasErrors()){
            System.out.println("Ошибка при редактировании пользования!");
            return "admin/user/userEdit";
        }
        personService.updatePerson(id, person);
        return "redirect:/admin/users";
    }

    //удаление пользователя по id (работает)
    @GetMapping("/admin/user/delete/{id}")
    public String personDelete(@PathVariable("id") int id){
        personService.deletePerson(id);
        return "redirect:/admin/users";
    }


    //ЗАКАЗЫ
    //вывести список всех заказов для администратора (работает)
    @GetMapping("/admin/orders")
    public String getAllOrder(Model model){
        model.addAttribute("allOrders", orderService.getAllOrder());

        return "/admin/orders";
    }

    //вывести заказы выбранного пользователя по id ???
    //не задействован
    public String getUserOrder(@PathVariable("id") int id, Model model){
        model.addAttribute("userOrders", orderService.findByPersonId(id));
        return "/admin/user/order";
    }

    //вывести информацию заказа по его id
    @GetMapping("/admin/order/info/{id}")
    public String getOrderInfo(@PathVariable("id") int id, Model model){
        model.addAttribute("orderById", orderService.findByOrderId(id));
        return "/admin/order/orderInfo";
    }

    //редактировать заказ получив его по id
    @GetMapping("/admin/order/edit/{id}")
    public String editOrder(Model model, @PathVariable("id") int id){
        model.addAttribute("orderEdit", orderService.findByOrderId(id));
        model.addAttribute("newStatus", Status.values());
        return "/admin/order/orderEdit";
    }

    //Сохранить заказ после изменения статуса (не работает)
    @PostMapping("/admin/order/edit/{id}")
    public String saveOrderStatus(@PathVariable("id") int id,
                                  @ModelAttribute("orderEdit") Order order,
                                  @RequestParam("set_New_Status") String newStatus,
                                  Model model){
        model.addAttribute("set_New_Status", newStatus);
        model.addAttribute("orderEdit", order);
        System.out.println("какой приходит статус при нажатии сохранить? " + newStatus);
        orderService.updateOrder(id, newStatus, order);
        return "redirect:/admin/order/orderInfo";
    }

    //поиск заказа
    @PostMapping("/admin/order/search")
    public String searchOrder(
            @RequestParam("order_search") String orderSearch,
            Model model
    ){
        if(!orderSearch.isEmpty()) {
            model.addAttribute("findOrders", orderService.findOrderByOrderNo(orderSearch));
        }
        //вернуть все заказы через модель на страницу заказов
        model.addAttribute("allOrders", orderService.getAllOrder());
        //вернуть слово использованное для поиска в графу поиска
        model.addAttribute("value_order_search", orderSearch);
        return "/admin/orders";
    }
}
