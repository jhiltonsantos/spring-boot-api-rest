package br.com.hilton.apirestspring.controller.form;

import br.com.hilton.apirestspring.models.Course;
import br.com.hilton.apirestspring.models.Topic;
import br.com.hilton.apirestspring.models.User;
import br.com.hilton.apirestspring.repository.ICourseRepository;
import br.com.hilton.apirestspring.repository.ITopicRepository;
import br.com.hilton.apirestspring.repository.IUserRepository;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class TopicUpdateForm {

    @NotNull @NotEmpty @Length(min = 5)
    private String title;
    @NotNull @NotEmpty @Length(min = 10)
    private String message;

    public Topic update(Long id, ITopicRepository iTopicRepository) {
        Topic topic = iTopicRepository.getOne(id);
        topic.setTitle(this.title);
        topic.setMessage(this.message);
        return topic;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
