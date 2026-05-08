package com.movieplatform.Controller;

import com.movieplatform.Entity.Movie;
import com.movieplatform.Repository.MovieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RequestMapping(path = "movie")
@RestController
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;


    // 1. Get all movies
    @GetMapping
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }


    // 2. Add a new movie
    @PostMapping
    public Movie addMovie(@RequestBody Movie movie) {
        return movieRepository.save(movie);
    }


    // 3. Update an existing movie
    @PutMapping("/{id}")
    public Movie updateMovie(@PathVariable Integer id,
                             @RequestBody Movie movieDetails) {

        return movieRepository.findById(id).map(movie -> {

            movie.setName(movieDetails.getName());
            movie.setLanguage(movieDetails.getLanguage());
            movie.setCountry(movieDetails.getCountry());
            movie.setHours(movieDetails.getHours());
            movie.setShortdescription(movieDetails.getShortdescription());
            movie.setDescription(movieDetails.getDescription());
            movie.setImage(movieDetails.getImage());
            movie.setLink(movieDetails.getLink());
            movie.setTrailerlink(movieDetails.getTrailerlink());
            movie.setImdb(movieDetails.getImdb());
            movie.setTomato(movieDetails.getTomato());
            movie.setPrice(movieDetails.getPrice());

            return movieRepository.save(movie);

        }).orElseThrow(() ->
                new RuntimeException("Movie not found with id " + id));
    }


    // 4. Delete a movie
    @DeleteMapping("/{id}")
    public String deleteMovie(@PathVariable Integer id) {

        movieRepository.deleteById(id);

        return "Movie with ID " + id + " has been deleted.";
    }
}