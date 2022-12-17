package ua.com.foxminded.dao;

import ua.com.foxminded.model.Teacher;

public interface TeacherDao {

    Teacher addTeacher(Teacher teacher);

    Teacher updateTeacher(Teacher teacher);

    void deleteTeacher(int teacherId);
}
