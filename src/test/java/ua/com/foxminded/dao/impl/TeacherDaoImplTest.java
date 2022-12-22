package ua.com.foxminded.dao.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import ua.com.foxminded.model.Teacher;
import java.util.Optional;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@Sql(scripts = {"classpath:test-schema.sql"})
@SpringBootTest
public class TeacherDaoImplTest {

    @Mock
    TeacherDaoImpl teacherDaoImpl;

    private Teacher expectedTeacher;
    private Teacher actualTeacher;
    private int testTeacherId = 1;
    private Optional<Teacher> expectedOptional;
    private Optional<Teacher> actualOptional;

    @Test
    public void addTeacherTest_shouldReturnTeacher(){
        actualTeacher = teacherDaoImpl.addTeacher(expectedTeacher);
        assertEquals(actualTeacher,expectedTeacher);
    }

    @Test
    public void deleteTeacherTest_shouldReturnTrue(){
        teacherDaoImpl.deleteTeacher(testTeacherId);
        verify(teacherDaoImpl, Mockito.times(1)).deleteTeacher(Mockito.anyInt());
    }

    @Test
    public void getTeacherTest_shouldReturnOptionalTeacher(){
        Mockito.when(teacherDaoImpl.getTeacher(testTeacherId)).thenReturn(expectedOptional);
        actualOptional = teacherDaoImpl.getTeacher(testTeacherId);
        assertEquals(actualOptional,expectedOptional);
    }

    @Test
    public void updateTeacher_shouldReturnOptionalTeacher(){
        Mockito.when(teacherDaoImpl.updateTeacher(expectedTeacher)).thenReturn(expectedOptional);
        actualOptional = teacherDaoImpl.updateTeacher(expectedTeacher);
        assertEquals(actualOptional,expectedOptional);
    }
}
