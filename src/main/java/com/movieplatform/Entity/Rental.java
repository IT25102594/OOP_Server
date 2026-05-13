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


}