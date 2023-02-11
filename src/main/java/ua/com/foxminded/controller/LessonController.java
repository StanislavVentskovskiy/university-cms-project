package ua.com.foxminded.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ua.com.foxminded.dto.LessonDto;
import ua.com.foxminded.model.*;
import ua.com.foxminded.service.impl.*;
import java.util.List;

@Controller
public class LessonController {

    @Autowired
    LessonServiceImpl lessonService;

    @Autowired
    RoomServiceImpl roomService;

    @Autowired
    GroupServiceImpl groupService;

    @Autowired
    SubjectServiceImpl subjectService;

    @Autowired
    TeacherServiceImpl teacherService;

    @GetMapping("/lessons")
    public String getLessons(Model model){
        model.addAttribute("lessons", lessonService.getLessons());
        return "lessons";
    }

    @GetMapping("/lessons/new")
    @PreAuthorize("hasAnyAuthority('ADMIN','TEACHER')")
    public String showCreateUserForm(Model model){
        LessonDto lessonDto = new LessonDto();
        List<Room> listRooms = roomService.getRooms();
        List<Group> listGroups = groupService.getGroups();
        List<Subject> listSubjects = subjectService.getSubjects();
        List<Teacher> listTeachers = teacherService.getTeachers();
        model.addAttribute("lessonDto", lessonDto);
        model.addAttribute("listRooms", listRooms);
        model.addAttribute("listGroups", listGroups);
        model.addAttribute("listSubjects", listSubjects);
        model.addAttribute("listTeachers", listTeachers);

        return "lesson-create";
    }

    @PostMapping("/lessons/save")
    @PreAuthorize("hasAnyAuthority('ADMIN','TEACHER')")
    public String saveLesson(@ModelAttribute LessonDto lessonDto, Model model){
        model.addAttribute("lessonDto", lessonDto);
        lessonService.addLesson(lessonService.mapLessonDtoToLesson(lessonDto));

        return "redirect:/lessons";
    }

    @GetMapping("/lessons/delete/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String deleteLesson(@PathVariable("id") Integer id, Model model){
        lessonService.deleteLesson(id);

        return "redirect:/lessons";
    }

    @GetMapping("/lessons/edit/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','TEACHER')")
    public String updateLesson(@PathVariable("id") Integer id, Model model){
        Lesson lesson = lessonService.getLesson(id);
        List<Room> listRooms = roomService.getRooms();
        List<Group> listGroups = groupService.getGroups();
        List<Subject> listSubjects = subjectService.getSubjects();
        List<Teacher> listTeachers = teacherService.getTeachers();
        model.addAttribute("lesson", lesson);
        model.addAttribute("listRooms", listRooms);
        model.addAttribute("listGroups", listGroups);
        model.addAttribute("listSubjects", listSubjects);
        model.addAttribute("listTeachers", listTeachers);

        return "lesson-edit";
    }

    @PostMapping("/lessons/update/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','TEACHER')")
    public String saveUpdatedLesson(@PathVariable("id") Integer id, Lesson lesson){
        lesson.setId(id);
        lessonService.updateLesson(lesson);

        return "redirect:/lessons";
    }
}
