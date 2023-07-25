package com.project.springproject.controller;

import com.project.springproject.exception.ResourceNOtFoundException;
import com.project.springproject.model.Movies;
import com.project.springproject.repository.MoviesRepository;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/movies")
public class MoviesController {
    @Autowired
    private MoviesRepository moviesRepository;
    public List<Movies> getAllMovies(){
        return moviesRepository.findAll();
    }

   @PostMapping
    public Movies createMovies(@RequestBody Movies movies){
        return moviesRepository. save(movies);
    }

    @GetMapping("{id}")
   public ResponseEntity<Movies> getMoviesById(@PathVariable long id) {
        Movies movies = moviesRepository.findById(id).orElseThrow(() -> new ResourceNOtFoundException("There is no with with id:" + id));
return ResponseEntity.ok(movies);
   }

   @PutMapping("{id}")
   public ResponseEntity<Movies> updateMovies(@PathVariable long id, @RequestBody Movies updateDetails) {
       Movies updateMovies = moviesRepository.findById(id).orElseThrow(() -> new ResourceNOtFoundException("There is no with with id:" + id));
       updateMovies.setProductionCo(updateDetails.getProductionCo());
       updateMovies.setCountry(updateDetails.getCountry());
       updateMovies.setTitle(updateDetails.getTitle());
       moviesRepository.save(updateMovies);
       return ResponseEntity.ok(updateMovies);
   }

   @DeleteMapping({"id"})
        public ResponseEntity<HttpStatus> deleteMovies(@PathVariable long id){
        Movies movies = moviesRepository.findById(id).orElseThrow(() -> new ResourceNOtFoundException("There is no with with id:" + id));
        moviesRepository.delete(movies);
       return new ResponseEntity<>(HttpStatus.NO_CONTENT);
   }
    }

