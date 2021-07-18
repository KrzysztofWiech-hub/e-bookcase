package com.ebookcase.dto.quote;

import com.ebookcase.model.quote.Quote;
import lombok.Getter;


@Getter
public class QuoteDto {

    private long id;
    private String quote;

    public QuoteDto(Quote quote) {
        this.id = quote.getId();
        this.quote = quote.getQuote();

    }

    public long getId() {
        return id;
    }

    public String getQuote() {
        return quote;
    }
}
