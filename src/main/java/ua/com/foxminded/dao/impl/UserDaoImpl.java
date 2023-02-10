package ua.com.foxminded.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.com.foxminded.dao.UserDao;
import ua.com.foxminded.dao.repository.RoleRepository;
import ua.com.foxminded.dao.repository.UserRepository;
import ua.com.foxminded.model.Role;
import ua.com.foxminded.model.UserEntity;
import java.util.List;
import java.util.Optional;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;


    public List<UserEntity> getUsers(){
        return userRepository.findAll();
    }

    public Optional<UserEntity> updateUser(UserEntity user){
        Optional<UserEntity> other = userRepository.findById(user.getId());
        Role userRole = roleRepository.findById(user.getNewRoleId()).get();
        if(other.isPresent()){
            other.get().setUsername(user.getUsername());
            List<Role> roles = other.get().getRoles();
            if(!(roles.contains(userRole))){
                roles.add(userRole);
            }
            userRepository.save(other.get());
        }
        return other;
    }
}
