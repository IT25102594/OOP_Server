package com.movieplatform.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "movie", schema = "oop_db")
public class Movie {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 45)
    @Column(name = "name", length = 45)
    private String name;

    @Size(max = 45)
    @Column(name = "language", length = 45)
    private String language;

    @Size(max = 45)
    @Column(name = "country", length = 45)
    private String country;

    @Column(name = "hours")
    private Instant hours;

    @Size(max = 45)
    @Column(name = "shortdescription", length = 45)
    private String shortdescription;

    @Size(max = 45)
    @Column(name = "description", length = 45)
    private String description;

    @Size(max = 45)
    @Column(name = "image", length = 45)
    private String image;

    @Size(max = 45)
    @Column(name = "link", length = 45)
    private String link;

    @Size(max = 45)
    @Column(name = "trailerlink", length = 45)
    private String trailerlink;

    @Column(name = "imdb")
    private Double imdb;

    @Column(name = "tomato")
    private Double tomato;

    @Column(name = "price")
    private Double price;


}