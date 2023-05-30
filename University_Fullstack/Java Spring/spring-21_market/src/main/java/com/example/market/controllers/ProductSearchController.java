package com.example.market.controllers;

import com.example.market.models.Product;
import com.example.market.repositories.ProductRepository;
import com.example.market.security.PersonDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductSearchController {
    private final ProductRepository productRepository;

    public ProductSearchController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //большой поиск товаров (работает)
    @PostMapping("/search/")
    public String productSearch(
            @RequestParam("titleRequest") String titleRequest,
            @RequestParam("priceFrom") String priceFrom,
            @RequestParam("priceTo") String priceTo,
            @RequestParam(value="priceSort", required = false, defaultValue = "") String priceSort,
            @RequestParam(value="categorySelect", required = false, defaultValue = "") String categorySelect,
            Model model){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();
        List<Product> productFoundList = new ArrayList<>();
        //3
        //по части названия, цене "от и до", категория или без нее, с сортировкой
        if(!titleRequest.isEmpty()) {
            if (!priceFrom.isEmpty() & !priceTo.isEmpty()) {
                if (priceSort.equals("priceSortByASC")) {
                    if (!categorySelect.isEmpty()) {
                        switch (categorySelect) {
                            case "furniture" ->
                                    productFoundList = productRepository.findByTitleAndCategoryOrderByPriceAsc(titleRequest, Float.parseFloat(priceFrom), Float.parseFloat(priceTo), 1);
                            case "clothes" ->
                                    productFoundList = productRepository.findByTitleAndCategoryOrderByPriceAsc(titleRequest, Float.parseFloat(priceFrom), Float.parseFloat(priceTo), 2);
                            case "appliance" ->
                                    productFoundList = productRepository.findByTitleAndCategoryOrderByPriceAsc(titleRequest, Float.parseFloat(priceFrom), Float.parseFloat(priceTo), 3);
                        }
                    } else {
                        productFoundList = productRepository.findByTitleOrderByPriceAsc(titleRequest, Float.parseFloat(priceFrom), Float.parseFloat(priceTo));
                    }
                } else {
                    //desc
                    if (!categorySelect.isEmpty()) {
                        switch (categorySelect) {
                            case "furniture" ->
                                    productFoundList = productRepository.findByTitleAndCategoryOrderByPriceDesc(titleRequest, Float.parseFloat(priceFrom), Float.parseFloat(priceTo), 1);
                            case "clothes" ->
                                    productFoundList = productRepository.findByTitleAndCategoryOrderByPriceDesc(titleRequest, Float.parseFloat(priceFrom), Float.parseFloat(priceTo), 2);
                            case "appliance" ->
                                    productFoundList = productRepository.findByTitleAndCategoryOrderByPriceDesc(titleRequest, Float.parseFloat(priceFrom), Float.parseFloat(priceTo), 3);
                        }
                    } else {
                        productFoundList = productRepository.findByTitleOrderByPriceDesc(titleRequest, Float.parseFloat(priceFrom), Float.parseFloat(priceTo));
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
                                productFoundList = productRepository.findByTitleContainingIgnoreCaseAndCategoryOrderByPriceAsc(titleRequest, 1);
                        case "clothes" ->
                                productFoundList = productRepository.findByTitleContainingIgnoreCaseAndCategoryOrderByPriceAsc(titleRequest,2);
                        case "appliance" ->
                                productFoundList = productRepository.findByTitleContainingIgnoreCaseAndCategoryOrderByPriceAsc(titleRequest,3);
                    }
                } else {
                    switch (categorySelect) {
                        case "furniture" ->
                                productFoundList = productRepository.findByTitleContainingIgnoreCaseAndCategoryOrderByPriceDesc(titleRequest, 1);
                        case "clothes" ->
                                productFoundList = productRepository.findByTitleContainingIgnoreCaseAndCategoryOrderByPriceDesc(titleRequest,2);
                        case "appliance" ->
                                productFoundList = productRepository.findByTitleContainingIgnoreCaseAndCategoryOrderByPriceDesc(titleRequest,3);
                    }
                }
            } else {
                productFoundList = productRepository.findByTitleContainingIgnoreCase(titleRequest);
            }
        }

        //1
        //по части названия и сортировка по цене
        if(!titleRequest.isEmpty() & (priceSort.isEmpty() || priceSort.equals("priceSortByASC"))) {
            productFoundList = productRepository.findByTitleContainingIgnoreCaseOrderByPriceAsc(titleRequest);
        } else
        if (!titleRequest.isEmpty() & priceSort.equals("priceSortByDESC")) {
            productFoundList = productRepository.findByTitleContainingIgnoreCaseOrderByPriceDesc(titleRequest);
        }

        //1
        //по категории (остальные графы пустые) и сортировка по цене
        if(!categorySelect.isEmpty() & (priceSort.equals("priceSortByASC") || priceSort.isEmpty())){
            switch (categorySelect) {
                case "furniture" ->
                        productFoundList = productRepository.findByCategoryAndOrderByPriceAsc(1);
                case "clothes" ->
                        productFoundList = productRepository.findByCategoryAndOrderByPriceAsc(2);
                case "appliance" ->
                        productFoundList = productRepository.findByCategoryAndOrderByPriceAsc(3);
            }
        } else if (!categorySelect.isEmpty() & priceSort.equals("priceSortByDESC")){
            switch (categorySelect) {
                case "furniture" ->
                        productFoundList = productRepository.findByCategoryAndOrderByPriceDesc(1);
                case "clothes" ->
                        productFoundList = productRepository.findByCategoryAndOrderByPriceDesc(2);
                case "appliance" ->
                        productFoundList = productRepository.findByCategoryAndOrderByPriceDesc(3);
            }
        }

        //2
        //по цене "от и до", категории и сортировка по цене
        if(!priceFrom.isEmpty() & !priceTo.isEmpty() & !categorySelect.isEmpty() & (priceSort.equals("priceSortByASC") || priceSort.isEmpty())){
            switch(categorySelect){
                case "furniture" ->
                        productFoundList = productRepository.findByCategoryAndPriceAndOrderByPriceAsc(Float.parseFloat(priceFrom), Float.parseFloat(priceTo), 1);
                case "clothes" ->
                        productFoundList = productRepository.findByCategoryAndPriceAndOrderByPriceAsc(Float.parseFloat(priceFrom), Float.parseFloat(priceTo), 2);
                case "appliance" ->
                        productFoundList = productRepository.findByCategoryAndPriceAndOrderByPriceAsc(Float.parseFloat(priceFrom), Float.parseFloat(priceTo), 3);
            }
        } else if(!priceFrom.isEmpty() & !priceTo.isEmpty() & !categorySelect.isEmpty() & priceSort.equals("priceSortByDESC")) {
            switch (categorySelect) {
                case "furniture" ->
                        productFoundList = productRepository.findByCategoryAndPriceAndOrderByPriceDesc(Float.parseFloat(priceFrom), Float.parseFloat(priceTo), 1);
                case "clothes" ->
                        productFoundList = productRepository.findByCategoryAndPriceAndOrderByPriceDesc(Float.parseFloat(priceFrom), Float.parseFloat(priceTo), 2);
                case "appliance" ->
                        productFoundList = productRepository.findByCategoryAndPriceAndOrderByPriceDesc(Float.parseFloat(priceFrom), Float.parseFloat(priceTo), 3);
            }
        }

        //1
        //по цене "от и до" и сортировка по цене
        if(!priceFrom.isEmpty() & !priceTo.isEmpty() & (priceSort.equals("priceSortByASC") || priceSort.isEmpty())){
            productFoundList = productRepository.findByPriceAndOrderByPriceAsc(Float.parseFloat(priceFrom), Float.parseFloat(priceTo));
        } else if (!priceFrom.isEmpty() & !priceTo.isEmpty() & (priceSort.equals("priceSortByDESC"))){
            productFoundList = productRepository.findByPriceAndOrderByPriceDesc(Float.parseFloat(priceFrom), Float.parseFloat(priceTo));
        }

        int foundCount=0;
        for (Product product: productFoundList){
            foundCount+=1;
        }

        model.addAttribute("foundCount", foundCount);
        model.addAttribute("productFoundList", productFoundList);
        model.addAttribute("value_priceSort", priceSort);
        model.addAttribute("value_titleTyped", titleRequest);
        model.addAttribute("value_priceFrom", priceFrom);
        model.addAttribute("value_priceTo", priceTo);

        switch (personDetails.getPerson().getRole()) {
            case "ROLE_USER" -> {
                return "user/userSearch";
            }
            case "ROLE_ADMIN" -> {
                return "admin/adminSearch";
            }
            case "ROLE_SELLER" -> {
                return "seller/sellerSearch";
            }
        }

        return "/404";
    }

    //поиск по тайтлу
    @GetMapping("/search/title")
    public String search(Model model
    ){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();
//        int id_person = personDetails.getPerson().getId();
        model.addAttribute("userAuth", personDetails.getPerson());
        String role = personDetails.getPerson().getRole();
        switch (role) {
            case "ROLE_USER" -> {
                return "user/userSearch";
            }
            case "ROLE_ADMIN" -> {
                return "admin/adminSearch";
            }
            case "ROLE_SELLER" -> {
                return "seller/sellerSearch";
            }
        }

        return "/404";
    }

    //поиск по тайтлу (возврат результата)
    @PostMapping("/search/title")
    public String productSearchByTitle(
            @RequestParam("byTitleRequest") String byTitleRequest,
            Model model
    ){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();

        List<Product> productFoundByTitle = new ArrayList<>();

        if (!byTitleRequest.isEmpty()){
            productFoundByTitle = productRepository.findByTitleContainingIgnoreCaseOrderByPriceAsc(byTitleRequest);
            }
        int foundCount=0;
        for (Product product: productFoundByTitle){
            foundCount+=1;
        }

        model.addAttribute("userAuth", personDetails.getPerson());
        model.addAttribute("foundCount", foundCount);
        model.addAttribute("titleTyped", byTitleRequest);
        model.addAttribute("productFoundList", productFoundByTitle);

        switch (personDetails.getPerson().getRole()) {
            case "ROLE_USER" -> {
                return "user/userSearch";
            }
            case "ROLE_ADMIN" -> {
                return "admin/adminSearch";
            }
        }
        return "/404";
    }


    //поиск по заголовку для NOT AUTH
    @GetMapping("/notauth/search/title")
    public String NotAuthSearch(Model model){
        return "/NotAuthSearch";
    }
    @PostMapping("/notauth/search/title")
    public String NotAuthSearchByTitle(
            @RequestParam("byTitleRequest") String byTitleRequest,
            Model model
    ){
       List<Product> productFoundByTitle = new ArrayList<>();

        if (!byTitleRequest.isEmpty()){
            productFoundByTitle = productRepository.findByTitleContainingIgnoreCaseOrderByPriceAsc(byTitleRequest);
        }

        int foundCount=0;
        for (Product product: productFoundByTitle){
            foundCount+=1;
        }

        model.addAttribute("foundCount", foundCount);
        model.addAttribute("titleTyped", byTitleRequest);
        model.addAttribute("productFoundList", productFoundByTitle);


        return "/NotAuthSearch";
    }

    //поиск для товара  для NOT AUTH
    @PostMapping("/notauth/search")
    public String NotAuthSearch(
            @RequestParam("titleRequest") String titleRequest,
            @RequestParam("priceFrom") String priceFrom,
            @RequestParam("priceTo") String priceTo,
            @RequestParam(value="priceSort", required = false, defaultValue = "") String priceSort,
            @RequestParam(value="categorySelect", required = false, defaultValue = "") String categorySelect,
            Model model){
        List<Product> productFoundList = new ArrayList<>();
        //3
        //по части названия, цене "от и до", категория или без нее, с сортировкой
        if(!titleRequest.isEmpty()) {
            if (!priceFrom.isEmpty() & !priceTo.isEmpty()) {
                if (priceSort.equals("priceSortByASC")) {
                    if (!categorySelect.isEmpty()) {
                        switch (categorySelect) {
                            case "furniture" ->
                                    productFoundList = productRepository.findByTitleAndCategoryOrderByPriceAsc(titleRequest, Float.parseFloat(priceFrom), Float.parseFloat(priceTo), 1);
                            case "clothes" ->
                                    productFoundList = productRepository.findByTitleAndCategoryOrderByPriceAsc(titleRequest, Float.parseFloat(priceFrom), Float.parseFloat(priceTo), 2);
                            case "appliance" ->
                                    productFoundList = productRepository.findByTitleAndCategoryOrderByPriceAsc(titleRequest, Float.parseFloat(priceFrom), Float.parseFloat(priceTo), 3);
                        }
                    } else {
                        productFoundList = productRepository.findByTitleOrderByPriceAsc(titleRequest, Float.parseFloat(priceFrom), Float.parseFloat(priceTo));
                    }
                } else {
                    //desc
                    if (!categorySelect.isEmpty()) {
                        switch (categorySelect) {
                            case "furniture" ->
                                    productFoundList = productRepository.findByTitleAndCategoryOrderByPriceDesc(titleRequest, Float.parseFloat(priceFrom), Float.parseFloat(priceTo), 1);
                            case "clothes" ->
                                    productFoundList = productRepository.findByTitleAndCategoryOrderByPriceDesc(titleRequest, Float.parseFloat(priceFrom), Float.parseFloat(priceTo), 2);
                            case "appliance" ->
                                    productFoundList = productRepository.findByTitleAndCategoryOrderByPriceDesc(titleRequest, Float.parseFloat(priceFrom), Float.parseFloat(priceTo), 3);
                        }
                    } else {
                        productFoundList = productRepository.findByTitleOrderByPriceDesc(titleRequest, Float.parseFloat(priceFrom), Float.parseFloat(priceTo));
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
                                productFoundList = productRepository.findByTitleContainingIgnoreCaseAndCategoryOrderByPriceAsc(titleRequest, 1);
                        case "clothes" ->
                                productFoundList = productRepository.findByTitleContainingIgnoreCaseAndCategoryOrderByPriceAsc(titleRequest,2);
                        case "appliance" ->
                                productFoundList = productRepository.findByTitleContainingIgnoreCaseAndCategoryOrderByPriceAsc(titleRequest,3);
                    }
                } else {
                    switch (categorySelect) {
                        case "furniture" ->
                                productFoundList = productRepository.findByTitleContainingIgnoreCaseAndCategoryOrderByPriceDesc(titleRequest, 1);
                        case "clothes" ->
                                productFoundList = productRepository.findByTitleContainingIgnoreCaseAndCategoryOrderByPriceDesc(titleRequest,2);
                        case "appliance" ->
                                productFoundList = productRepository.findByTitleContainingIgnoreCaseAndCategoryOrderByPriceDesc(titleRequest,3);
                    }
                }
            } else {
                productFoundList = productRepository.findByTitleContainingIgnoreCase(titleRequest);
            }
        }

        //1
        //по части названия и сортировка по цене
        if(!titleRequest.isEmpty() & (priceSort.isEmpty() || priceSort.equals("priceSortByASC"))) {
            productFoundList = productRepository.findByTitleContainingIgnoreCaseOrderByPriceAsc(titleRequest);
        } else
        if (!titleRequest.isEmpty() & priceSort.equals("priceSortByDESC")) {
            productFoundList = productRepository.findByTitleContainingIgnoreCaseOrderByPriceDesc(titleRequest);
        }

        //1
        //по категории (остальные графы пустые) и сортировка по цене
        if(!categorySelect.isEmpty() & (priceSort.equals("priceSortByASC") || priceSort.isEmpty())){
            switch (categorySelect) {
                case "furniture" ->
                        productFoundList = productRepository.findByCategoryAndOrderByPriceAsc(1);
                case "clothes" ->
                        productFoundList = productRepository.findByCategoryAndOrderByPriceAsc(2);
                case "appliance" ->
                        productFoundList = productRepository.findByCategoryAndOrderByPriceAsc(3);
            }
        } else if (!categorySelect.isEmpty() & priceSort.equals("priceSortByDESC")){
            switch (categorySelect) {
                case "furniture" ->
                        productFoundList = productRepository.findByCategoryAndOrderByPriceDesc(1);
                case "clothes" ->
                        productFoundList = productRepository.findByCategoryAndOrderByPriceDesc(2);
                case "appliance" ->
                        productFoundList = productRepository.findByCategoryAndOrderByPriceDesc(3);
            }
        }

        //2
        //по цене "от и до", категории и сортировка по цене
        if(!priceFrom.isEmpty() & !priceTo.isEmpty() & !categorySelect.isEmpty() & (priceSort.equals("priceSortByASC") || priceSort.isEmpty())){
            switch(categorySelect){
                case "furniture" ->
                        productFoundList = productRepository.findByCategoryAndPriceAndOrderByPriceAsc(Float.parseFloat(priceFrom), Float.parseFloat(priceTo), 1);
                case "clothes" ->
                        productFoundList = productRepository.findByCategoryAndPriceAndOrderByPriceAsc(Float.parseFloat(priceFrom), Float.parseFloat(priceTo), 2);
                case "appliance" ->
                        productFoundList = productRepository.findByCategoryAndPriceAndOrderByPriceAsc(Float.parseFloat(priceFrom), Float.parseFloat(priceTo), 3);
            }
        } else if(!priceFrom.isEmpty() & !priceTo.isEmpty() & !categorySelect.isEmpty() & priceSort.equals("priceSortByDESC")) {
            switch (categorySelect) {
                case "furniture" ->
                        productFoundList = productRepository.findByCategoryAndPriceAndOrderByPriceDesc(Float.parseFloat(priceFrom), Float.parseFloat(priceTo), 1);
                case "clothes" ->
                        productFoundList = productRepository.findByCategoryAndPriceAndOrderByPriceDesc(Float.parseFloat(priceFrom), Float.parseFloat(priceTo), 2);
                case "appliance" ->
                        productFoundList = productRepository.findByCategoryAndPriceAndOrderByPriceDesc(Float.parseFloat(priceFrom), Float.parseFloat(priceTo), 3);
            }
        }

        //1
        //по цене "от и до" и сортировка по цене
        if(!priceFrom.isEmpty() & !priceTo.isEmpty() & (priceSort.equals("priceSortByASC") || priceSort.isEmpty())){
            productFoundList = productRepository.findByPriceAndOrderByPriceAsc(Float.parseFloat(priceFrom), Float.parseFloat(priceTo));
        } else if (!priceFrom.isEmpty() & !priceTo.isEmpty() & (priceSort.equals("priceSortByDESC"))){
            productFoundList = productRepository.findByPriceAndOrderByPriceDesc(Float.parseFloat(priceFrom), Float.parseFloat(priceTo));
        }

        int foundCount=0;
        for (Product product: productFoundList){
            foundCount+=1;
        }

        model.addAttribute("foundCount", foundCount);
        model.addAttribute("productFoundList", productFoundList);
        model.addAttribute("value_priceSort", priceSort);
        model.addAttribute("value_titleTyped", titleRequest);
        model.addAttribute("value_priceFrom", priceFrom);
        model.addAttribute("value_priceTo", priceTo);

        return "/NotAuthSearch";
    }

}
