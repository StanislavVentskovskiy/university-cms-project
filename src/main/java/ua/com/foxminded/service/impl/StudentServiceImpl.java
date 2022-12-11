package ua.com.foxminded.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import ua.com.foxminded.dao.impl.StudentDaoImpl;
import ua.com.foxminded.model.Student;
import ua.com.foxminded.service.StudentService;

public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentDaoImpl studentDaoImpl;

    public Student addStudent(Student student){
        return studentDaoImpl.addStudent(student);
    }

    public Student updateStudent(Student student){
        return studentDaoImpl.updateStudent(student);
    }

    public void deleteStudent(int studentId){
        studentDaoImpl.deleteStudent(studentId);
    }
}
