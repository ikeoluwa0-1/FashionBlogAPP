package com.example.fashionblogapp.Controller;


import com.example.fashionblogapp.DTO.AdminDTO;
import com.example.fashionblogapp.DTO.BlogPostDTO;
import com.example.fashionblogapp.Entities.Admin;
import com.example.fashionblogapp.Entities.BlogPost;
import com.example.fashionblogapp.Service.ServiceImpl.AdminServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@RequestMapping("api/v1")
@RestController
@RequiredArgsConstructor
public class AdminController {


    private final   HttpSession httpSession;


    private  final AdminServiceImpl adminService;


    @PostMapping("/createAdmin")
    public String createAdmin(@RequestBody AdminDTO adminInDb){
       return adminService.createAdmin(adminInDb);
    }

        @PostMapping("/login")
        public String login(@RequestParam("email") String email, @RequestParam("password") String password) {
            Admin oauthAdmin = adminService.login(email, password);
            httpSession.setAttribute("admin_id", oauthAdmin.getId());
            return "Welcome " + oauthAdmin.getFirstName() + "!";
        }

    @PostMapping("/blogPost/create")
    public ResponseEntity<?> createBlogPost(@RequestBody BlogPostDTO blogPostDTO) {
        System.out.println(blogPostDTO);
        return new ResponseEntity<>(adminService.createBlogPost(blogPostDTO), HttpStatus.OK);
    }

    @GetMapping("/logout")
    public String logout() {
        if (httpSession.getAttribute("admin_id") == null) {
            return "You are no longer logged in!";
        } else {
            httpSession.invalidate();
            return "Logout successful!";
        }
    }

    }
