package ua.com.foxminded.dao.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import ua.com.foxminded.model.Group;
import java.util.Optional;
import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@Sql(scripts = {"classpath:test-schema.sql"})
@SpringBootTest
public class GroupDaoImplTest {
    @Mock
    GroupDaoImpl groupDaoImpl;

    private Group expectedGroup;
    private Group actualGroup;
    Optional<Group> expectedOptional;
    Optional<Group> actualOptional;
    private int testGroupId = 1;

    @Test
    public void testAddGroup_shouldReturnGroup(){
        Mockito.when(groupDaoImpl.addGroup(expectedGroup)).thenReturn(expectedGroup);
        actualGroup = groupDaoImpl.addGroup(expectedGroup);
        assertEquals(expectedGroup,actualGroup);
    }

    @Test
    public void testUpdateGroup_shouldReturnOptionalGroup(){
        Mockito.when(groupDaoImpl.updateGroup(expectedGroup)).thenReturn(expectedOptional);
        actualOptional = groupDaoImpl.updateGroup(expectedGroup);
        assertEquals(actualOptional, expectedOptional);
    }

    @Test
    public void testDeleteGroup_shouldReturnTrue(){
        groupDaoImpl.deleteGroup(testGroupId);
        verify(groupDaoImpl,Mockito.times(1)).deleteGroup(Mockito.anyInt());
    }

    @Test
    public void testGetGroup_shouldReturnOptionalGroup(){
        Mockito.when(groupDaoImpl.getGroup(testGroupId)).thenReturn(expectedOptional);
        actualOptional = groupDaoImpl.getGroup(testGroupId);
        assertEquals(actualOptional,expectedOptional);
    }
}
