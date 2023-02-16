package ua.com.foxminded.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ua.com.foxminded.model.Subject;
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

    @GetMapping("/subjects/delete/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String deleteSubject(@PathVariable("id") Integer id){
        subjectService.deleteSubject(id);

        return "redirect:/subjects";
    }

    @GetMapping("/subjects/edit/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','TEACHER')")
    public String updateSubjects(@PathVariable("id") Integer id, Model model){
        Subject subject = subjectService.getSubject(id).get();
        model.addAttribute("subject", subject);

        return "subjects-update";
    }

    @PostMapping("/subjects/update/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','TEACHER')")
    public String saveUpdatedRoom(@PathVariable("id") Integer id, Subject subject){
        subject.setId(id);
        subjectService.updateSubject(subject);

        return "redirect:/subjects";
    }

    @GetMapping("/subjects/new")
    @PreAuthorize("hasAnyAuthority('ADMIN','TEACHER')")
    public String showCreateRoomForm(Model model){
        Subject subject = new Subject();
        model.addAttribute("subject", subject);

        return "subjects-create";
    }

    @PostMapping("/subjects/save")
    @PreAuthorize("hasAnyAuthority('ADMIN','TEACHER')")
    public String saveSubject(@ModelAttribute Subject subject, Model model){
        model.addAttribute("subject", subject);
        subjectService.addSubject(subject);

        return "redirect:/subjects";
    }
}