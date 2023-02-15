package ua.com.foxminded.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ua.com.foxminded.model.Group;
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

    @GetMapping("/groups/delete/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String deleteGroup(@PathVariable("id") Integer id){
        groupService.deleteGroup(id);
        return "redirect:/lessons";
    }

    @GetMapping("/groups/edit/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','TEACHER')")
    public String updateGroup(@PathVariable("id") Integer id, Model model){
        Group group = groupService.getGroup(id).get();
        model.addAttribute("group", group);

        return "group-edit";
    }

    @PostMapping("/groups/update/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','TEACHER')")
    public String saveUpdatedGroup(@PathVariable("id") Integer id, Group group){
        group.setId(id);
        groupService.updateGroup(group);

        return "redirect:/groups";
    }

    @GetMapping("/groups/new")
    @PreAuthorize("hasAnyAuthority('ADMIN','TEACHER')")
    public String showCreateGroupForm(Model model){
        Group group = new Group();
        model.addAttribute("group", group);

        return "group-create";
    }

    @PostMapping("/groups/save")
    @PreAuthorize("hasAnyAuthority('ADMIN','TEACHER')")
    public String saveGroup(@ModelAttribute Group group, Model model){
        model.addAttribute("group", group);
        groupService.addGroup(group);

        return "redirect:/groups";
    }
}
