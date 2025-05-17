package com.example.ecommerce.service;

import com.example.ecommerce.model.Product;
import com.example.ecommerce.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImpl implements  CartService{


    private final UserService userService;
    private final ProductService productService;

    public CartServiceImpl(UserService userService, ProductService productService) {
        this.userService = userService;
        this.productService = productService;
    }

    @Override
    public void addToCart(String userId, String productName) {
        User user = userService.getUser(userId);
        Product product = productService.getProduct(productName);
        user.addToCart(product);
    }

    @Override
    public void removeFromCart(String userId, String productName) {
        User user = userService.getUser(userId);
        user.getCart().remove(productName);
    }

    @Override
    public void clearCart(String userId) {
        User user = userService.getUser(userId);
        user.clearCart();
    }

    @Override
    public List<Product> viewCart(String userId) {
        User user = userService.getUser(userId);
        return new ArrayList<>(user.getCart().values());
    }
    @Override
    public void orderSelectedFromCart(String userId, List<String> selectedProductNames) {
        throw new UnsupportedOperationException("Use UserService for ordering logic");
    }
}
