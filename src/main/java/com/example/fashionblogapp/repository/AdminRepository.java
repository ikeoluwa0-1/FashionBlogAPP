package com.example.fashionblogapp.repository;

import com.example.fashionblogapp.Entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

        Admin findAdminByEmailAndPassword (String email, String password);
    @Query(value = "SELECT * FROM Admin WHERE email = ? AND password = ?", nativeQuery = true)
    Admin findByEmailAndPassword(String email, String password);
   Admin findByEmail(String email);
}
