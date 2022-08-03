package com.example.fashionblogapp.Service.ServiceImpl;//package com.example.fashionblogapp.Service.ServiceImpl;

import com.example.fashionblogapp.DTO.CommentDTO;
import com.example.fashionblogapp.DTO.LikeDTO;
import com.example.fashionblogapp.DTO.UserDTO;
import com.example.fashionblogapp.Entities.*;
import com.example.fashionblogapp.Service.UserService;
import com.example.fashionblogapp.repository.BlogPostRepository;
import com.example.fashionblogapp.repository.CommentRepository;
import com.example.fashionblogapp.repository.LikeRepository;
import com.example.fashionblogapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;

    private final BlogPostRepository blogPostRepository;

    private final HttpSession httpSession;

    private final CommentRepository commentRepository;

    private final LikeRepository likeRepository;


    @Override
    public String createUser(UserDTO userDTO) {
        Users userInDb = userRepository.findUsersByEmail(userDTO.getEmail());
        if (userInDb != null)
            throw new RuntimeException("User already exist!");

        Users users = new Users();
        users.setPassword(userDTO.getPassword());
        users.setEmail(userDTO.getEmail());
        users.setFirstName(userDTO.getFirstName());
        users.setLastName(userDTO.getLastName());
        users.setUserName(userDTO.getUserName());
        userRepository.save(users);
        return "Successfully signed in as a Customer!";

    }


    @Override
    public Users login(String email, String password) {

        if (userRepository.findUsersByEmailAndPassword(email, password) == null) {
            throw new RuntimeException("Invalid Username and/or Password");
        }
        Users users = userRepository.findUsersByEmailAndPassword(email, password);
        httpSession.setAttribute("users", users.getId());

        return users;

    }

    @Override
    public Page viewBlogPost(Pagination pagination) {
        Sort sort = Sort.by(pagination.getSortDirection(), pagination.getSortBy());
        Pageable pageable = PageRequest.of(pagination.getPageNumber(), pagination.getPageSize(), sort);
        Page<BlogPost> blogPost = blogPostRepository.findAll(pageable);
        return blogPost;
    }


    @Override
    public String commentOnBlogPost(Long postId, CommentDTO commentDTO) {
        if (httpSession.getAttribute("users").equals(null)) {
            throw new RuntimeException("Login First");
        }
        Comment comment = new Comment();
        if (commentRepository.existsCommentById(comment.getId())) {
            throw new RuntimeException("You have a comment on this post!");
        } else {
            BeanUtils.copyProperties(commentDTO, comment);
            commentRepository.save(comment);
            return "Comment successfully posted";
        }


    }

    @Override
    public Integer like(LikeDTO likeDTO) {
        int count = 0;
        if (httpSession.getAttribute("users").equals(null)) {
            throw new RuntimeException("Login First");
        }
        Likes like = new Likes();
        if (likeRepository.existsLikesById(like.getId())) {
            throw new RuntimeException("This Blog Post is already liked by you!");
        } else {
            BeanUtils.copyProperties(likeDTO, like);
            likeRepository.save(like);
            count++;

        }
        return count;

    }
}








