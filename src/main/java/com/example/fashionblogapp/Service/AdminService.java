package com.example.fashionblogapp.Service;

import com.example.fashionblogapp.DTO.AdminDTO;
import com.example.fashionblogapp.DTO.BlogPostDTO;
import com.example.fashionblogapp.Entities.Admin;
import com.example.fashionblogapp.Entities.BlogPost;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public interface AdminService {
    String createAdmin(AdminDTO adminDTO);

    Admin login(String email, String password);


     String createBlogPost(BlogPostDTO blogPostDTO);

     }
