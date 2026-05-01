package com.movieplatform.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "rentals", schema = "oop_db")
public class Rental {
    @EmbeddedId
    private RentalId id;

    @Column(name = "date")
    private LocalDate date;


    public class Rental {
        // Encapsulation
        private String userId;
        private String movieId;
        private String rentalDate;
        private String dueDate;
        private String returnDate;
        private String status;

        // Constructor
        public Rental(String rentalId, String userId, String movieId, String rentalDate, String dueDate, String returnDate, String status) {
            this.rentalId = rentalId;
            this.userId = userId;
            this.movieId = movieId;
            this.rentalDate = rentalDate;
            this.dueDate = dueDate;
            this.returnDate = returnDate;
            this.status = status;
        }


        public String getRentalId() { return rentalId; }
        public String getStatus() { return status; }
        public void setStatus(String status) { this.status = status; }
        public void setReturnDate(String returnDate) { this.returnDate = returnDate; }


        public String toFileString() {
            return rentalId + "|" + userId + "|" + movieId + "|" + rentalDate + "|" + dueDate + "|" + returnDate + "|" + status;
        }
    }
}