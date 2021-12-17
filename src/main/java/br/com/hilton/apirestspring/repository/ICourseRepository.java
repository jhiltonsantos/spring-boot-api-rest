package br.com.hilton.apirestspring.repository;

import br.com.hilton.apirestspring.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICourseRepository extends JpaRepository<Course, Long> {
    Course findByName(String name);
}
