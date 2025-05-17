package com.example.ecommerce.exception;

public class OutOfStockException extends RuntimeException{

    public OutOfStockException(String name) {
        super("Product out of stock: " + name);
    }
}
