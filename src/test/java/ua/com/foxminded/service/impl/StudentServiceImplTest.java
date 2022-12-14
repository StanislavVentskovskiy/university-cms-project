package ua.com.foxminded.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import ua.com.foxminded.dao.impl.StudentDaoImpl;
import ua.com.foxminded.model.Student;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentServiceImplTest {

    @Autowired
    StudentServiceImpl studentService;

    @MockBean
    StudentDaoImpl studentDao;

    private Student testStudent;
    private int testStudentId = 1;

    @Test
    public void getStudentTest_shouldCallDaoMethod(){
        studentService.getStudent(testStudentId);

        verify(studentDao, Mockito.times(1)).getStudent(Mockito.anyInt());
    }

    @Test
    public void addStudentTest_shouldCallDaoMethod(){
        studentService.addStudent(testStudent);

        verify(studentDao, Mockito.times(1)).addStudent(Mockito.any());
    }

    @Test
    public void updateStudentTest_shouldCallDaoMethod(){
        studentService.updateStudent(testStudent);

        verify(studentDao, Mockito.times(1)).updateStudent(Mockito.any());
    }

    @Test
    public void deleteStudentTest_shouldCallDaoMethod(){
        studentService.deleteStudent(testStudentId);

        verify(studentDao, Mockito.times(1)).deleteStudent(Mockito.anyInt());
    }
}
