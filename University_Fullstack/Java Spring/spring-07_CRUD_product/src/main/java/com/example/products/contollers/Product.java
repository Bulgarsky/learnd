package com.example.products.contollers;

import com.example.products.dao.DaoProduct;
import com.example.products.enumm.Provider;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Product {
    private final DaoProduct daoProduct;

    public Product(DaoProduct daoProduct) {
        this.daoProduct = daoProduct;
    }

    //product/add?name=Молоко&price=170&weight=2&provider=agroprom
    //product/add?name=Хлеб&price=40&weight=1&provider=bars

    /*
    @GetMapping("/product/add") //get param and addProduct to ArrayList DAO
    public void addProduct(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "price", required = false) float price,
            @RequestParam(value = "weight", required = false) String weight,
            @RequestParam(value = "provider", required = false) Provider provider){
        daoProduct.addProduct(name, price, weight, provider);
    }
    */

    @GetMapping("/product") //get productList and return view
    public String index(Model model) {
        model.addAttribute("product", daoProduct.getProductList());
        return "product";
    }

    @GetMapping("/product/{id}")
    public String productInfo (@PathVariable("id") int id, Model model) {
        model.addAttribute("product", daoProduct.getProductId(id));
        return "product_info";
    }

    @GetMapping("/product/add")
    public String addProduct(Model model) {
        model.addAttribute("product", new com.example.products.models.Product());
        return "add_product";
    }
}
