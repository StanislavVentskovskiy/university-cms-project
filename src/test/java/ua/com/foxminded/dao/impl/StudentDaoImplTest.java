package ua.com.foxminded.dao.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import ua.com.foxminded.model.Student;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@Sql(scripts = {"classpath:test-schema.sql"})
@SpringBootTest
public class StudentDaoImplTest {

    @Autowired
    StudentDaoImpl studentDao;

    private Student actualStudent;
    private Student expectedStudent;
    private int testStudentId = 1;

    @Before
    public void initTestData(){
        expectedStudent = new Student();
        expectedStudent.setGroupId(1);
    }

    @Test
    public void getLessonTest_shouldReturnStudent(){
        actualStudent = studentDao.getStudent(testStudentId);

        assertTrue(actualStudent instanceof Student);
    }

    @Test
    public void testAddStudent_shouldReturnStudent(){
        actualStudent = studentDao.addStudent(expectedStudent);

        assertEquals(expectedStudent, actualStudent);
    }

    @Test
    public void testUpdateStudent_shouldReturnStudent(){
        expectedStudent = studentDao.getStudent(testStudentId);
        expectedStudent.setEmail("testEmail@test.com");
        actualStudent = studentDao.updateStudent(expectedStudent);

        assertEquals(actualStudent, expectedStudent);
    }

    @Test
    public void testDeleteStudent_shouldReturnNull(){
        studentDao.deleteStudent(testStudentId);
        actualStudent = studentDao.getStudent(testStudentId);

        assertEquals(actualStudent,null);
    }
}
