package com.example.ecommerce.exception;

public class NotEnoughBudgetException  extends RuntimeException{

    public NotEnoughBudgetException(String userId) {
        super("User " + userId + " does not have enough budget.");
    }
}
