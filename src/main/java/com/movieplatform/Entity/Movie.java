package com.movieplatform.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    // Movie duration
    @Column(name = "hours")
    private Integer hours;

    @Size(max = 255)
    @Column(name = "shortdescription", length = 255)
    private String shortdescription;

    @Size(max = 1000)
    @Column(name = "description", length = 1000)
    private String description;

    @Size(max = 255)
    @Column(name = "image", length = 255)
    private String image;

    @Size(max = 255)
    @Column(name = "link", length = 255)
    private String link;

    @Size(max = 255)
    @Column(name = "trailerlink", length = 255)
    private String trailerlink;

    @Column(name = "imdb")
    private Double imdb;

    @Column(name = "tomato")
    private Double tomato;

    @Column(name = "price")
    private Double price;
}