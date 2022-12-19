package ua.com.foxminded.dao.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import ua.com.foxminded.model.Subject;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@Sql(scripts = {"classpath:test-schema.sql"})
@SpringBootTest
public class SubjectDaoImplTest {

    @Autowired
    SubjectDaoImpl subjectDao;

    private Subject expectedSubject;
    private Subject actualSubject;
    private int testSubjectId = 1;

    @Before
    public void initTestData(){
        expectedSubject = new Subject();

    }

    @Test
    public void testGetSubject_shouldReturnSubject(){
        actualSubject = subjectDao.getSubject(testSubjectId);

        assertTrue(actualSubject instanceof Subject);
    }

    @Test
    public void testAddSubject_shouldReturnSubject(){
       actualSubject = subjectDao.addSubject(expectedSubject);

       assertEquals(actualSubject, expectedSubject);
    }

    @Test
    public void testUpdateSubject_shouldReturnSubject(){
        expectedSubject.setName("testData");
        actualSubject = subjectDao.updateSubject(expectedSubject);

        assertEquals(actualSubject, expectedSubject);
    }

    @Test
    public void testDeleteSubject_shouldReturnNull(){
        subjectDao.deleteSubject(testSubjectId);
        actualSubject = subjectDao.getSubject(testSubjectId);

        assertEquals(actualSubject, null);
    }
}
