package ua.com.foxminded.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.foxminded.model.Role;
import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(String name);
}
