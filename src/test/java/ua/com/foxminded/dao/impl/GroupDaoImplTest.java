package ua.com.foxminded.dao.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import ua.com.foxminded.model.Group;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@Sql(scripts = {"classpath:test-schema.sql"})
@SpringBootTest
public class GroupDaoImplTest {

    @Autowired
    GroupDaoImpl groupDaoImpl;

    private Group expectedGroup;
    private Group actualGroup;
    private Group secondExpectedGroup;

    @Before
    public void initTestData(){
        expectedGroup = new Group("test");
        secondExpectedGroup = new Group("test");
        groupDaoImpl.addGroup(secondExpectedGroup);
    }

    @Test
    public void testAddGroup_shouldReturnGroup(){
        actualGroup = groupDaoImpl.addGroup(expectedGroup);

        assertEquals(expectedGroup,actualGroup);
    }

    @Test
    public void testUpdateGroup_shouldReturnGroup(){
        secondExpectedGroup.setName("test2");
        actualGroup = groupDaoImpl.updateGroup(secondExpectedGroup);

        assertEquals(secondExpectedGroup, actualGroup);
    }

    @Test
    public void testDeleteGroup_shouldReturnNull(){
        groupDaoImpl.deleteGroup(secondExpectedGroup.getId());

        assertNull(groupDaoImpl.getGroup(secondExpectedGroup.getId()));
    }

    @Test
    public void testGetGroup_shouldReturnGroup(){
        actualGroup = groupDaoImpl.getGroup(secondExpectedGroup.getId());

        assertEquals(actualGroup,secondExpectedGroup);
    }
}
