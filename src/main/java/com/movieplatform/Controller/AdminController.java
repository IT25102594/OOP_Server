package com.movieplatform.Controller


import com.movieplatform.models.Admin;
import com.movieplatform.repositories.AdminRepository;
import java.util.List;

public class AdminController {
    private AdminRepository adminRepository;

    public AdminController() {
        this.adminRepository = new AdminRepository();
    }

    public String createAdmin(String id, String name, String email, String pass, String level) {
        if (name == null || name.isEmpty()) return "Failure: Name required";

        Admin newAdmin = new Admin(id, name, email, pass, level);
        adminRepository.save(newAdmin);
        return "Admin created successfully";
    }

    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }
}