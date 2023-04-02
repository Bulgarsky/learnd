package com.example.products.contollers;

import com.example.products.enumm.Provider;
import com.example.products.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;



@Controller
//@RequestMapping("/product")

public class Product {
    private final ProductService productService;

    @Autowired
    public Product(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product") //get productList and return view/#
    public String index(Model model) {
        model.addAttribute("product", productService.getProducts());
        return "product";
    }

    @GetMapping("/product/{id}")
    public String productInfo (@PathVariable("id") int id, Model model) {
        model.addAttribute("product", productService.getProductId(id));
        return "product_info";
    }

    @GetMapping("/product/add") //form view
    public String addProduct(Model model) {
        model.addAttribute("product", new com.example.products.models.Product());
        return "add_product";
    }

    @PostMapping("/product/add") //submit form and safe product
    public String newProduct(
            @ModelAttribute("product")
            @Valid com.example.products.models.Product newProduct,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "add_product";
        }
        productService.addProduct(newProduct);
        return "redirect:/product";
    }

    @GetMapping("/product/edit/{id}") //get obj(id) for redaction and return form view
    public String editProduct(@PathVariable("id") int id, Model model) {
        model.addAttribute("editProduct", productService.getProductId(id));
        return "edit_product";
    }

    @PostMapping("/product/edit/{id}") //get obj(id) for redaction and return form view
    public String updateEditProduct(
            @ModelAttribute("editProduct")
            @Valid com.example.products.models.Product product,
            BindingResult bindingResult,
            @PathVariable("id") int id) {
        if (bindingResult.hasErrors()) {
            return "edit_product";
        }
        productService.editProduct(id, product);
        return "redirect:/product";
    }

    @GetMapping("product/delete/{id}")
    public String deleteProduct(@PathVariable("id") int id) {
        productService.deleteProduct(id);
        return "redirect:/product";
    }
}
