package com.ebookcase.service.author;

import com.ebookcase.model.author.Author;
import com.ebookcase.repository.author.AuthorRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author createAuthor(String name, String surname) {
        return authorRepository.save(new Author(name, surname));
    }

    @Override
    public Optional<Author> getAuthorById(long id) {
        return authorRepository.findById(id);
    }

    @Override
    public List<Author> findAllAuthorsWithQuotes() {
        return authorRepository.findAll();
    }
}
