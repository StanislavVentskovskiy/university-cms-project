package ua.com.foxminded.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.com.foxminded.dao.GroupDao;
import ua.com.foxminded.dao.repository.GroupRepository;
import ua.com.foxminded.model.Group;

@Repository
@Transactional
public class GroupDaoImpl implements GroupDao {

    @Autowired
    GroupRepository groupRepository;

    public Group addGroup(Group group){
        return groupRepository.save(group);
    }

    public Group getGroup(int groupId){
        return groupRepository.findById(groupId).orElse(null);
    }

    public Group updateGroup(Group group){
        Group other = groupRepository.findById(group.getId()).orElse(null);
        if(other != null) {
            other.setName(group.getName());
            return groupRepository.save(other);
        }

        return null;
    }

    public void deleteGroup(int groupId){
        groupRepository.deleteById(groupId);
    }
}
