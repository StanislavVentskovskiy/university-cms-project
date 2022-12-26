package ua.com.foxminded.dao;

import ua.com.foxminded.model.Student;
import java.util.Optional;

public interface StudentDao {

    Optional<Student> getStudent(int studentId);

    Student addStudent(Student student);

    Optional<Student> updateStudent(Student student);

    void deleteStudent(int studentId);
}
