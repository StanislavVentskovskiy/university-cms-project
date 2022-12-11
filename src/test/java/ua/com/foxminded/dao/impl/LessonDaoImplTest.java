package ua.com.foxminded.dao.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import ua.com.foxminded.model.Lesson;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@Sql(scripts = {"classpath:test-schema.sql"})
@SpringBootTest
public class LessonDaoImplTest {

    @Autowired
    LessonDaoImpl lessonDaoImpl;

    private Lesson expectedLesson;
    private Lesson actualLesson;

    @Before
    public void initTestData(){
        expectedLesson = new Lesson();
    }

    @Test
    public void addLessonTest_shouldReturnLesson(){
        lessonDaoImpl.addLesson(expectedLesson);
        actualLesson = lessonDaoImpl.getLesson(expectedLesson.getId());

        assertEquals(expectedLesson,actualLesson);

    }


}
