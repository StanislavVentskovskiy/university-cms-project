package ua.com.foxminded.dao;

import ua.com.foxminded.model.Group;

public interface GroupDao {

    Group addGroup(Group group);

    Group updateGroup(Group group);

    void deleteGroup(int groupId);

    Group getGroup(int groupId);
}
