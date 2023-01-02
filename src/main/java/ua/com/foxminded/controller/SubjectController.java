package ua.com.foxminded.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ua.com.foxminded.service.impl.SubjectServiceImpl;

@Controller
public class SubjectController {

    @Autowired
    private SubjectServiceImpl subjectService;

    @GetMapping("/subjects")
    public String getTeachers(Model model){
        model.addAttribute("subjects", subjectService.getSubjects());
        return "subjects";
    }
}