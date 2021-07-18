package com.ebookcase.repository.author;

import com.ebookcase.model.author.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    Optional<Author> findByName(String name);

    Optional<Author> findById(long id);

//    void findAuthorByNameAndSurrname(String name, String surname);
//
//    void updateAuthorByNameAndSurrname(String name, String surname);
//
//    void deleteAuthorByNameAndSurrname(String name, String surname);

}
