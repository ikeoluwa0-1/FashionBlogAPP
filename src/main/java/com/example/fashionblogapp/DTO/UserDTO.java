package com.example.fashionblogapp.DTO;

import com.example.fashionblogapp.Entities.Comment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class UserDTO {

    private String firstName;
    private String LastName;
    private String userName;
    private String email;

    //    @Size(min=6, max=10)
    private String password;

    @OneToMany
    private List<Comment> comment;

}
