package com.example.ecommerce.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private String id;
    private String email;
    private String role; // "admin" or "user"
    private double budget = 1000.0;
    private Map<String, Product> cart = new HashMap<>();
    private Map<String, Product> orders = new HashMap<>();

    public User() {}

    public User(String id, String email, String role) {
        this.id = id;
        this.email = email;
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public Map<String, Product> getCart() {
        return cart;
    }

    public Map<String, Product> getOrders() {
        return orders;
    }

    public List<Product> getOrdersList() {
        return new ArrayList<>(orders.values());
    }

    public void setOrders(Map<String, Product> orders) {
        this.orders = orders;
    }

    public void addToCart(Product product) {
        cart.put(product.getName(), product);
    }

    public void addOrder(Product product) {
        orders.put(product.getName(), product);
    }

    public void clearCart() {
        cart.clear();
    }

    public void removeFromCart(String productName) {
        cart.remove(productName);
    }
}
