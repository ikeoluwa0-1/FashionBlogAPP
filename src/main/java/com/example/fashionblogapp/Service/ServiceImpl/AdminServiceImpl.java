package com.example.fashionblogapp.Service.ServiceImpl;

import com.example.fashionblogapp.DTO.AdminDTO;
import com.example.fashionblogapp.DTO.BlogPostDTO;
import com.example.fashionblogapp.Entities.Admin;
import com.example.fashionblogapp.Entities.BlogPost;
import com.example.fashionblogapp.Service.AdminService;
import com.example.fashionblogapp.repository.AdminRepository;
import com.example.fashionblogapp.repository.BlogPostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
@RequiredArgsConstructor

public class AdminServiceImpl implements AdminService{

    private  final AdminRepository adminRepository;


    private final BlogPostRepository blogPostRepository;

    private final  HttpSession httpSession;


    @Override
    public String createAdmin(AdminDTO adminDTO) {
        Admin adminInDb = adminRepository.findByEmail(adminDTO.getEmail());
        if (adminInDb != null)
            throw new RuntimeException("This admin already exist!");


        Admin admin = new Admin();
        admin.setEmail(adminDTO.getEmail());
        admin.setPassword(adminDTO.getPassword());
        admin.setLastName(adminDTO.getLastName());
        admin.setFirstName(adminDTO.getFirstName());
        adminRepository.save(admin);
        return "You are successfully signed up as an Admin!";
    }

    @Override
    public Admin login(String email, String password) {
        return adminRepository.findByEmailAndPassword(email, password);
    }


    @Override
    public String createBlogPost(BlogPostDTO blogPostDTO) {
        System.out.println(blogPostDTO);
        BlogPost blogPost = new BlogPost();
        if(httpSession.getAttribute("admin_id") == null){
            throw new RuntimeException("Please, login first!");
        }
        if(blogPostRepository.existsBlogPostById(blogPost.getId())){
            throw new RuntimeException("Blog Post already exists!");
        }
        blogPost.setDesign(blogPostDTO.getDesign());
        blogPost.setCategory(blogPostDTO.getCategory());
        blogPost.setDescription(blogPostDTO.getDescription());
        blogPost.setPrice(blogPostDTO.getPrice());
        blogPostRepository.save(blogPost);

        return "Blog Post Successfully created!";

    }


}
