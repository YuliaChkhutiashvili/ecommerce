package com.example.ecommerce.service;

import com.example.ecommerce.model.Product;

import java.util.List;

public interface ProductService {
    void addProduct(Product product);
    void updateProduct(String name, Product updated);
    void deleteProduct(String name);
    List<Product> getAllProducts();
    Product getProduct(String name);

}
