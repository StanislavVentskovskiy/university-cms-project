package ua.com.foxminded.dao.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import ua.com.foxminded.model.Lesson;
import java.util.Optional;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@Sql(scripts = {"classpath:test-schema.sql"})
@SpringBootTest
public class LessonDaoImplTest {
    @Mock
    LessonDaoImpl lessonDaoImpl;

    private Lesson expectedLesson;
    private Lesson actualLesson;
    private Optional<Lesson> expectedOptional;
    private Optional<Lesson> actualOptional;
    private int testLessonId = 1;

    @Test
    public void addLessonTest_shouldReturnLesson(){
        Mockito.when(lessonDaoImpl.addLesson(expectedLesson)).thenReturn(expectedLesson);
        actualLesson = lessonDaoImpl.addLesson(expectedLesson);
        assertEquals(expectedLesson,actualLesson);
    }

    @Test
    public void getLessonTest_shouldReturnOptionalLesson(){
        Mockito.when(lessonDaoImpl.getLesson(testLessonId)).thenReturn(expectedOptional);
        actualOptional = lessonDaoImpl.getLesson(testLessonId);
        assertEquals(actualOptional,expectedOptional);
    }

    @Test
    public void deleteLessonTest_shouldReturnTrue(){
        lessonDaoImpl.deleteLesson(testLessonId);
        verify(lessonDaoImpl,Mockito.times(1)).deleteLesson(Mockito.anyInt());
    }

    @Test
    public void updateLessonTest_shouldReturnOptionalLesson(){
        Mockito.when(lessonDaoImpl.updateLesson(expectedLesson)).thenReturn(expectedLesson);
        actualLesson = lessonDaoImpl.updateLesson(expectedLesson);
        assertEquals(expectedOptional,actualOptional);
    }
}
