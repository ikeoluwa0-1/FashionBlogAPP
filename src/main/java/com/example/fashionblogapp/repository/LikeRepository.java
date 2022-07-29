package com.example.fashionblogapp.repository;

import com.example.fashionblogapp.Entities.Likes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Likes, Long> {
    boolean existsLikesById(Long Id);

}
