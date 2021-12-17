package br.com.hilton.apirestspring.controller.dto;

import br.com.hilton.apirestspring.models.Answer;

import java.time.LocalDateTime;

public class AnswersDto {

    private Long id;
    private String message;
    private LocalDateTime dateCreate;
    private String author;

    public AnswersDto(Answer answers) {
        this.id = answers.getId();
        this.message = answers.getMessage();
        this.dateCreate = answers.getDateCreate();
        this.author = answers.getAuthor().getName();
    }

    public Long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getDateCreate() {
        return dateCreate;
    }

    public String getAuthor() {
        return author;
    }
}
