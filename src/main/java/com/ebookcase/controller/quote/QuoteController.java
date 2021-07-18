package com.ebookcase.controller.quote;

import com.ebookcase.dto.quote.QuoteAuthorDetailsDto;
import com.ebookcase.dto.quote.QuoteDto;
import com.ebookcase.model.quote.Quote;
import com.ebookcase.service.quote.QuoteService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class QuoteController {

    private final QuoteService quoteService;

    public QuoteController(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    @PostMapping(value = "/quote/author")
    public ResponseEntity<QuoteAuthorDetailsDto> addQuoteToAuthor(@RequestBody QuoteAuthorDetails quoteAuthorDetails) {
        Quote quote = quoteService.addQuoteToAuthor(quoteAuthorDetails.getQuoteDescription(), quoteAuthorDetails.getAuthorId());
        QuoteAuthorDetailsDto quoteAuthorDetailsDto = new QuoteAuthorDetailsDto(quote);
        return ResponseEntity.ok(quoteAuthorDetailsDto);
    }

    @GetMapping(value = "/quote/author")
    public ResponseEntity<List<QuoteDto>> getAllQuotes() {
        List<Quote> quoteList = quoteService.findAllQuotes();
        List<QuoteDto> resultList = new ArrayList<>();
        quoteList.forEach(quote -> resultList.add(new QuoteDto(quote)));
        return ResponseEntity.ok(resultList);
    }

    @PutMapping(value = "/quote/id/{quoteId}")
    public ResponseEntity<Integer> updateQuoteById(@PathVariable long quoteId, @RequestBody QuoteDescriptionDetails quoteDescriptionDetails) {
        int updatedQuoteId = quoteService.updateQuoteById(quoteId, quoteDescriptionDetails.getQuoteDescription());
        return ResponseEntity.ok(updatedQuoteId);
    }

    @DeleteMapping(value = "/quote/id/{quoteId}")
    public ResponseEntity<Long> deleteQuoteById(@PathVariable long quoteId) {
        long deletedQuoteId = quoteService.deleteQuoteById(quoteId);
        return ResponseEntity.ok(deletedQuoteId);
    }
}
