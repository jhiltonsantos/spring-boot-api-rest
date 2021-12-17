package br.com.hilton.apirestspring.controller;

import br.com.hilton.apirestspring.controller.dto.TopicDto;
import br.com.hilton.apirestspring.controller.form.TopicForm;
import br.com.hilton.apirestspring.controller.repository.ICourseRepository;
import br.com.hilton.apirestspring.models.Topic;
import br.com.hilton.apirestspring.controller.repository.ITopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public void register(@RequestBody TopicForm form) {
        Topic topic = form.convert(iCourseRepository);
        iTopicRepository.save(topic);
    }
}
