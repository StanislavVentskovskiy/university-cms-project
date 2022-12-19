package ua.com.foxminded.service;

import ua.com.foxminded.model.Teacher;

public interface TeacherService {

    Teacher getTeacher(int teacherId);

    Teacher addTeacher(Teacher teacher);

    Teacher updateTeacher(Teacher teacher);

    void deleteTeacher(int teacherId);
}
