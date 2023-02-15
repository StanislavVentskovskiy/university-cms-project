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
import ua.com.foxminded.model.Teacher;
import ua.com.foxminded.service.impl.SubjectServiceImpl;
import ua.com.foxminded.service.impl.TeacherServiceImpl;
import java.util.List;

@Controller
public class TeacherController {

    @Autowired
    private TeacherServiceImpl teacherService;
    @Autowired
    private SubjectServiceImpl subjectService;

    @GetMapping("/teachers")
    public String getTeachers(Model model){
        model.addAttribute("teachers", teacherService.getTeachers());

        return "teachers";
    }

    @GetMapping("/teachers/new")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'TEACHER')")
    public String showCreateTeacherForm(Model model){
        Teacher teacher = new Teacher();
        List<Subject> listSubjects = subjectService.getSubjects();
        model.addAttribute("teacher", teacher);
        model.addAttribute("listSubjects", listSubjects);

        return "add-teacher";
    }

    @PostMapping("/teachers/save")
    @PreAuthorize("hasAnyAuthority('ADMIN','TEACHER')")
    public String saveTeacher(@ModelAttribute Teacher teacher, Model model){
        model.addAttribute("teacher", teacher);
        teacherService.addTeacher(teacher);

        return "redirect:/teachers";
    }

    @GetMapping("/teachers/delete/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public String deleteTeacher(@PathVariable("id") Integer id){
        teacherService.deleteTeacher(id);

        return "redirect:/teachers";
    }

    @GetMapping("/teachers/edit/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'TEACHER')")
    public String editTeacher(@PathVariable("id") Integer id, Model model){
        Teacher teacher = teacherService.getTeacher(id);
        List<Subject> listSubject = subjectService.getSubjects();
        model.addAttribute("teacher", teacher);
        model.addAttribute("listSubject", listSubject);

        return "teacher-edit";
    }

    @PostMapping("/teachers/update/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'TEACHER')")
    public String updateStudent(@PathVariable("id") Integer id, Teacher teacher){
        teacher.setId(id);
        teacherService.updateTeacher(teacher);

        return "redirect:/teachers";
    }
}
