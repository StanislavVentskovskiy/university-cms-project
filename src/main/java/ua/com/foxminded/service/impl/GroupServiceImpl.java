package ua.com.foxminded.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.foxminded.dao.impl.GroupDaoImpl;
import ua.com.foxminded.model.Group;
import ua.com.foxminded.service.GroupService;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    GroupDaoImpl groupDaoImpl;

    public Group addGroup(Group group){
        return groupDaoImpl.addGroup(group);
    }

    public Group updateGroup(Group group){
        return groupDaoImpl.updateGroup(group);
    }

    public void deleteGroup(int groupId){
        groupDaoImpl.deleteGroup(groupId);
    }

    public Group getGroup(int groupId){
        return groupDaoImpl.getGroup(groupId);
    }
}
