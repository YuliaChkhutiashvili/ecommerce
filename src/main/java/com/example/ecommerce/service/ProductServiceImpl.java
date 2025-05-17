package com.example.ecommerce.service;

import com.example.ecommerce.exception.ProductNotFoundException;
import com.example.ecommerce.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {

    private final Map<String, Product> productMap = new HashMap<>();




    @Override
    public void addProduct(Product product) {
        productMap.put(product.getName(), product);
    }



    @Override
    public void updateProduct(String name, Product updated) {
        if (!productMap.containsKey(name)) throw new ProductNotFoundException(name);
        productMap.put(name, updated);

    }



    @Override
    public void deleteProduct(String name) {
        if (!productMap.containsKey(name)) throw new ProductNotFoundException(name);
        productMap.remove(name);
    }

    @Override
    public List<Product> getAllProducts() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public Product getProduct(String name) {
        Product product = productMap.get(name);
        if (product == null) throw new ProductNotFoundException(name);
        return product;
    }
}
