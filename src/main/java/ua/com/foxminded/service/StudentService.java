package ua.com.foxminded.service;

import ua.com.foxminded.model.Student;

import java.util.Optional;

public interface StudentService {

    Optional<Student> getStudent(int studentId);

    Student addStudent(Student student);

    Optional<Student> updateStudent(Student student);

    void deleteStudent(int studentId);
}
