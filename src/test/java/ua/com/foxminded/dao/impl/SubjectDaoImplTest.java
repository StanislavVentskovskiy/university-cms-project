package ua.com.foxminded.dao.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import ua.com.foxminded.model.Subject;
import java.util.Optional;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@Sql(scripts = {"classpath:test-schema.sql"})
@SpringBootTest
public class SubjectDaoImplTest {

    @Mock
    SubjectDaoImpl subjectDao;

    private Subject expectedSubject;
    private Subject actualSubject;
    private int testSubjectId = 1;
    private Optional<Subject> expectedOptional;
    private Optional<Subject> actualOptional;

    @Test
    public void testGetSubject_shouldReturnOptionalSubject(){
        Mockito.when(subjectDao.getSubject(testSubjectId)).thenReturn(expectedOptional);
        actualOptional = subjectDao.getSubject(testSubjectId);
        assertEquals(expectedOptional,actualOptional);
    }

    @Test
    public void testAddSubject_shouldReturnSubject(){
       actualSubject = subjectDao.addSubject(expectedSubject);
       assertEquals(actualSubject, expectedSubject);
    }

    @Test
    public void testUpdateSubject_shouldReturnOptionalSubject(){
        Mockito.when(subjectDao.updateSubject(expectedSubject)).thenReturn(expectedOptional);
        actualOptional = subjectDao.updateSubject(expectedSubject);
        assertEquals(actualSubject, expectedSubject);
    }

    @Test
    public void testDeleteSubject_shouldReturnTrue(){
        subjectDao.deleteSubject(testSubjectId);
        verify(subjectDao,Mockito.times(1)).deleteSubject(Mockito.anyInt());
    }
}
