package ua.com.foxminded.service;

import ua.com.foxminded.model.UserEntity;
import java.util.List;

public interface UserService {

    List<UserEntity> getUsers();

    UserEntity getUser(int id);

    UserEntity saveUser(UserEntity user);
}
