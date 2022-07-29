package com.example.fashionblogapp.DTO;

import com.example.fashionblogapp.Entities.Comment;
import com.example.fashionblogapp.Enums.Category;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Data
@Getter
@Setter
public class BlogPostDTO {


    private String design;
    private String description;
    private BigDecimal Price;
    private Category category;
    private List<Comment> comment;
    private int LikeCount;

}
