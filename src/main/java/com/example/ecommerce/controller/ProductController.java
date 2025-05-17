package com.example.ecommerce.controller;

import com.example.ecommerce.model.Product;
import com.example.ecommerce.service.ProductService;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public void addProduct(@RequestBody Product product) {
        productService.addProduct(product);
    }

    @PutMapping("/{name}")
    public void updateProduct(@PathVariable String name, @RequestBody Product updatedProduct) {
        productService.updateProduct(name, updatedProduct);
    }

    @DeleteMapping("/{name}")
    public void deleteProduct(@PathVariable String name) {
        productService.deleteProduct(name);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{name}")
    public Product getProduct(@PathVariable String name) {
        return productService.getProduct(name);
    }
}

