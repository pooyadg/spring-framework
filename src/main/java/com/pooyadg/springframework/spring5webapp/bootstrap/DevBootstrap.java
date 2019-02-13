package com.pooyadg.springframework.spring5webapp.bootstrap;

import com.pooyadg.springframework.spring5webapp.model.Author;
import com.pooyadg.springframework.spring5webapp.model.Book;
import com.pooyadg.springframework.spring5webapp.repositories.AuthorRepository;
import com.pooyadg.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        init();
    }

    private void init() {
        Author joe = new Author("Joe", "Daniel");
        Book book1 = new Book("Book number one", "123456", "The Face");
        joe.getBooks().add(book1);
        book1.getAuthors().add(joe);
        authorRepository.save(joe);
        bookRepository.save(book1);


        Author jack = new Author("Jack", "Rock");
        Book book2 = new Book("Book number two", "7654333", "Beyond Borders");
        jack.getBooks().add(book2);
        book2.getAuthors().add(jack);
        authorRepository.save(jack);
        bookRepository.save(book2);
    }
}
