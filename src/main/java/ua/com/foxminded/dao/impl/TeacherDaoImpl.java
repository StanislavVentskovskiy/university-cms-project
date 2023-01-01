package ua.com.foxminded.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.com.foxminded.dao.TeacherDao;
import ua.com.foxminded.dao.repository.TeacherRepository;
import ua.com.foxminded.model.Teacher;

import java.util.List;
import java.util.Optional;

@Repository
public class TeacherDaoImpl implements TeacherDao {

    @Autowired
    TeacherRepository teacherRepository;

    public Optional<Teacher> getTeacher(int teacherId){
        return teacherRepository.findById(teacherId);
    }

    public Teacher addTeacher(Teacher teacher){
        teacherRepository.save(teacher);

        return teacher;
    }

    public Optional<Teacher> updateTeacher(Teacher teacher){
        Optional<Teacher> other = teacherRepository.findById(teacher.getId());
        if(other.isPresent()){
            other.get().setName(teacher.getName());
            other.get().setEmail(teacher.getEmail());
            other.get().setBirthday(teacher.getBirthday());
            other.get().setSubjectId(teacher.getSubjectId());
            other.get().setPosition(teacher.getPosition());
            teacherRepository.save(other.get());
        }

        return other;
    }

    public void deleteTeacher(int teacherId){
        teacherRepository.deleteById(teacherId);
    }

    public List<Teacher> getTeachers(){
        return teacherRepository.findAll();
    }
}
