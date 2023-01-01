package ua.com.foxminded.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.com.foxminded.model.Group;
import ua.com.foxminded.model.Student;
import ua.com.foxminded.service.GroupService;
import ua.com.foxminded.service.StudentService;
import ua.com.foxminded.service.impl.GroupServiceImpl;

import java.util.List;

@Controller
public class GroupController {

    @Autowired
    private GroupServiceImpl groupService;

    @GetMapping("/groups")
    public String getGroups(Model model) {
        model.addAttribute("groups", groupService.getGroups());
        return "groups";
    }
}
