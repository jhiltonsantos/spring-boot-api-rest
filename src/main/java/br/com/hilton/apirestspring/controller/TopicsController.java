package br.com.hilton.apirestspring.controller;

import br.com.hilton.apirestspring.controller.dto.TopicDto;
import br.com.hilton.apirestspring.controller.form.TopicForm;
import br.com.hilton.apirestspring.repository.ICourseRepository;
import br.com.hilton.apirestspring.models.Topic;
import br.com.hilton.apirestspring.repository.ITopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/topics")
public class TopicsController {

    @Autowired
    private ITopicRepository iTopicRepository;

    @Autowired
    private ICourseRepository iCourseRepository;

    @GetMapping
    public List<TopicDto> listTopics(String course) {
        List<Topic> topics;
        if (course == null) {
            topics = iTopicRepository.findAll();
        } else {
            topics = iTopicRepository.findByCourse_Name(course);
        }
        return TopicDto.convert(topics);
    }

    @PostMapping
    public ResponseEntity<TopicDto> register(@RequestBody @Valid TopicForm form,
                                             UriComponentsBuilder uriBuilder) {
        Topic topic = form.convert(iCourseRepository);
        iTopicRepository.save(topic);
        URI uri = uriBuilder.path("/topics/{id}").buildAndExpand(topic.getId()).toUri();
        return ResponseEntity.created(uri).body(new TopicDto(topic));
    }
}
