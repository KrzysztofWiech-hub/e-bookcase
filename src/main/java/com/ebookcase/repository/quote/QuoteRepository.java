package com.ebookcase.repository.quote;

import com.ebookcase.model.quote.Quote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface QuoteRepository extends JpaRepository<Quote, Long> {

    @Modifying
    @Query("update Quote quote set quote.quote = ?1 where quote.id = ?2")
    int updateQuoteById(String quoteDescription, long quoteId);
}
