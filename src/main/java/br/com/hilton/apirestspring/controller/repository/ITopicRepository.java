package br.com.hilton.apirestspring.controller.repository;

import br.com.hilton.apirestspring.models.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ITopicRepository extends JpaRepository<Topic, Long> {

    List<Topic> findByCourse_Name(String course);

    //@Query("SELECT t FROM Topic t WHERE t.course.name == :nomeCurso")
    //List<Topic> encontrarPorNomeDoCurso(@Param("nomeCurso") String nomeCurso);
}
