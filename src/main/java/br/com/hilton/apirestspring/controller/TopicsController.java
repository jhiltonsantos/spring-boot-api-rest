package br.com.hilton.apirestspring.controller;

import br.com.hilton.apirestspring.controller.dto.TopicDto;
import br.com.hilton.apirestspring.models.Course;
import br.com.hilton.apirestspring.models.Topic;
import br.com.hilton.apirestspring.repository.ITopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class TopicsController {

    @Autowired
    private ITopicRepository iTopicRepository;

    @RequestMapping("/topics")
    public List<TopicDto> listTopics(String course) {
        List<Topic> topics;
        if (course == null) {
            topics = iTopicRepository.findAll();
        } else {
            topics = iTopicRepository.findByCourse_Name(course);
        }
        return TopicDto.convert(topics);

    }
}
