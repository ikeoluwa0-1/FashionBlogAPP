package com.example.fashionblogapp.CustomExceptions;

public class BlogPostNotFound extends RuntimeException{
    public BlogPostNotFound(String message) {
        super(message);
    }
}
