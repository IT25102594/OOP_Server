package com.movieplatform.Repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class RentalRepository {

    private final String FILE_PATH = "src/main/resources/rentals.txt";
//add new rent
    public void saveRental(String rentalData) {
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(FILE_PATH, true)))) {
            out.println(rentalData);
        } catch (IOException e) {
            System.err.println("error: " + e.getMessage());
        }
    }

    // 2. read all rent
    public List<String> getAllRentals() {
        List<String> rentals = new ArrayList<>();
        File file = new File(FILE_PATH);

        if (!file.exists()) return rentals;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                rentals.add(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading files: " + e.getMessage());
        }
        return rentals;
    }

    // 3. to find rent for specific user id
    public List<String> findByUserId(String userId) {
        List<String> userRentals = new ArrayList<>();
        for (String record : getAllRentals()) {
            if (record.contains("| " + userId + " |")) {
                userRentals.add(record);
            }
        }
        return userRentals;
    }
}