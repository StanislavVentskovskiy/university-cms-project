package ua.com.foxminded.service;

import ua.com.foxminded.model.Group;

import java.util.Optional;

public interface GroupService {

    void deleteGroup(int groupId);

    Group addGroup(Group group);

    Optional<Group> updateGroup(Group group);

    Optional<Group> getGroup(int groupId);
}
