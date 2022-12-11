package ua.com.foxminded.service;

import ua.com.foxminded.model.Student;

public interface StudentService {

    Student addStudent(Student student);

    Student updateStudent(Student student);

    void deleteStudent(int studentId);
}
