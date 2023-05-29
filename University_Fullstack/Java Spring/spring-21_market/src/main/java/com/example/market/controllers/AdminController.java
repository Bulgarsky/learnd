package com.example.market.controllers;
import com.example.market.enumm.Role;
import com.example.market.models.*;
import com.example.market.repositories.CategoryRepository;
import com.example.market.repositories.ProductRepository;
import com.example.market.security.PersonDetails;
import com.example.market.services.OrderService;
import com.example.market.services.PersonService;
import com.example.market.services.ProductService;
import com.example.market.services.ShippingAddressService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.example.market.enumm.Status;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
public class AdminController {
    private final ProductService productService;
    @Value("${upload.path}")
    private String uploadPath;

    private final CategoryRepository categoryRepository;
    private final PersonService personService;
    private final OrderService orderService;
    private final ShippingAddressService shippingAddressService;

    private final ProductRepository productRepository;

    public AdminController(ProductService productService, CategoryRepository categoryRepository, PersonService personService, OrderService orderService, ShippingAddressService shippingAddressService, ProductRepository productRepository) {
        this.productService = productService;
        this.categoryRepository = categoryRepository;
        this.personService = personService;
        this.orderService = orderService;
        this.shippingAddressService = shippingAddressService;
        this.productRepository = productRepository;
    }
    @GetMapping("/admin")
    public String admin(){
        return "admin/terminal";
    }

    @GetMapping("/admin/products")
    public String products(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();
        Person currentPerson = personDetails.getPerson();
        model.addAttribute("userAuth", currentPerson);
        model.addAttribute("products", productService.getAllProduct());


        return "admin/products";
    }

    //ТОВАР: добавление позиции
    @GetMapping("/admin/product/add")
    public String addProduct(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();
        Person currentPerson = personDetails.getPerson();
        model.addAttribute("userAuth", currentPerson);

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

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();
        Person currentPerson = personDetails.getPerson();
        model.addAttribute("userAuth", currentPerson);

        return "redirect:/admin/products";
    }

    //удаление товара по id
    @GetMapping("/admin/product/delete/{id}")
    public String deleteProduct(@PathVariable("id") int id){
        productService.deleteProduct(id);
        return "redirect:/admin/products";
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

        return "redirect:admin/products";
    }

    //USERS
    //получить список пользователей
    @GetMapping("/admin/users")
    public String getAllPerson(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();
        Person currentPerson = personDetails.getPerson();
        model.addAttribute("userAuth", currentPerson);
        int userCount = 0;
        List<Person> userList = personService.getAllPerson();
        for (Person person: userList) {
            userCount+=1;
        }
        model.addAttribute("userCount", userCount);
        model.addAttribute("userList", userList);

        return "/admin/users";
    }

    //получить информацию по пользователю (работает)
    @GetMapping("/user/info/{id}")
    public String personInfo(@PathVariable("id") int id, Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();
        Person currentPerson = personDetails.getPerson();
        model.addAttribute("userAuth", currentPerson);

        //получить информацию по пользователе по его id
        model.addAttribute("user", personService.getPersonId(id));

        //получить заказы пользователя по его id
        model.addAttribute("userOrderList", orderService.findByPersonId(id));
        //получить адрес по умолчанию

        if (shippingAddressService.findDefaultAddress(id) != null) {
            ShippingAddress userDefaultAddress = shippingAddressService.findDefaultAddress(id);
            StringBuilder userDefaultAddressString = new StringBuilder(userDefaultAddress.getZip() + ", " + userDefaultAddress.getCountry()+ ", " +userDefaultAddress.getState()+ ", "+ userDefaultAddress.getCity()+ ", " + userDefaultAddress.getStreet()+", "+userDefaultAddress.getBuilding()+", "+userDefaultAddress.getApartment());
            model.addAttribute("userDefaultAddress", userDefaultAddressString);
        } else{
            StringBuilder userDefaultAddressNotSet = new StringBuilder("пользователь не выбрал адрес доставки по умолчанию");
            model.addAttribute("userDefaultAddress", userDefaultAddressNotSet);
        }


        Person person = personService.getPersonId(id);
        System.out.println("person: "+person + ", login: "+person.getLogin()+", current role: "+person.getRole());

        return "/admin/user/userInfo";
    }

    //получение пользователя по id для редактирования (работает)
    @GetMapping("/admin/user/edit/{id}")
    public String personEdit(
            Model model,
            @PathVariable("id") int id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();
        Person currentPerson = personDetails.getPerson();
        model.addAttribute("userAuth", currentPerson);

        model.addAttribute("user", personService.getPersonId(id));
        //данные для теста +
        System.out.println("Получен пользователь для редактирования:");
        System.out.println("логин: "+personService.getPersonId(id).getLogin());
        System.out.println("роль: "+personService.getPersonId(id).getRole());

        return "admin/user/userEdit";
    }

