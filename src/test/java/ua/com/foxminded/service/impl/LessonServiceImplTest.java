package ua.com.foxminded.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import ua.com.foxminded.dao.impl.LessonDaoImpl;
import ua.com.foxminded.model.Lesson;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LessonServiceImplTest {

    @Autowired
    LessonServiceImpl lessonService;

    @MockBean
    LessonDaoImpl lessonDao;

    private Lesson testLesson;
    private int testLessonId;

    @Test
    public void addLessonTest_shouldCallDaoMethod(){
        lessonService.addLesson(testLesson);
        verify(lessonDao, Mockito.times(1)).addLesson(Mockito.any());
    }

    @Test
    public void updateLessonTest_shouldCallDaoMethod(){
        lessonService.updateLesson(testLesson);
        verify(lessonDao, Mockito.times(1)).updateLesson(Mockito.any());
    }

    @Test
    public void deleteLessonTest_shouldCallDaoMethod(){
        lessonService.deleteLesson(testLessonId);
        verify(lessonDao, Mockito.times(1)).deleteLesson(Mockito.anyInt());
    }

    @Test
    public void getLessonTest_shouldCallDaoMethod(){
        lessonService.getLesson(testLessonId);
        verify(lessonDao, Mockito.times(1)).getLesson(Mockito.anyInt());
    }
}
