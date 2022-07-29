package com.example.fashionblogapp.DTO;

import lombok.Data;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.validation.constraints.Size;


@Data
public class AdminDTO {
    private String email;
    private String firstName;
    private String lastName;
    private String password;
}
