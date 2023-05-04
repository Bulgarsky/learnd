package com.example.market.services;

import com.example.market.models.Cart;
import com.example.market.repositories.CartRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    private final CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    //найти корзину по пользоватлю(id)
    public List<Cart> findByPersonId(int id){
       List<Cart> cart_db = cartRepository.findByPersonId(id);
       return cart_db;
    }

    //сохранить корзину +
    public void saveCart(Cart cart){
        cartRepository.save(cart);
    }

    //удалить товары из корзины +
    public void deleteItemFromCart(int id){
        cartRepository.deleteCartByProductId(id);
    }
}
