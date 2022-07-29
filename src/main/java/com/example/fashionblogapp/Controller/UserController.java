package com.example.fashionblogapp.Controller;

import com.example.fashionblogapp.DTO.AdminDTO;
import com.example.fashionblogapp.DTO.CommentDTO;
import com.example.fashionblogapp.DTO.LikeDTO;
import com.example.fashionblogapp.DTO.UserDTO;
import com.example.fashionblogapp.Entities.Admin;
import com.example.fashionblogapp.Entities.BlogPost;
import com.example.fashionblogapp.Entities.Pagination;
import com.example.fashionblogapp.Entities.Users;
import com.example.fashionblogapp.Service.ServiceImpl.AdminServiceImpl;
import com.example.fashionblogapp.Service.ServiceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RequestMapping("api/v1/users")
@RestController
public class UserController {

    private final HttpSession httpSession;

    @Autowired
    UserServiceImpl userService;

    public UserController(HttpSession httpSession) {
        this.httpSession = httpSession;
    }

    @PostMapping("/createUser")
    public String createUser(@RequestBody UserDTO userInDb){
        return userService.createUser(userInDb);
    }
    @PostMapping("/login")
    public String login(@RequestParam("email") String email, @RequestParam("password") String password) {
        Users oauthUsers = userService.login(email, password);
        httpSession.setAttribute("users_id", oauthUsers.getId());
        return "Welcome " + oauthUsers.getFirstName() + "!";
    }


    @GetMapping("/viewBlogPost")
    public ResponseEntity<Page> viewBlogPost(Pagination pagination){
        return new ResponseEntity<>(userService.viewBlogPost(pagination), HttpStatus.OK);
    }

    @PostMapping("/CommentOnBlogPost/{id}")
    public ResponseEntity<?> commentOnBlogPost(@PathVariable("id") Long postId, CommentDTO commentDTO){
        return new ResponseEntity<>(userService.commentOnBlogPost(postId, commentDTO), HttpStatus.OK);
    }

    @PostMapping("/LikeBlogPost/{id}")
    public ResponseEntity<?> likeBlogPost(@PathVariable("id") LikeDTO likeDTO){
        return new ResponseEntity<>(userService.like(likeDTO), HttpStatus.OK);
    }


    @GetMapping("/logout")
    public String logout() {
        if (httpSession.getAttribute("users_id") == null) {
            return "You are no longer logged in!";
        } else {
            httpSession.invalidate();
            return "Successfully logged out!";
        }
    }



    }
