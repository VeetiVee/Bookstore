package com.example.bookstore;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.BookRepository;
import com.example.bookstore.domain.Category;
import com.example.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository repository, CategoryRepository crepository) {
	return (args) -> {
	 // Your code...add some demo data to db
		
		crepository.save(new Category("Thriller"));
		crepository.save(new Category("Fantasy"));
		crepository.save(new Category("Science"));
		
		repository.save(new Book("Hienokirja", "Matti", "2000", "1234567-89", "10", crepository.findByName("Thriller").get(0)));
		repository.save(new Book("Hyväkirja", "Maija", "2001", "1234567-12", "15", crepository.findByName("Fantasy").get(0)));
			
	};
	
	}

}
