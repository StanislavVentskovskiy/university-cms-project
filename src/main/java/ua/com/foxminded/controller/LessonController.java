package ua.com.foxminded.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ua.com.foxminded.service.impl.LessonServiceImpl;

@Controller
public class LessonController {

    @Autowired
    LessonServiceImpl lessonService;

    @GetMapping("/lessons")
    public String getLessons(Model model){
        model.addAttribute("lessons", lessonService.getLessons());
        return "lessons";
    }
}
