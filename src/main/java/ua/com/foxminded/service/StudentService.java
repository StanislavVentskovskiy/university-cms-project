package ua.com.foxminded.service;

import ua.com.foxminded.model.Student;
import java.util.List;

public interface StudentService {

    Student getStudent(int studentId);

    Student addStudent(Student student);

    Student updateStudent(Student student);

    void deleteStudent(int studentId);

    List<Student> getStudents();
}
