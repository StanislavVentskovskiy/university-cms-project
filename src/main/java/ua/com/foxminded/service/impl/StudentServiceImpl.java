package ua.com.foxminded.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.foxminded.dao.impl.StudentDaoImpl;
import ua.com.foxminded.model.Student;
import ua.com.foxminded.service.StudentService;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentDaoImpl studentDaoImpl;

    public Optional<Student> getStudent(int studentId){
        return studentDaoImpl.getStudent(studentId);
    }

    public Student addStudent(Student student){
        return studentDaoImpl.addStudent(student);
    }

    public Optional<Student> updateStudent(Student student){
        return studentDaoImpl.updateStudent(student);
    }

    public void deleteStudent(int studentId){
        studentDaoImpl.deleteStudent(studentId);
    }

    public List<Student> getStudents(){
        return studentDaoImpl.getStudents();
    }
}
