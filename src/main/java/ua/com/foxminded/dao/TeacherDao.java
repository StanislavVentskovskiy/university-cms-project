package ua.com.foxminded.dao;

import ua.com.foxminded.model.Teacher;

import java.util.Optional;

public interface TeacherDao {

    Optional<Teacher> getTeacher(int teacherId);

    Teacher addTeacher(Teacher teacher);

    Optional<Teacher> updateTeacher(Teacher teacher);

    void deleteTeacher(int teacherId);
}
