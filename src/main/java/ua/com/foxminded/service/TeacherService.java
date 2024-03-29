package ua.com.foxminded.service;

import ua.com.foxminded.model.Teacher;
import java.util.List;
import java.util.Optional;

public interface TeacherService {

    List<Teacher> getTeachers();

    Optional<Teacher> getTeacher(int teacherId);

    Teacher addTeacher(Teacher teacher);

    Optional<Teacher> updateTeacher(Teacher teacher);

    void deleteTeacher(int teacherId);
}
