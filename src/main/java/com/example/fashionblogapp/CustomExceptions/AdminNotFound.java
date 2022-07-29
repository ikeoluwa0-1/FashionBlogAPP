package com.example.fashionblogapp.CustomExceptions;

public class AdminNotFound extends RuntimeException{
    public AdminNotFound(String message) {
        super(message);
    }
}
