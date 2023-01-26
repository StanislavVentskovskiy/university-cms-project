package ua.com.foxminded.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import ua.com.foxminded.dao.repository.RoleRepository;
import ua.com.foxminded.dao.repository.UserRepository;
import ua.com.foxminded.dto.RegistrationDto;
import ua.com.foxminded.model.Role;
import ua.com.foxminded.model.UserEntity;
import ua.com.foxminded.service.UserService;

import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void saveUser(RegistrationDto registrationDto) {
        UserEntity user = new UserEntity();
        user.setUsername(registrationDto.getUsername());
        user.setPassword(registrationDto.getPassword());
        Role role = roleRepository.findByName("${default.user.role}").get();
        user.setRoles(Arrays.asList(role));
        userRepository.save(user);
    }
}
