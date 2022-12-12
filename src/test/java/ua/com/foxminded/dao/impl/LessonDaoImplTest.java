package ua.com.foxminded.dao.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import ua.com.foxminded.model.Lesson;
import java.time.LocalDate;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@Sql(scripts = {"classpath:test-schema.sql","classpath:test-data.sql"})
@SpringBootTest
public class LessonDaoImplTest {

    @Autowired
    LessonDaoImpl lessonDaoImpl;

    private Lesson expectedLesson;
    private Lesson actualLesson;
    private int testLessonId = 1;
    private LocalDate testLocalDate = LocalDate.of(2022,10,10);

    @Before
    public void initTestData(){
        expectedLesson = new Lesson();
        expectedLesson.setGroupId(1);
        expectedLesson.setRoomId(1);
        expectedLesson.setTeacherId(1);
        expectedLesson.setSubjectId(1);
        lessonDaoImpl.addLesson(expectedLesson);
    }

    @Test
    public void addLessonTest_shouldReturnLesson(){
        actualLesson = lessonDaoImpl.getLesson(expectedLesson.getId());

        assertEquals(expectedLesson,actualLesson);
    }

    @Test
    public void getLessonTest_shouldReturnLesson(){
        actualLesson = lessonDaoImpl.getLesson(1);

        assertTrue(actualLesson instanceof Lesson);
    }

    @Test
    public void deleteLessonTest_shouldReturnNull(){
        lessonDaoImpl.deleteLesson(testLessonId);

        assertTrue(lessonDaoImpl.getLesson(1) == null);
    }

    @Test
    public void updateLessonTest_shouldReturnLesson(){
        expectedLesson.setDate(testLocalDate);
        actualLesson = lessonDaoImpl.updateLesson(expectedLesson);

        assertTrue(expectedLesson.equals(actualLesson));
    }
}
