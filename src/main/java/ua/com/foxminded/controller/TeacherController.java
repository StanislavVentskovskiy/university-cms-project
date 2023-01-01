package ua.com.foxminded.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ua.com.foxminded.service.TeacherService;
import ua.com.foxminded.service.impl.TeacherServiceImpl;

@Controller
public class TeacherController {

    @Autowired
    private TeacherServiceImpl teacherService;

    @GetMapping("/teachers")
    public String getTeachers(Model model){
        model.addAttribute("teachers", teacherService.getTeachers());
        return "teachers";
    }
}
