package com.example.fashionblogapp.repository;

import com.example.fashionblogapp.Entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {


    @Query(value = "SELECT admin FROM Admin  admin  WHERE admin.email = ?1 AND admin.password = ?2")
    Admin findByEmailAndPassword (String email, String password);
   Admin findByEmail(String email);
}
