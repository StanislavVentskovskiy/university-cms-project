package ua.com.foxminded.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {

    @Value("${spring.application.name}")
    String applicationName;

    @GetMapping("/index")
    public String homePage(Model model){
        model.addAttribute("applicationName", applicationName);
        return "index";
    }
}
