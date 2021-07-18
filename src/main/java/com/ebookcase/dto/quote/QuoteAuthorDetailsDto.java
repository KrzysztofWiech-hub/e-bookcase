package com.ebookcase.dto.quote;

import com.ebookcase.model.quote.Quote;
import lombok.Getter;

@Getter
public class QuoteAuthorDetailsDto {

    private String quoteDescription;
    private String authorName;

    public QuoteAuthorDetailsDto(Quote quote) {
        this.quoteDescription = quote.getQuote();
        this.authorName = quote.getAuthor().getName();
    }
}
