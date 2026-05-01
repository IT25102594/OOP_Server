package com.movieplatform.Controller;

import com.movieplatform.Entity.User;
import com.movieplatform.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin
@RequestMapping(path = "user")
@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> getall(){
        return userRepository.findAll();
    }
}
