package com.example.market.controllers;

import com.example.market.repositories.ProductRepository;
import com.example.market.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {
    private final ProductService productService;
    private final ProductRepository productRepository;

    public ProductController(ProductService productService, ProductRepository productRepository) {
        this.productService = productService;
        this.productRepository = productRepository;
    }

    //получение всех товаров
    @GetMapping("/product")
    public String getAllProduct(Model model){
        model.addAttribute("products", productService.getAllProduct());
        return "/product/products";
    }

    //получить информацию о товаре по id
    @GetMapping("/product/info/{id}")
    public String productInfo(@PathVariable("id") int id, Model model){
        model.addAttribute("product", productService.getProductId(id));
        return "/product/info";
    }

    //поиск для товара для не зарег пользователя
    @PostMapping("/index/search")
    public String productSearch(
            @RequestParam("titleRequest") String titleRequest,
            @RequestParam("priceFrom") String priceFrom,
            @RequestParam("priceTo") String priceTo,
            @RequestParam(value="priceSort", required = false, defaultValue = "") String priceSort,
            @RequestParam(value="categorySelect", required = false, defaultValue = "") String categorySelect,
            Model model){

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
        }

        //1
        //по части названия и сортировка по цене
        if(!titleRequest.isEmpty() & (priceSort.isEmpty() || priceSort.equals("priceSortByASC"))) {
            model.addAttribute("productFound", productRepository.findByTitleContainingIgnoreCaseOrderByPriceAsc(titleRequest));
        } else
        if (!titleRequest.isEmpty() & priceSort.equals("priceSortByDESC")) {
            model.addAttribute("productFound", productRepository.findByTitleContainingIgnoreCaseOrderByPriceDesc(titleRequest));
        }

        //1
        //по категории (остальные графы пустые) и сортировка по цене
        if(!categorySelect.isEmpty() & (priceSort.equals("priceSortByASC") || priceSort.isEmpty())){
            switch (categorySelect) {
                case "furniture" ->
                        model.addAttribute("productFound", productRepository.findByCategoryAndOrderByPriceAsc(1));
                case "clothes" ->
                        model.addAttribute("productFound", productRepository.findByCategoryAndOrderByPriceAsc(2));
                case "appliance" ->
                        model.addAttribute("productFound", productRepository.findByCategoryAndOrderByPriceAsc(3));
            }
        } else if (!categorySelect.isEmpty() & priceSort.equals("priceSortByDESC")){
            switch (categorySelect) {
                case "furniture" ->
                        model.addAttribute("productFound", productRepository.findByCategoryAndOrderByPriceDesc(1));
                case "clothes" ->
                        model.addAttribute("productFound", productRepository.findByCategoryAndOrderByPriceDesc(2));
                case "appliance" ->
                        model.addAttribute("productFound", productRepository.findByCategoryAndOrderByPriceDesc(3));
            }
        }

        //2
        //по цене "от и до", категории и сортировка по цене
        if(!priceFrom.isEmpty() & !priceTo.isEmpty() & !categorySelect.isEmpty() & (priceSort.equals("priceSortByASC") || priceSort.isEmpty())){
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
        //по цене "от и до" и сортировка по цене
        if(!priceFrom.isEmpty() & !priceTo.isEmpty() & (priceSort.equals("priceSortByASC") || priceSort.isEmpty())){
            model.addAttribute("productFound", productRepository.findByPriceAndOrderByPriceAsc(Float.parseFloat(priceFrom), Float.parseFloat(priceTo)));
        } else if (!priceFrom.isEmpty() & !priceTo.isEmpty() & (priceSort.equals("priceSortByDESC"))){
            model.addAttribute("productFound", productRepository.findByPriceAndOrderByPriceDesc(Float.parseFloat(priceFrom), Float.parseFloat(priceTo)));
        }

        model.addAttribute("value_priceSort", priceSort);
        model.addAttribute("value_titleTyped", titleRequest);
        model.addAttribute("value_priceFrom", priceFrom);
        model.addAttribute("value_priceTo", priceTo);

        model.addAttribute("products", productService.getAllProduct());
        return "/index";
    }


}
