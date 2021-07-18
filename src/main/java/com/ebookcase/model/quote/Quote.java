package com.ebookcase.model.quote;

import com.ebookcase.model.author.Author;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Setter
@Getter
@Entity
@NoArgsConstructor
@Table(name = "quote")
public class Quote {

    public Quote(String quote, Author author) {
        this.quote = quote;
        this.author = author;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull(message = "Quote may not be empty")
    private String quote;

    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name = "author_id")
    private Author author;
}
