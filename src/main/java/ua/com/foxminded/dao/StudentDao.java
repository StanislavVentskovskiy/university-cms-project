package ua.com.foxminded.dao;

import ua.com.foxminded.model.Student;

public interface StudentDao {

    Student getStudent(int studentId);

    Student addStudent(Student student);

    Student updateStudent(Student student);

    void deleteStudent(int studentId);
}
