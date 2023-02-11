package ua.com.foxminded.service;

import ua.com.foxminded.model.Group;

import java.util.Optional;

public interface GroupService {

    void deleteGroup(int groupId);

    Group addGroup(Group group);

    Group updateGroup(Group group);

    Group getGroup(int groupId);
}
