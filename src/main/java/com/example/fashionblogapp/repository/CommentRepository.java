package com.example.fashionblogapp.repository;

import com.example.fashionblogapp.Entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
boolean existsCommentById(Long id);
}
