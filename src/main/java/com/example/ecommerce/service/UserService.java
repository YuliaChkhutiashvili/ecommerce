package com.example.ecommerce.service;

import com.example.ecommerce.model.Product;
import com.example.ecommerce.model.User;

import java.util.List;

public interface UserService {
    void registerUser(User user);

    void orderProduct(String userId, String productName);
    void orderAllFromCart(String userId);

    void orderSelectedFromCart(String userId, List<String> selectedProductNames);
    User getUser(String userId);


    List<Product> viewOrders(String userId);
    List<Product> getAllAvailableProducts();



}

