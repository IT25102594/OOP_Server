package com.movieplatform.Controller;

import com.movieplatform.Entity.Rental;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class RentalController {

    private final String FILE_PATH = "src/main/resources/rentals.txt";


    @GetMapping("/rent")
    public String showRentPage() {
        return "rent-movie";
    }


    @PostMapping("/rent-movie")
    public String processRental(@RequestParam String movieId, @RequestParam String userId) {
        String rentalId = "R" + System.currentTimeMillis(); // temporary ID
        LocalDate rentalDate = LocalDate.now();
        LocalDate dueDate = rentalDate.plusDays(7); // 7 days

        // Format: rentalId | userId | movieId | rentalDate | dueDate | status
        String data = String.format("%s | %s | %s | %s | %s | ACTIVE",
                rentalId, userId, movieId, rentalDate, dueDate);

        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(FILE_PATH, true)))) {
            out.println(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/view-rentals";
    }

    // 3. all rent
    @GetMapping("/view-rentals")
    public String viewRentals(Model model) {
        List<String> rentals = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                rentals.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        model.addAttribute("allRentals", rentals);
        return "view-rentals";
    }

    // 4. (Update/Delete Operation)
    @PostMapping("/return-movie")
    public String returnMovie(@RequestParam String rentalId) {

        return "redirect:/view-rentals";
    }
}