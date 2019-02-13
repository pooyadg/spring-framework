package com.pooyadg.springframework.spring5webapp.repositories;

import com.pooyadg.springframework.spring5webapp.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
}
