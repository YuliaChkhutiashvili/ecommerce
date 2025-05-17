package com.example.ecommerce.controller;

import com.example.ecommerce.dto.UserRegistrationRequest;
import com.example.ecommerce.model.Product;
import com.example.ecommerce.model.User;
import com.example.ecommerce.service.ProductService;
import com.example.ecommerce.service.UserService;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;
    private final ProductService productService;

    public AdminController(UserService userService, ProductService productService) {
        this.userService = userService;
        this.productService = productService;
    }

    @PostMapping("/add-admin")
    public void addAdmin(@RequestBody UserRegistrationRequest request) {
        User user = new User(request.getId(), request.getEmail(), "admin");
        userService.registerUser(user);
    }

    @PostMapping
    public void addProduct(@RequestBody Product product) {
        productService.addProduct(product);
    }




}

