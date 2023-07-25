package com.project.springproject;

import com.project.springproject.model.Movies;
import com.project.springproject.repository.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringProjectApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringProjectApplication.class, args);
	}
@Autowired
private MoviesRepository moviesRepository;
	@Override
	public void run(String... args) throws Exception {
		Movies movies = new Movies();
		movies.setCountry("Germany");
		movies.setTitle("Ostfriesenfeuer");
		movies.setProductionCo("Schiwago Film");
        moviesRepository.save(movies);

		Movies movies1 = new Movies();
		movies1.setCountry("Netherlands");
		movies1.setTitle("Grenzeloos verraad");
		movies1.setProductionCo("ZODfilm");
		moviesRepository.save(movies1);

	}
}
