package com.example.market.controllers;

import com.example.market.models.Category;
import com.example.market.models.Image;
import com.example.market.models.Product;
import com.example.market.repositories.CategoryRepository;
import com.example.market.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class AdminController {

    private final ProductService productService;


    @Value("${upload.path}")
    private String uploadPath;

    private final CategoryRepository categoryRepository;

    public AdminController(ProductService productService, CategoryRepository categoryRepository) {
        this.productService = productService;
        this.categoryRepository = categoryRepository;
    }


    @GetMapping("/admin")
    public String admin(Model model){
        model.addAttribute("products", productService.getAllProduct());

        return "admin";
    }

    @GetMapping("/admin/product/add")
    public String addProduct(Model model){
        model.addAttribute("product", new Product());
        model.addAttribute("category", categoryRepository.findAll());
        return "product/addProduct";
    }

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



}