    //обновление пользователя (работает)
    @PostMapping("/admin/user/edit/{id}")
    public String personUpdate(
            @PathVariable("id") int id,
            @RequestParam("newRole") Role newRole,
            Model model){
        //запросить пользователя по id cо страницы редактирования
        Person person = personService.getPersonId(id);
        //тестовые данные
        System.out.println("новая роль: "+ newRole);
        System.out.println("person: "+person + ", login: "+person.getLogin()+", current role: "+person.getRole());

        //отправить id, person, newRole в метод
        personService.setPersonNewRole(id, person, newRole);
        //положить в модель пользователя, для вывода на страницу после редактирования
        model.addAttribute("user", personService.getPersonId(id));

        return "redirect:/admin/user/edit/{id}";
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
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();
        Person currentPerson = personDetails.getPerson();
        model.addAttribute("userAuth", currentPerson);

        model.addAttribute("allOrders", orderService.getAllOrder());
        return "/admin/orders";
    }

    //вывести заказы выбранного пользователя (id) ???
    //не задействован
    public String getUserOrder(@PathVariable("id") int id, Model model){
        model.addAttribute("userOrders", orderService.findByPersonId(id));
        return "/admin/user/order";
    }

    //вывести информацию заказа по его id
    @GetMapping("/admin/order/info/{id}")
    public String getOrderInfo(@PathVariable("id") int id, Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();
        Person currentPerson = personDetails.getPerson();
        model.addAttribute("userAuth", currentPerson);

        int person_id = orderService.findByOrderId(id).getPerson().getId();
        if (shippingAddressService.findDefaultAddress(person_id) != null) {
            ShippingAddress userDefaultAddress = shippingAddressService.findDefaultAddress(person_id);
            StringBuilder userDefaultAddressString = new StringBuilder(userDefaultAddress.getZip() + ", " + userDefaultAddress.getCountry()+ ", " +userDefaultAddress.getState()+ ", "+ userDefaultAddress.getCity()+ ", " + userDefaultAddress.getStreet()+", "+userDefaultAddress.getBuilding()+", "+userDefaultAddress.getApartment());
            model.addAttribute("userDefaultAddress", userDefaultAddressString);
        } else{
            StringBuilder userDefaultAddressNotSet = new StringBuilder("пользователь не выбрал адрес доставки по умолчанию");
            model.addAttribute("userDefaultAddress", userDefaultAddressNotSet);
        }


        model.addAttribute("orderById", orderService.findByOrderId(id));
        return "/admin/order/orderInfo";
    }

    //получить заказ по id для редактирования
    @GetMapping("/admin/order/edit/{id}")
    public String editOrder(
            Model model,
            @PathVariable("id") int id){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();
        Person currentPerson = personDetails.getPerson();
        model.addAttribute("userAuth", currentPerson);

        model.addAttribute("orderEdit", orderService.findByOrderId(id));
        model.addAttribute("newStatus", Status.values()); // ??
        return "/admin/order/orderEdit";
    }

    //Сохранить заказ после изменения статуса (работает)
    @PostMapping("/admin/order/edit/{id}")
    public String saveOrderStatus(@PathVariable("id") int id,
                                  @RequestParam("newStatus") Status newStatus,
                                  Model model){
        Order order = orderService.findByOrderId(id);
        System.out.println("какой приходит статус при нажатии сохранить? " + newStatus);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();
        Person currentPerson = personDetails.getPerson();
        model.addAttribute("userAuth", currentPerson);

        orderService.orderStatusUpdate(id, order, newStatus);

        model.addAttribute("order", orderService.findByOrderId(id));
        return "redirect:/admin/order/edit/{id}";
    }
    //поиск заказа для админа
    @GetMapping("/admin/order/search")
    public String searchOrder(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();
        Person currentPerson = personDetails.getPerson();
        model.addAttribute("userAuth", currentPerson);
        return "/admin/order/orderSearch";
    }
    //поиск заказа для админа
    @PostMapping("/admin/order/search")
    public String searchOrder(
            @RequestParam("order_search") String orderSearch,
            Model model
    ){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();
        Person currentPerson = personDetails.getPerson();
        model.addAttribute("userAuth", currentPerson);
        List<Order> ordersFound = orderService.findOrderByOrderNo(orderSearch);
        if(!orderSearch.isEmpty()) {
            model.addAttribute("findOrders", ordersFound);
        }

        int ordersFoundCount = 0;
        for (Order order: ordersFound) {
            ordersFoundCount+=1;
        }
        model.addAttribute("ordersFoundCount", ordersFoundCount);
        //вернуть все заказы через модель на страницу заказов
        //model.addAttribute("allOrders", orderService.getAllOrder());
        //вернуть слово использованное для поиска в графу поиска
        model.addAttribute("value_order_search", orderSearch);
        return "/admin/order/orderSearch";
    }

    @PostMapping("/admin/search")
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

        return "/admin/products";
    }
}
