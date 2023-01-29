package ua.com.foxminded.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ua.com.foxminded.dto.UserDto;
import ua.com.foxminded.model.Role;
import ua.com.foxminded.model.UserEntity;
import ua.com.foxminded.service.impl.RoleServiceImpl;
import ua.com.foxminded.service.impl.UserServiceImpl;
import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private RoleServiceImpl roleService;

    @GetMapping("/admin-panel")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String loginPage(Model model){
        model.addAttribute("users", userService.getUsers());
        return "admin-panel";
    }

    @GetMapping("/admin-panel/edit/{id}")
    public String editUser(@PathVariable("id") Integer id, Model model){
        UserEntity user = userService.getUser(id);
        List<Role> listRoles = roleService.getAllRoles();
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        model.addAttribute("user", user);
        model.addAttribute("listRoles", listRoles);
        return "user-edit";
    }

    @PostMapping("/admin-panel/save")
    public String saveUser(UserEntity user){
        userService.saveUser(user);
        return "redirect:/admin-panel";
    }
}
