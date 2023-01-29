package ua.com.foxminded.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.foxminded.dao.impl.UserDaoImpl;
import ua.com.foxminded.dao.repository.UserRepository;
import ua.com.foxminded.model.UserEntity;
import ua.com.foxminded.service.UserService;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserDaoImpl userDao;

    public List<UserEntity> getUsers(){
        return userDao.getUsers();
    }

    public UserEntity getUser(int id){
        return userRepository.findById(id).get();
    }

    public UserEntity saveUser(UserEntity user){
        return userDao.updateUser(user).get();
    }
}
