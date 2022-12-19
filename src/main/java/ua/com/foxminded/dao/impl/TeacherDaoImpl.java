package ua.com.foxminded.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.com.foxminded.dao.TeacherDao;
import ua.com.foxminded.dao.repository.TeacherRepository;
import ua.com.foxminded.model.Teacher;

@Repository
public class TeacherDaoImpl implements TeacherDao {

    @Autowired
    TeacherRepository teacherRepository;

    public Teacher getTeacher(int teacherId){
        return teacherRepository.findById(teacherId).orElse(null);
    }

    public Teacher addTeacher(Teacher teacher){
        teacherRepository.save(teacher);

        return teacher;
    }

    public Teacher updateTeacher(Teacher teacher){
        Teacher other = teacherRepository.findById(teacher.getId()).orElse(null);
        if(other != null){
            other.setName(teacher.getName());
            other.setEmail(teacher.getEmail());
            other.setBirthday(teacher.getBirthday());
            other.setSubjectId(teacher.getSubjectId());
            other.setPosition(teacher.getPosition());
            teacherRepository.save(other);
        }

        return other;
    }

    public void deleteTeacher(int teacherId){
        teacherRepository.deleteById(teacherId);
    }
}
