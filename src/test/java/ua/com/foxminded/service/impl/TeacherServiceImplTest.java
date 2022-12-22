package ua.com.foxminded.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import ua.com.foxminded.dao.impl.TeacherDaoImpl;
import ua.com.foxminded.model.Teacher;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TeacherServiceImplTest {

    @Autowired
    TeacherServiceImpl teacherService;

    @MockBean
    TeacherDaoImpl teacherDao;

    private int testTeacherId = 1;
    private Teacher testTeacher;

    @Test
    public void getTeacherTest_shouldCallDaoMethod(){
        teacherService.getTeacher(testTeacherId);
        verify(teacherDao, Mockito.times(1)).getTeacher(Mockito.anyInt());
    }

    @Test
    public void addTeacherTest_shouldCallDaoMethod(){
        teacherService.addTeacher(testTeacher);
        verify(teacherDao, Mockito.times(1)).addTeacher(Mockito.any());
    }

    @Test
    public void updateTeacherTest_shouldCallDaoMethod(){
        teacherService.updateTeacher(testTeacher);
        verify(teacherDao, Mockito.times(1)).updateTeacher(Mockito.any());
    }

    @Test
    public void deleteTeacherTest_shouldCallDaoMethod(){
        teacherService.deleteTeacher(testTeacherId);
        verify(teacherDao, Mockito.times(1)).deleteTeacher(Mockito.anyInt());
    }
}
