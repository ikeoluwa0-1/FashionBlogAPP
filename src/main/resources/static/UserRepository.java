package com.example.fashionblogapp.Repository;

import com.example.fashionblogapp.Entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
}
