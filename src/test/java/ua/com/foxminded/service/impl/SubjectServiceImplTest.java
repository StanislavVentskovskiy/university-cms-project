package ua.com.foxminded.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import ua.com.foxminded.dao.impl.SubjectDaoImpl;
import ua.com.foxminded.model.Subject;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SubjectServiceImplTest {
    @Autowired
    SubjectServiceImpl subjectService;
    @MockBean
    SubjectDaoImpl subjectDao;

    private Subject testSubject;
    private int testSubjectId = 1;

    @Test
    public void getSubjectTest_shouldCallDaoMethod(){
        subjectService.getSubject(testSubjectId);
        verify(subjectDao, Mockito.times(1)).getSubject(Mockito.anyInt());
    }

    @Test
    public void addSubjectTest_shouldCallDaoMethod(){
        subjectService.addSubject(testSubject);
        verify(subjectDao, Mockito.times(1)).addSubject(Mockito.any());
    }

    @Test
    public void updateSubjectTest_shouldCallDaoMethod(){
        subjectService.updateSubject(testSubject);
        verify(subjectDao, Mockito.times(1)).updateSubject(Mockito.any());
    }

    @Test
    public void deleteSubjectTest_shouldCallDaoMethod(){
        subjectService.deleteSubject(testSubjectId);
        verify(subjectDao, Mockito.times(1)).deleteSubject(Mockito.anyInt());
    }
}
