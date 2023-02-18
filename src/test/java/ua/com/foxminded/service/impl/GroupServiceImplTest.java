package ua.com.foxminded.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import ua.com.foxminded.dao.impl.GroupDaoImpl;
import ua.com.foxminded.model.Group;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GroupServiceImplTest {
    @Autowired
    private GroupServiceImpl groupService;
    @MockBean
    private GroupDaoImpl groupDao;

    private Group testGroup = new Group("test");
    private int testGroupId = 1;

    @Test
    public void addGroupTest_shouldCallDaoMethod(){
        groupService.addGroup(testGroup);
        verify(groupDao, Mockito.times(1)).addGroup(Mockito.any());
    }

    @Test
    public void updateGroupTest_shouldCallDaoMethod(){
        groupService.updateGroup(testGroup);
        verify(groupDao, Mockito.times(1)).updateGroup(Mockito.any());
    }

    @Test
    public void deleteGroupTest_shouldCallDaoMethod(){
        groupService.deleteGroup(testGroupId);
        verify(groupDao, Mockito.times(1)).deleteGroup(Mockito.anyInt());
    }

    @Test
    public void getGroupTest_shouldCallDaoMehtod(){
        groupService.getGroup(testGroupId);
        verify(groupDao, Mockito.times(1)).getGroup(Mockito.anyInt());
    }
}
