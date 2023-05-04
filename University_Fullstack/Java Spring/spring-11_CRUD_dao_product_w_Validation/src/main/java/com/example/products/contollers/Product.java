package com.example.products.contollers;

import com.example.products.dao.DaoProduct;
import com.example.products.enumm.Provider;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class Product {
    private final DaoProduct daoProduct;

    public Product(DaoProduct daoProduct) {
        this.daoProduct = daoProduct;
    }

    //product/add?name=Молоко&price=170&weight=2&provider=agroprom
    //product/add?name=Хлеб&price=40&weight=1&provider=bars


//    @GetMapping("/product/add") //get param and addProduct to ArrayList DAO
//    public void addProduct(
//            @RequestParam(value = "name", required = false) String name,
//            @RequestParam(value = "price", required = false) float price,
//            @RequestParam(value = "weight", required = false) String weight,
//            @RequestParam(value = "provider", required = false) Provider provider){
//        daoProduct.addProduct(name, price, weight, provider);
//    }


    @GetMapping("/product") //get productList and return view/#
    public String index(Model model) {
        model.addAttribute("product", daoProduct.getProductList());
        return "product";
    }

    @GetMapping("/product/{id}")
    public String productInfo (@PathVariable("id") int id, Model model) {
        model.addAttribute("product", daoProduct.getProductId(id));
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
            @Valid com.example.products.models.Product product,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "add_product";
        }
        daoProduct.addProduct(product);
        System.out.println(product.getName());
        System.out.println(product.getProvider());
        System.out.println(product.getProvider().getClass());
        return "redirect:/product";
    }

    @GetMapping("/product/edit/{id}") //get obj(id) for redaction and return form view
    public String editProduct(@PathVariable("id") int id, Model model) {
        model.addAttribute("editProduct", daoProduct.getProductId(id));
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
        daoProduct.updateProduct(id, product);
        return "redirect:/product";
    }

    @GetMapping("product/delete/{id}")
    public String deleteProduct(@PathVariable("id") int id) {
        daoProduct.removeProduct(id);
        return "redirect:/product";
    }
}
