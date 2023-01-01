package ua.com.foxminded.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.com.foxminded.dao.GroupDao;
import ua.com.foxminded.dao.repository.GroupRepository;
import ua.com.foxminded.model.Group;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class GroupDaoImpl implements GroupDao {

    @Autowired
    GroupRepository groupRepository;

    public List<Group> getGroups(){
        return groupRepository.findAll();
    }

    public Group addGroup(Group group){
        return groupRepository.save(group);
    }

    public Optional<Group> getGroup(int groupId){
        return groupRepository.findById(groupId);
    }

    public Optional<Group> updateGroup(Group group){
        Optional<Group> other = groupRepository.findById(group.getId());
        if (other.isPresent()) {
            other.get().setName(group.getName());
            groupRepository.save(other.get());
        }

      return other;
    }

    public void deleteGroup(int groupId){
        groupRepository.deleteById(groupId);
    }
}
