package com.example.fashionblogapp.Service.ServiceImpl;

import com.example.fashionblogapp.DTO.LikeDTO;
import com.example.fashionblogapp.DTO.UserDTO;
import com.example.fashionblogapp.Entities.Users;
import com.example.fashionblogapp.Service.UserService;
import com.example.fashionblogapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceImplTest {

    @Mock
    private UserServiceImpl userserviceImpl;

    @Autowired
    private UserRepository userRepository;

    @Test
    void createUser() {
        Users users = new Users();
        users.setUserName("peter");
        users.setEmail("eke@gmail.com");
        users.setFirstName("ekeoluwa");
        users.setLastName("edowu");
        users.setPassword("12345");
        userRepository.save(users);

        Users usersOptional = userRepository.findUsersByEmail("eke@gmail.com");

        assertEquals("eke@gmail.com", usersOptional.getEmail());

    }

    @Test
    void login() {
        String email = "eke@gmail.com";
        String password = "123456";

        assertEquals(userRepository.findByEmailAndPassword(email,password),
                userserviceImpl.login(email, password));

    }

    @Test
    void viewBlogPost() {
    }

    @Test
    void commentOnBlogPost() {
    }

    @Test
    void like() {
    }
}