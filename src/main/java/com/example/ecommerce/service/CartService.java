package com.example.ecommerce.service;

import com.example.ecommerce.model.Product;

import java.util.List;
public interface CartService {
    void addToCart(String userId, String productName);

    void removeFromCart(String userId, String productName);

    void clearCart(String userId);

    List<Product> viewCart(String userId);

    void orderSelectedFromCart(String userId, List<String> selectedProductNames);
}
