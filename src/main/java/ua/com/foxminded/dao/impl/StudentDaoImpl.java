package ua.com.foxminded.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import ua.com.foxminded.dao.StudentDao;
import ua.com.foxminded.dao.repository.StudentRepository;
import ua.com.foxminded.model.Student;

public class StudentDaoImpl implements StudentDao {

    @Autowired
    StudentRepository studentRepository;

    public Student addStudent(Student student){
        studentRepository.save(student);

        return student;
    }

    public Student updateStudent(Student student){
        Student other = studentRepository.findById(student.getId()).orElse(null);
        if(other != null){
            other.setName(student.getName());
            other.setBirthsday(student.getBirthsday());
            other.setCourse(student.getCourse());
            other.setEmail(student.getEmail());
            other.setGroupId(student.getGroupId());
            studentRepository.save(other);
        }

        return other;
    }

    public void deleteStudent(int studentId){
        studentRepository.deleteById(studentId);
    }
}
