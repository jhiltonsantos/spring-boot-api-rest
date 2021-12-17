package br.com.hilton.apirestspring.controller;

import br.com.hilton.apirestspring.controller.dto.TopicDetailDto;
import br.com.hilton.apirestspring.controller.dto.TopicDto;
import br.com.hilton.apirestspring.controller.form.TopicForm;
import br.com.hilton.apirestspring.controller.form.TopicUpdateForm;
import br.com.hilton.apirestspring.repository.ICourseRepository;
import br.com.hilton.apirestspring.models.Topic;
import br.com.hilton.apirestspring.repository.ITopicRepository;
import br.com.hilton.apirestspring.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/topics")
public class TopicsController {

    @Autowired
    private ITopicRepository iTopicRepository;

    @Autowired
    private ICourseRepository iCourseRepository;

    @Autowired
    private IUserRepository iAuthorRepository;

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

    @GetMapping("/{id}")
    public ResponseEntity<TopicDetailDto> detail(@PathVariable() Long id) {
        Optional<Topic> topic = iTopicRepository.findById(id);
        if (topic.isPresent()) {
            return ResponseEntity.ok(new TopicDetailDto(topic.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @Transactional
    public ResponseEntity<TopicDto> register(@RequestBody @Valid TopicForm form, UriComponentsBuilder uriBuilder) {
        Topic topic = form.convert(iCourseRepository, iAuthorRepository);
        iTopicRepository.save(topic);
        URI uri = uriBuilder.path("/topics/{id}").buildAndExpand(topic.getId()).toUri();
        return ResponseEntity.created(uri).body(new TopicDto(topic));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<TopicDto> update(@PathVariable() Long id, @RequestBody @Valid TopicUpdateForm form) {
        Optional<Topic> optional = iTopicRepository.findById(id);
        if (optional.isPresent()) {
            Topic topic = form.update(id, iTopicRepository);
            return ResponseEntity.ok(new TopicDto(topic));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> remove(@PathVariable() Long id) {
        Optional<Topic> optional = iTopicRepository.findById(id);
        if (optional.isPresent()) {
            iTopicRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
