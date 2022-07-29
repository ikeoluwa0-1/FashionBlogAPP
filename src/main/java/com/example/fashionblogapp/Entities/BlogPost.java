package com.example.fashionblogapp.Entities;

import com.example.fashionblogapp.Enums.Category;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


@Entity
@RequiredArgsConstructor
@Getter
@Setter
@Table(name = "blog_post")
public class BlogPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String design;

    private String description;

    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    private Category category;

    @OneToMany(mappedBy = "blogPostId")
    private List<Comment> comment;

}
