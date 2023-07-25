package com.project.springproject.repository;

import com.project.springproject.model.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoviesRepository  extends JpaRepository<Movies, Long> {
}
