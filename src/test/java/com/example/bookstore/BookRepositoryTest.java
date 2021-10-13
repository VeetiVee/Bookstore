package com.example.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.BookRepository;
import com.example.bookstore.domain.Category;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class BookRepositoryTest {

	@Autowired
	private BookRepository repository;
	
	@Test
    public void findByTitleShouldReturnBook() {
        List<Book> books = repository.findByTitle("Hienokirja");
        
        assertThat(books).hasSize(1);
        assertThat(books.get(0).getAuthor()).isEqualTo("Matti");
    }
	
	 @Test
	    public void createNewBook() {
	    	Book student = new Book("Iltasatu", "Hiiri", "2011", "1239997-12", "15", new Category("BITE"));
	    	repository.save(student);
	    	assertThat(student.getId()).isNotNull();
	    }    
}
