package br.com.hilton.apirestspring.repository;

import br.com.hilton.apirestspring.models.Course;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ICourseRepositoryTest {

    @Autowired
    private ICourseRepository repository;

    @Test
    public void deveriaEncontrarUmCursoPeloNome() {
        String nameCourse = "ADS";
        Course course = repository.findByName(nameCourse);
        Assert.assertNotNull(course);
        Assert.assertEquals(nameCourse, course.getName());
    }

    @Test
    public void naoDeveriaEncontrarUmCursoPeloNome() {
        String nameCourse = "Medicina";
        Course course = repository.findByName(nameCourse);
        Assert.assertNull(course);
    }

}