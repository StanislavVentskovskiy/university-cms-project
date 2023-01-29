package ua.com.foxminded.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.foxminded.model.UserEntity;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity,Integer> {
    Optional<UserEntity> findByUsername(String username);
}
