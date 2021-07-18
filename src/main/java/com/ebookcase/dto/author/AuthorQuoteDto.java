package com.ebookcase.dto.author;

import com.ebookcase.model.author.Author;
import com.ebookcase.model.quote.Quote;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AuthorQuoteDto {

    private String authorName;
    private String authorSurname;
    private List<Quote> quotes;

    public AuthorQuoteDto(Author author, List<Quote> quoteDescription) {
        this.authorName = author.getName();
        this.authorSurname = author.getSurname();
        this.quotes = quoteDescription;
    }

}
