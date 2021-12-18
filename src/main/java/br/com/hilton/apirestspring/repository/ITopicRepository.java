package br.com.hilton.apirestspring.repository;

import br.com.hilton.apirestspring.models.Topic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ITopicRepository extends JpaRepository<Topic, Long> {

    Page<Topic> findByCourse_Name(String course, Pageable pageable);

    //@Query("SELECT t FROM Topic t WHERE t.course.name == :nomeCurso")
    //List<Topic> encontrarPorNomeDoCurso(@Param("nomeCurso") String nomeCurso);
}
