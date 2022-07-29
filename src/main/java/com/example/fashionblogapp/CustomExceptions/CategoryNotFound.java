package com.example.fashionblogapp.CustomExceptions;

public class CategoryNotFound extends RuntimeException{
    public CategoryNotFound(String message) {
        super(message);
    }
}
