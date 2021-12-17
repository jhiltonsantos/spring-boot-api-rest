package br.com.hilton.apirestspring.controller.dto;
import br.com.hilton.apirestspring.models.Topic;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class TopicDto {

    private final Long id;
    private final String title;
    private final String message;
    private final LocalDateTime dateCreate;

    public TopicDto(Topic topic) {
        this.id = topic.getId();
        this.title = topic.getTitle();
        this.message = topic.getMessage();
        this.dateCreate = topic.getDateCreate();
    }

    public static List<TopicDto> convert(List<Topic> topics) {
        return topics.stream().map(TopicDto::new).collect(Collectors.toList());
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


}
