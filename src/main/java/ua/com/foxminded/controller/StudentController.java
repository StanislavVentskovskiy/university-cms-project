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
import ua.com.foxminded.model.Student;
import ua.com.foxminded.service.impl.GroupServiceImpl;
import ua.com.foxminded.service.impl.StudentServiceImpl;
import java.util.List;

@Controller
public class StudentController {

    @Autowired
    StudentServiceImpl studentService;
    @Autowired
    GroupServiceImpl groupService;

    @GetMapping("/students")
    public String getStudents(Model model){
        model.addAttribute("students", studentService.getStudents());

        return "students";
    }

    @GetMapping("/students/new")
    @PreAuthorize("hasAnyAuthority('ADMIN','TEACHER')")
    public String showCreateStudentForm(Model model){
        Student student = new Student();
        List<Group> listGroups = groupService.getGroups();
        model.addAttribute("listGroups", listGroups);
        model.addAttribute("student", student);

        return "add-student";
    }

    @PostMapping("/students/save")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'TEACHER')")
    public String saveStudent(@ModelAttribute Student student, Model model){
        model.addAttribute("student", student);
        studentService.addStudent(student);

        return "redirect:/students";
    }

    @GetMapping("/students/delete/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public String deleteStudent(@PathVariable("id") Integer id, Model model){
        studentService.deleteStudent(id);

        return "redirect:/students";
    }

    @GetMapping("/students/edit/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'TEACHER')")
    public String editStudent(@PathVariable("id") Integer id, Model model){
        Student student = studentService.getStudent(id);
        List<Group> groupList = groupService.getGroups();
        model.addAttribute("student", student);
        model.addAttribute("groupList", groupList);

        return "student-edit";
    }

    @PostMapping("/students/update/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'TEACHER')")
    public String updateStudent(@PathVariable("id") Integer id, Student student){
        student.setId(id);
        studentService.updateStudent(student);

        return "redirect:/students";
    }
}
