package com.pooyadg.springframework.spring5webapp.bootstrap;

import com.pooyadg.springframework.spring5webapp.model.Author;
import com.pooyadg.springframework.spring5webapp.model.Book;
import com.pooyadg.springframework.spring5webapp.model.Publisher;
import com.pooyadg.springframework.spring5webapp.repositories.AuthorRepository;
import com.pooyadg.springframework.spring5webapp.repositories.BookRepository;
import com.pooyadg.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        init();
    }

    private void init() {
        Publisher publisher1 = new Publisher("The face");
        publisherRepository.save(publisher1);

        Author joe = new Author("Joe", "Daniel");
        Book book1 = new Book("Book number one", "123456", publisher1);
        joe.getBooks().add(book1);
        book1.getAuthors().add(joe);
        authorRepository.save(joe);
        bookRepository.save(book1);


        Publisher publisher2 = new Publisher("Beyond Borders");
        publisherRepository.save(publisher2);

        Author jack = new Author("Jack", "Rock");
        Book book2 = new Book("Book number two", "7654333", publisher2);
        jack.getBooks().add(book2);
        book2.getAuthors().add(jack);
        authorRepository.save(jack);
        bookRepository.save(book2);
    }
}
