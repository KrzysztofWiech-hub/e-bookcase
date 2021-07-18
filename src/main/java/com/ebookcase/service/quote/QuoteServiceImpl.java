package com.ebookcase.service.quote;

import com.ebookcase.exception.ResourceNotFoundException;
import com.ebookcase.model.author.Author;
import com.ebookcase.model.quote.Quote;
import com.ebookcase.repository.quote.QuoteRepository;
import com.ebookcase.service.author.AuthorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class QuoteServiceImpl implements QuoteService {

    private Logger logger = LoggerFactory.getLogger(QuoteServiceImpl.class);

    private final AuthorService authorService;
    private final QuoteRepository quoteRepository;

    public QuoteServiceImpl(AuthorService authorService, QuoteRepository quoteRepository) {
        this.authorService = authorService;
        this.quoteRepository = quoteRepository;
    }

    @Override
    public Quote addQuoteToAuthor(String quoteDescription, long authorId) {
        Optional<Author> author = authorService.getAuthorById(authorId);
        if (author.isPresent()) {
            Quote quote = new Quote(quoteDescription, author.get());
            Quote addedQuote = quoteRepository.save(quote);
            logger.info("Successfully added quote to author, id: {}, name {}", authorId, author.get().getName());
            return addedQuote;
        } else {
            throw new ResourceNotFoundException("Cannot add quote to authorId: " + authorId);
        }
    }

    @Override
    public List<Quote> findAllQuotes() {
        return quoteRepository.findAll();
    }

    @Override
    @Transactional
    public int updateQuoteById(long quoteId, String descriptionQuote) {
        Optional<Quote> quote = quoteRepository.findById(quoteId);
        if (quote.isPresent()) {
            int updatedQuoteId = quoteRepository.updateQuoteById(descriptionQuote, quoteId);
            logger.info("Successfully update quoteId: {}", updatedQuoteId);
            return updatedQuoteId;
        } else {
            throw new ResourceNotFoundException("Cannot update quoteId: " + quoteId);
        }
    }

    @Override
    @Transactional
    public long deleteQuoteById(long quoteId) {
        Optional<Quote> quote = quoteRepository.findById(quoteId);
        if (quote.isPresent()) {
            quoteRepository.deleteById(quoteId);
            logger.info("Successfully delete quoteId: {}", quoteId);
            return quoteId;
        } else {
            throw new ResourceNotFoundException("Cannot delete quoteId: " + quoteId);
        }
    }
}
