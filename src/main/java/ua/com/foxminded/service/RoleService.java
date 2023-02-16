package ua.com.foxminded.service;

import ua.com.foxminded.model.Role;
import java.util.List;

public interface RoleService {

    List<Role> getAllRoles();

    Role addRole(Role role);
}
