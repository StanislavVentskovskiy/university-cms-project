package ua.com.foxminded.service;


import ua.com.foxminded.dto.RegistrationDto;

public interface UserService {
    void saveUser(RegistrationDto registrationDto);
}
