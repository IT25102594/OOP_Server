package com.movieplatform.Controller;

import com.movieplatform.Entity.Movie;
import com.movieplatform.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class MovieController {

    @Autowired
    private MovieRepository repository;

    @GetMapping
    public String viewMovies(Model model) {
        model.addAttribute("movies", repository.findAll());
        return "index"; // index.html-ஐக் காட்டும்
    }

    @PostMapping("/rent/{id}")
    public String rentMovie(@PathVariable Long id) {
        Movie m = repository.findById(id).orElseThrow();
        m.setRented(true);
        repository.save(m);
        return "redirect:/";
    }

    @PostMapping("/return/{id}")
    public String returnMovie(@PathVariable Long id) {
        Movie m = repository.findById(id).orElseThrow();
        m.setRented(false);
        repository.save(m);
        return "redirect:/";
    }

    @PostMapping("/delete/{id}")
    public String deleteMovie(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/";
    }
}