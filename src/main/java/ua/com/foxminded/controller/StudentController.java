package ua.com.foxminded.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ua.com.foxminded.service.StudentService;
import ua.com.foxminded.service.impl.RoomServiceImpl;
import ua.com.foxminded.service.impl.StudentServiceImpl;

@Controller
public class StudentController {

    @Autowired
    StudentServiceImpl studentService;

    @GetMapping("/students")
    public String getStudents(Model model){
        model.addAttribute("students", studentService.getStudents());
        return "students";
    }
}
