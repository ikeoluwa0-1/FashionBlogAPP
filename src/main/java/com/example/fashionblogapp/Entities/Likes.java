package com.example.fashionblogapp.Entities;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Data
@Setter
@Getter
@RequiredArgsConstructor
@Entity
public class Likes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    private BlogPost blogPost;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Users users;

}
