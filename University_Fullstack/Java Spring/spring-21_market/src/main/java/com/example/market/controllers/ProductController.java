package com.example.market.controllers;

import com.example.market.repositories.ProductRepository;
import com.example.market.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;
    private final ProductRepository productRepository;

    public ProductController(ProductService productService, ProductRepository productRepository) {
        this.productService = productService;
        this.productRepository = productRepository;
    }

    @GetMapping("")
    public String getAllProduct(Model model){
        model.addAttribute("products", productService.getAllProduct());
        return "/product/products";
    }

    @GetMapping("/info/{id}")
    public String productInfo(@PathVariable("id") int id, Model model){
        model.addAttribute("product", productService.getProductId(id));
        return "/product/info";
    }

    @PostMapping("/search")
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

        return "product/products";
    }
}
