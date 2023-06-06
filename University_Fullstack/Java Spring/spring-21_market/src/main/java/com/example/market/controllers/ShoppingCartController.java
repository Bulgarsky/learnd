package com.example.market.controllers;

import com.example.market.models.Cart;
import com.example.market.models.Product;
import com.example.market.security.PersonDetails;
import com.example.market.services.CartService;
import com.example.market.services.ProductService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ShoppingCartController {
    private final ProductService productService;
    private final CartService cartService;
    private final AuthenticationController authController;

    public ShoppingCartController(ProductService productService, CartService cartService, AuthenticationController authController) {
        this.productService = productService;
        this.cartService = cartService;
        this.authController = authController;
    }

    //Корзина: добавить товар в корзину
    @GetMapping("/cart/add/{id}")
    public String addProductInCart(
            @PathVariable("id")int id){
        //получить продукт по id
        Product product = productService.getProductId(id);


        //формируем новую корзину
        Cart cart = new Cart(authController.getCurrentAuthPerson().getId(), product.getId());
        //cохраняем корзину
        cartService.saveCart(cart);

        return "redirect:/index";
    }

    //Корзина: формирование
    @GetMapping("/cart")
    public String cart(Model model) {
        List<Cart> cartList = cartService.findByPersonId(authController.getCurrentAuthPerson().getId());
        List<Product> productList = new ArrayList<>();

        //переборка элементов корзина
        for (Cart item: cartList) {
            productList.add(productService.getProductId(item.getProductId()));
        }
        //итог корзины
        float totalPrice= 0;
        for (Product item: productList) {
            totalPrice += item.getPrice();
        }
        model.addAttribute("total_price", totalPrice);
        model.addAttribute("cart_product", productList);
        model.addAttribute("products_count", productList.size());

        return "/shoppingCart";
    }

    //КОРЗИНА: удалить товары по id
    @GetMapping("/cart/delete/{id}")
    public String deleteProductFromCart(@PathVariable("id") int id){
        List<Cart> cartList = cartService.findByPersonId(authController.getCurrentAuthPerson().getId());
        List<Product> productList = new ArrayList<>();

        //получить продукты из корзины по id товара
        for (Cart item: cartList) {
            productList.add(productService.getProductId(item.getProductId()));
        }

        cartService.deleteItemFromCart(id);

        return "redirect:/cart";
    }

}
