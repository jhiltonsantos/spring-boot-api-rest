package br.com.hilton.apirestspring.controller.form;

import br.com.hilton.apirestspring.repository.ICourseRepository;
import br.com.hilton.apirestspring.models.Course;
import br.com.hilton.apirestspring.models.Topic;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class TopicForm {

    @NotNull @NotEmpty @Length(min = 5)
    private String title;
    @NotNull @NotEmpty @Length(min = 10)
    private String message;
    @NotNull @NotEmpty
    private String course;

    public Topic convert(ICourseRepository courseRepository) {
        Course courseName = courseRepository.findByName(course);
        return new Topic(title, message, courseName);
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

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
