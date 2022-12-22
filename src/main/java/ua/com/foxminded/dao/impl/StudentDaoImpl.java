package ua.com.foxminded.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.com.foxminded.dao.StudentDao;
import ua.com.foxminded.dao.repository.StudentRepository;
import ua.com.foxminded.model.Student;
import java.util.Optional;

@Repository
public class StudentDaoImpl implements StudentDao {

    @Autowired
    StudentRepository studentRepository;

    public Optional<Student> getStudent(int studentId){
        return studentRepository.findById(studentId);
    }

    public Student addStudent(Student student){
        studentRepository.save(student);

        return student;
    }

    public Optional<Student> updateStudent(Student student){
        Optional<Student> other = studentRepository.findById(student.getId());
        if(other.isPresent()){
            other.get().setName(student.getName());
            other.get().setBirthsday(student.getBirthsday());
            other.get().setCourse(student.getCourse());
            other.get().setEmail(student.getEmail());
            other.get().setGroupId(student.getGroupId());
            studentRepository.save(other.get());
        }

        return other;
    }

    public void deleteStudent(int studentId){
        studentRepository.deleteById(studentId);
    }
}
