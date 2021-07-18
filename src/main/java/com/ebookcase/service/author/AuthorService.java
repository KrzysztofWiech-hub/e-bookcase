package com.ebookcase.service.author;

import com.ebookcase.model.author.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    Author createAuthor(String name, String surname);

    Optional<Author> getAuthorById(long id);

    List<Author> findAllAuthorsWithQuotes();
}
