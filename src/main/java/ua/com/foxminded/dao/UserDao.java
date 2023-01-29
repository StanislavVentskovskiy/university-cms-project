package ua.com.foxminded.dao;


import ua.com.foxminded.model.UserEntity;
import java.util.List;
import java.util.Optional;

public interface UserDao {

    List<UserEntity> getUsers();

    Optional<UserEntity> updateUser(UserEntity user);
}
