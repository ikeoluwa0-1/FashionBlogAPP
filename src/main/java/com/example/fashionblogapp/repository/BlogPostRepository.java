package com.example.fashionblogapp.repository;

import com.example.fashionblogapp.Entities.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BlogPostRepository extends JpaRepository<BlogPost, Long>{
boolean existsBlogPostById(Long id);
}
