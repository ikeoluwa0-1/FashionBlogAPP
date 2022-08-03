package com.example.fashionblogapp.Entities;

import lombok.*;
import org.springframework.context.annotation.Bean;

import javax.persistence.*;
//import javax.validation.constraints.Size;


@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


@Entity
@Table(name = "admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(unique = true, nullable = false)
    private String email;

//    @Size(min=6, max=10)
    private String password;
}
