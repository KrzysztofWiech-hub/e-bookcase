package com.ebookcase.controller.author;

import com.ebookcase.dto.author.AuthorDto;
import com.ebookcase.dto.author.AuthorQuoteDto;
import com.ebookcase.model.author.Author;
import com.ebookcase.service.author.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping("/author")
    public ResponseEntity<AuthorDto> createAuthor(@RequestBody AuthorDetails authorDetails) {
        Author author = authorService.createAuthor(authorDetails.getName(), authorDetails.getSurname());
        AuthorDto authorDto = new AuthorDto(author);
        return ResponseEntity.ok().body(authorDto);
    }

    @GetMapping(value = "/author/quote")
    public ResponseEntity<List<AuthorQuoteDto>> getAllAuthorsWithQuotes() {
        List<AuthorQuoteDto> resultList = new ArrayList<>();
        List<Author> authorList = authorService.findAllAuthorsWithQuotes();
        authorList.forEach(author -> resultList.add(new AuthorQuoteDto(author, author.getQuotes())));
        return ResponseEntity.ok(resultList);
    }
}
