package com.ebookcase.dto.author;

import com.ebookcase.model.author.Author;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthorDto {

    private int id;

    private String name;

    private String surname;

    public AuthorDto(Author author) {
        this.id = (int) author.getId();
        this.name = author.getName();
        this.surname = author.getSurname();
    }

}
