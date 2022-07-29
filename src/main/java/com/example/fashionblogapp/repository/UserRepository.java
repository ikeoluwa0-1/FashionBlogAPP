package com.example.fashionblogapp.repository;

import com.example.fashionblogapp.DTO.UserDTO;
import com.example.fashionblogapp.Entities.Admin;
import com.example.fashionblogapp.Entities.Users;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Long>{

        Users findUsersByEmailAndPassword (String email, String password);
        @Query(value = "SELECT * FROM Users WHERE email = ? AND password = ?", nativeQuery = true)
        Users findByEmailAndPassword(String email, String password);
        Users findUsersByEmail(String email);
}

