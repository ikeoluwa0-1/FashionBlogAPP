package com.example.fashionblogapp.CustomExceptions;


import com.example.fashionblogapp.Entities.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalErrorHandler {

    @ExceptionHandler(AdminNotFound.class)
    public ResponseEntity<ErrorResponse> handlerForAdminNotFound(final AdminNotFound ex){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(ex.getMessage());

        errorResponse.setHttpStatus(HttpStatus.BAD_REQUEST);
        return ResponseEntity.ok(errorResponse);
    }


    @ExceptionHandler(BlogPostNotFound.class)
    public ResponseEntity<ErrorResponse> handlerForBlogPostNotFound(final BlogPostNotFound ex){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(ex.getMessage());

        errorResponse.setHttpStatus(HttpStatus.BAD_REQUEST);
        return ResponseEntity.ok(errorResponse);
    }


    @ExceptionHandler(CategoryNotFound.class)
    public ResponseEntity<ErrorResponse> CategoryNotFound(final CategoryNotFound ex){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(ex.getMessage());

        errorResponse.setHttpStatus(HttpStatus.BAD_REQUEST);
        return ResponseEntity.ok(errorResponse);
    }



    @ExceptionHandler(UserNotFound.class)
    public ResponseEntity<ErrorResponse> UserNotFound(final UserNotFound ex){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(ex.getMessage());

        errorResponse.setHttpStatus(HttpStatus.BAD_REQUEST);
        return ResponseEntity.ok(errorResponse);
    }
}
