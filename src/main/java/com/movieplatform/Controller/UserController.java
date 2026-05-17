package com.movieplatform.Controller;

import com.movieplatform.Entity.User;
import com.movieplatform.Entity.Wishlist;
import com.movieplatform.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/login")
    public User login(@RequestBody User user){
        // 1. Check what Java received from JS
        System.out.println("JAVA RECEIVED - Email: " + user.getGmail());
        System.out.println("JAVA RECEIVED - Password: " + user.getPassword());

        User check = userRepository.findByGmail(user.getGmail());

        // 2. Check what Java found in the Database
        if(check != null) {
            System.out.println("DB FOUND - User: " + check.getName() + " | Password: " + check.getPassword());
        } else {
            System.out.println("DB FOUND - Absolutely nothing (null) for email: " + user.getGmail());
        }

        if(check != null){
            if(check.getPassword().equals(user.getPassword())){
                return check;
            } else {
                System.out.println("FAILED - Passwords did not match!");
                return null;
            }
        } else {
            return null;
        }
    }

    // create new user
    @PostMapping("/register")
    public User create(@RequestBody User user) {
        return userRepository.save(user);
    }


    // get single user by id
    @GetMapping("/{id}")
    public User getById(@PathVariable Integer id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("user not found with id: " + id));
    }



    // update existing user
    @PutMapping("/{id}")
    public User update(@PathVariable Integer id, @RequestBody User userDetails) {
        // first check if user exists
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("user not found"));

        // update the fields
        user.setName(userDetails.getName());
        user.setPassword(userDetails.getPassword());
        user.setGmail(userDetails.getGmail());
        user.setAdmin(userDetails.getAdmin());

        // save n return
        return userRepository.save(user);
    }

    // delete user
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        // check if exists first
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("user doesnt exist");
        }

        userRepository.deleteById(id);
        return "user deleted successfully";
    }
}
