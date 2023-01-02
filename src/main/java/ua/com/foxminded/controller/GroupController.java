package ua.com.foxminded.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ua.com.foxminded.service.impl.GroupServiceImpl;

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
