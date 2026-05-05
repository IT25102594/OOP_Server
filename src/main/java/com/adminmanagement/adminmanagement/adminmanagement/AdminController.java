// src/main/java/com/adminmanagement/controller/AdminController.java
package com.adminmanagement.adminmanagement;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*") // Webpage உடன் இணைக்க இது அவசியம்
public class AdminController {

    private List<Review> reviews = new ArrayList<>();

    public AdminController() {
        // ஆரம்பத்திற்காக சில தரவுகள்
        reviews.add(new Review(1L, "Kiran", "Good Project!"));
        reviews.add(new Review(2L, "Arul", "Needs improvement."));
    }

    // 1. View All Reviews
    @GetMapping("/reviews")
    public List<Review> getAll() {
        return reviews;
    }

    // 2. Delete Review
    @DeleteMapping("/reviews/{id}")
    public String delete(@PathVariable Long id) {
        reviews.removeIf(r -> r.getId().equals(id));
        return "Review Deleted!";
    }

    // 3. Edit Review
    @PutMapping("/reviews/{id}")
    public String edit(@PathVariable Long id, @RequestBody Review updatedReview) {
        for (Review r : reviews) {
            if (r.getId().equals(id)) {
                r.setComment(updatedReview.getComment());
                return "Updated!";
            }
        }
        return "Not Found";
    }
}
