package com.example.fashionblogapp.Entities;

import lombok.*;

import javax.persistence.*;
//import javax.validation.constraints.Size;
import java.util.List;


@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String LastName;

    @Column(unique = true)
    private String userName;

    @Column(unique = true, nullable = false)
    private String email;

//    @Size(min=6, max=10)
    private String password;

    @OneToMany
    private List<Comment> comment;

}
