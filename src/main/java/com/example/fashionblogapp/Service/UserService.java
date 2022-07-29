package com.example.fashionblogapp.Service;

import com.example.fashionblogapp.DTO.BlogPostDTO;
import com.example.fashionblogapp.DTO.CommentDTO;
import com.example.fashionblogapp.DTO.LikeDTO;
import com.example.fashionblogapp.DTO.UserDTO;
import com.example.fashionblogapp.Entities.Pagination;
import com.example.fashionblogapp.Entities.Users;
import org.springframework.data.domain.Page;

public interface UserService {
    public String createUser(UserDTO userDTO);

    Users login(String email, String password);

    Page viewBlogPost(Pagination pagination);

    String commentOnBlogPost( Long postId, CommentDTO commentDTO);

    Integer like(LikeDTO likeDTO);
}
