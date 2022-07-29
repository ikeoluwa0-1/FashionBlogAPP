package com.example.fashionblogapp.Repository;

import com.example.fashionblogapp.Entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
   public Admin findAdminByEmail(String email);
}
