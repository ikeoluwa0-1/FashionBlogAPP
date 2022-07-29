package com.example.fashionblogapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;


@SpringBootApplication
public class FashionBlogAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(FashionBlogAppApplication.class, args);
    }
//
//    @Bean(name = "entityManagerFactory")
//    public LocalSessionFactoryBean sessionFactory() {
//        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
//        return sessionFactory;
//    }
}
