package ua.com.foxminded.dao.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import ua.com.foxminded.model.Student;
import java.util.Optional;
import static org.mockito.Mockito.verify;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@Sql(scripts = {"classpath:test-schema.sql"})
@SpringBootTest
public class StudentDaoImplTest {
    @Mock
    StudentDaoImpl studentDao;

    private Student actualStudent;
    private Student expectedStudent;
    private int testStudentId = 1;
    private Optional<Student> actualOptional;
    private Optional<Student> expectedOptional;

    @Test
    public void getStudentTest_shouldReturnOptionalStudent(){
        Mockito.when(studentDao.getStudent(testStudentId)).thenReturn(expectedOptional);
        actualOptional = studentDao.getStudent(testStudentId);
        assertEquals(expectedOptional,actualOptional);
    }

    @Test
    public void testAddStudent_shouldReturnStudent(){
        Mockito.when(studentDao.addStudent(expectedStudent)).thenReturn(expectedStudent);
        actualStudent = studentDao.addStudent(expectedStudent);
        assertEquals(expectedStudent, actualStudent);
    }

    @Test
    public void testUpdateStudent_shouldReturnOptionalStudent(){
        Mockito.when(studentDao.updateStudent(expectedStudent)).thenReturn(expectedOptional);
        actualOptional = studentDao.updateStudent(expectedStudent);
        assertEquals(expectedOptional,actualOptional);
    }

    @Test
    public void testDeleteStudent_shouldReturnTrue(){
     studentDao.deleteStudent(testStudentId);
     verify(studentDao, Mockito.times(1)).deleteStudent(Mockito.anyInt());
    }
}
