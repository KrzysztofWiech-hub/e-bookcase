package com.ebookcase.service.quote;

import com.ebookcase.model.quote.Quote;

import java.util.List;

public interface QuoteService {

    Quote addQuoteToAuthor(String quoteDescription, long id);

    List<Quote> findAllQuotes();

    int updateQuoteById(long quoteId, String descriptionQuote);

    long deleteQuoteById(long quoteId);
}
