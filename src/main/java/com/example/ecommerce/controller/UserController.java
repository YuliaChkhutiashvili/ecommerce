package com.example.ecommerce.controller;

import com.example.ecommerce.dto.UserRegistrationRequest;
import com.example.ecommerce.model.Product;
import com.example.ecommerce.model.User;
import com.example.ecommerce.service.CartService;
import com.example.ecommerce.service.UserService;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final CartService cartService;

    public UserController(UserService userService, CartService cartService) {
        this.userService = userService;
        this.cartService = cartService;
    }

    @PostMapping("/register")
    public void register(@RequestBody UserRegistrationRequest request) {
        User user = new User(request.getId(), request.getEmail(), request.getRole());
        userService.registerUser(user);
    }

    @PostMapping("/add-to-cart")
    public void addToCart(@RequestParam String userId, @RequestParam String productName) {
        cartService.addToCart(userId, productName);
    }

    @GetMapping("/cart")
    public List<Product> viewCart(@RequestParam String userId) {
        return cartService.viewCart(userId);
    }

    @DeleteMapping("/cart")
    public void clearCart(@RequestParam String userId) {
        cartService.clearCart(userId);
    }

    @PostMapping("/order")
    public void order(@RequestParam String userId, @RequestParam String productName) {
        userService.orderProduct(userId, productName);
    }

    @PostMapping("/order-cart")
    public void orderCart(@RequestParam String userId) {
        userService.orderAllFromCart(userId);
    }

    @PostMapping("/order-selected")
    public void orderSelectedFromCart(@RequestParam String userId, @RequestBody List<String> productNames) {
        userService.orderSelectedFromCart(userId, productNames);
    }

    @GetMapping("/orders")
    public List<Product> viewOrders(@RequestParam String userId) {
        return userService.viewOrders(userId);
    }


}