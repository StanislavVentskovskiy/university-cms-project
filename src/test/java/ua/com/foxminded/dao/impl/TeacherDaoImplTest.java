package ua.com.foxminded.dao.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import ua.com.foxminded.model.Teacher;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@Sql(scripts = {"classpath:test-schema.sql"})
@SpringBootTest
public class TeacherDaoImplTest {

    @Autowired
    TeacherDaoImpl teacherDaoImpl;

    private Teacher expectedTeacher;
    private Teacher actualTeacher;
    private int testTeacherId = 1;

    @Before
    public void initTestData(){
        expectedTeacher = new Teacher();
        expectedTeacher.setSubjectId(1);
    }

    @Test
    public void addTeacherTest_shouldReturnTeacher(){
        actualTeacher = teacherDaoImpl.addTeacher(expectedTeacher);

        assertEquals(actualTeacher,expectedTeacher);
    }

    @Test
    public void deleteTeacherTest_shouldReturnNull(){
        teacherDaoImpl.deleteTeacher(testTeacherId);
        actualTeacher = teacherDaoImpl.getTeacher(testTeacherId);

        assertEquals(actualTeacher, null);
    }

    @Test
    public void getTeacherTest_shouldReturnTeacher(){
        actualTeacher = teacherDaoImpl.getTeacher(1);

        assertTrue(actualTeacher instanceof Teacher);
    }

    @Test
    public void updateTeacher_shouldReturnTeacher(){
        expectedTeacher = teacherDaoImpl.getTeacher(testTeacherId);
        expectedTeacher.setPosition("test");
        actualTeacher = teacherDaoImpl.updateTeacher(expectedTeacher);

        assertTrue(actualTeacher.equals(expectedTeacher));
    }
}
