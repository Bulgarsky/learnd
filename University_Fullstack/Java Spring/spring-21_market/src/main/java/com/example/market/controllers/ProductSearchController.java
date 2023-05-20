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
        List<Product> productFound = new ArrayList<>();

        //3
        //по части названия, цене "от и до", категория или без нее, с сортировкой
        if(!titleRequest.isEmpty()) {
            if (!priceFrom.isEmpty() & !priceTo.isEmpty()) {
                if (priceSort.equals("priceSortByASC")) {
                    if (!categorySelect.isEmpty()) {
                        switch (categorySelect) {
                            case "furniture" ->
                                    productFound = productRepository.findByTitleAndCategoryOrderByPriceAsc(titleRequest, Float.parseFloat(priceFrom), Float.parseFloat(priceTo), 1);
                            case "clothes" ->
                                    productFound = productRepository.findByTitleAndCategoryOrderByPriceAsc(titleRequest, Float.parseFloat(priceFrom), Float.parseFloat(priceTo), 2);
                            case "appliance" ->
                                    productFound = productRepository.findByTitleAndCategoryOrderByPriceAsc(titleRequest, Float.parseFloat(priceFrom), Float.parseFloat(priceTo), 3);
                        }
                    } else {
                        productFound = productRepository.findByTitleOrderByPriceAsc(titleRequest, Float.parseFloat(priceFrom), Float.parseFloat(priceTo));
                    }
                } else {
                    //desc
                    if (!categorySelect.isEmpty()) {
                        switch (categorySelect) {
                            case "furniture" ->
                                    productFound = productRepository.findByTitleAndCategoryOrderByPriceDesc(titleRequest, Float.parseFloat(priceFrom), Float.parseFloat(priceTo), 1);
                            case "clothes" ->
                                    productFound = productRepository.findByTitleAndCategoryOrderByPriceDesc(titleRequest, Float.parseFloat(priceFrom), Float.parseFloat(priceTo), 2);
                            case "appliance" ->
                                    productFound = productRepository.findByTitleAndCategoryOrderByPriceDesc(titleRequest, Float.parseFloat(priceFrom), Float.parseFloat(priceTo), 3);
                        }
                    } else {
                        productFound = productRepository.findByTitleOrderByPriceDesc(titleRequest, Float.parseFloat(priceFrom), Float.parseFloat(priceTo));
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
                                productFound = productRepository.findByTitleContainingIgnoreCaseAndCategoryOrderByPriceAsc(titleRequest, 1);
                        case "clothes" ->
                                productFound = productRepository.findByTitleContainingIgnoreCaseAndCategoryOrderByPriceAsc(titleRequest,2);
                        case "appliance" ->
                                productFound = productRepository.findByTitleContainingIgnoreCaseAndCategoryOrderByPriceAsc(titleRequest,3);
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
        // по цене "от и до", категории и сортировка по цене -

       if(!priceFrom.isEmpty() & !priceTo.isEmpty() & !categorySelect.isEmpty() & (priceSort.equals("priceSortByASC") || priceSort.isEmpty())){
                switch(categorySelect){
                    case "furniture" ->
                            productFound = productRepository.findByCategoryAndPriceAndOrderByPriceAsc(Float.parseFloat(priceFrom), Float.parseFloat(priceTo), 1);
                    case "clothes" ->
                            productFound = productRepository.findByCategoryAndPriceAndOrderByPriceAsc(Float.parseFloat(priceFrom), Float.parseFloat(priceTo), 2);
                    case "appliance" ->
                            productFound = productRepository.findByCategoryAndPriceAndOrderByPriceAsc(Float.parseFloat(priceFrom), Float.parseFloat(priceTo), 3);
                }
            } else if(!priceFrom.isEmpty() & !priceTo.isEmpty() & !categorySelect.isEmpty() & priceSort.equals("priceSortByDESC")) {
                switch (categorySelect) {
                    case "furniture" ->
                            productFound = productRepository.findByCategoryAndPriceAndOrderByPriceDesc(Float.parseFloat(priceFrom), Float.parseFloat(priceTo), 1);
                    case "clothes" ->
                            productFound = productRepository.findByCategoryAndPriceAndOrderByPriceDesc(Float.parseFloat(priceFrom), Float.parseFloat(priceTo), 2);
                    case "appliance" ->
                            productFound = productRepository.findByCategoryAndPriceAndOrderByPriceDesc(Float.parseFloat(priceFrom), Float.parseFloat(priceTo), 3);
                }
            }

        //1
        //по части названия и сортировка по цене +
        if(!titleRequest.isEmpty() & (priceSort.isEmpty() || priceSort.equals("priceSortByASC"))) {
            productFound = productRepository.findByTitleContainingIgnoreCaseOrderByPriceAsc(titleRequest);
        } else
        if (!titleRequest.isEmpty() & priceSort.equals("priceSortByDESC")) {
            productFound = productRepository.findByTitleContainingIgnoreCaseOrderByPriceDesc(titleRequest);
        }

        //1
        //по категории (остальные графы пустые) и сортировка по цене +

        if(!categorySelect.isEmpty()
                //& priceFrom.isEmpty() &priceTo.isEmpty() & titleRequest.isEmpty()
                & (priceSort.equals("priceSortByASC") || priceSort.isEmpty())){
            switch (categorySelect) {
                case "furniture" ->
                        productFound = productRepository.findByCategoryAndOrderByPriceAsc(1);
                case "clothes" ->
                        productFound = productRepository.findByCategoryAndOrderByPriceAsc(2);
                case "appliance" ->
                        productFound = productRepository.findByCategoryAndOrderByPriceAsc(3);
            }
        } else if (!categorySelect.isEmpty()
                //& titleRequest.isEmpty() & priceFrom.isEmpty() &priceTo.isEmpty()
                & priceSort.equals("priceSortByDESC")
        ){
            switch (categorySelect) {
                case "furniture" ->
                        productFound =  productRepository.findByCategoryAndOrderByPriceDesc(1);
                case "clothes" ->
                        productFound = productRepository.findByCategoryAndOrderByPriceDesc(2);
                case "appliance" ->
                        productFound = productRepository.findByCategoryAndOrderByPriceDesc(3);
            }
        }

        //1
        //по цене "от и до" и сортировка по цене +

        if(!priceFrom.isEmpty() & !priceTo.isEmpty() & (priceSort.equals("priceSortByASC") || priceSort.isEmpty())
        ){
            productFound = productRepository.findByPriceAndOrderByPriceAsc(Float.parseFloat(priceFrom), Float.parseFloat(priceTo));
        } else if (!priceFrom.isEmpty() & !priceTo.isEmpty() & (priceSort.equals("priceSortByDESC"))
        ){
            productFound = productRepository.findByPriceAndOrderByPriceDesc(Float.parseFloat(priceFrom), Float.parseFloat(priceTo));
        }

        model.addAttribute("value_priceSort", priceSort);
        model.addAttribute("value_titleTyped", titleRequest);
        model.addAttribute("value_priceFrom", priceFrom);
        model.addAttribute("value_priceTo", priceTo);
        model.addAttribute("userAuth", personDetails.getPerson());
        model.addAttribute("productFound", productFound);

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

        model.addAttribute("userAuth", personDetails.getPerson());
        model.addAttribute("titleTyped", byTitleRequest);
        model.addAttribute("productFound", productFoundByTitle);

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

}
