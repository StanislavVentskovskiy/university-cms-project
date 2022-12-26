package ua.com.foxminded.dao;

import ua.com.foxminded.model.Group;

import java.util.Optional;

public interface GroupDao {

    Group addGroup(Group group);

    Optional<Group> updateGroup(Group group);

    void deleteGroup(int groupId);

    Optional<Group> getGroup(int groupId);
}
