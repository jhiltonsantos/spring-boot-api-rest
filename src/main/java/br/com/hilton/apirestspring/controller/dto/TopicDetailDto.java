package br.com.hilton.apirestspring.controller.dto;

import br.com.hilton.apirestspring.models.StatusTopic;
import br.com.hilton.apirestspring.models.Topic;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TopicDetailDto {

    private final Long id;
    private final String title;
    private final String message;
    private final LocalDateTime dateCreate;
    private final String author;
    private final StatusTopic status;
    private final List<AnswersDto> answers;

    public TopicDetailDto(Topic topic) {
        this.id = topic.getId();
        this.title = topic.getTitle();
        this.message = topic.getMessage();
        this.dateCreate = topic.getDateCreate();
        this.author = topic.getAuthor().getName();
        this.status = topic.getStatus();
        this.answers = new ArrayList<>();
        this.answers.addAll(topic.getAnswers().stream().map(AnswersDto::new).collect(Collectors.toList()));
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
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

    public StatusTopic getStatus() {
        return status;
    }

    public List<AnswersDto> getAnswers() {
        return answers;
    }
}
