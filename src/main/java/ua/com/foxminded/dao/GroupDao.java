package ua.com.foxminded.dao;

import ua.com.foxminded.model.Group;

import java.util.List;
import java.util.Optional;

public interface GroupDao {

    List<Group> getGroups();

    Group addGroup(Group group);

    Optional<Group> updateGroup(Group group);

    void deleteGroup(int groupId);

    Optional<Group> getGroup(int groupId);
}
