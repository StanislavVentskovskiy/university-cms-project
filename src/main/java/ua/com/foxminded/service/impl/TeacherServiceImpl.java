package ua.com.foxminded.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import ua.com.foxminded.model.Teacher;
import ua.com.foxminded.service.TeacherService;

public class TeacherServiceImpl implements TeacherService {

    @Autowired
    TeacherServiceImpl teacherService;

    public Teacher addTeacher(Teacher teacher){
        return teacherService.addTeacher(teacher);
    }

    public Teacher updateTeacher(Teacher teacher){
        return teacherService.updateTeacher(teacher);
    }

    public void deleteTeacher(int teacherId){
        teacherService.deleteTeacher(teacherId);
    }
}
