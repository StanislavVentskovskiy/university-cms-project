package ua.com.foxminded.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.foxminded.dao.impl.TeacherDaoImpl;
import ua.com.foxminded.model.Teacher;
import ua.com.foxminded.service.TeacherService;
import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    TeacherDaoImpl teacherDao;

    public List<Teacher> getTeachers(){
        return teacherDao.getTeachers();
    };

    public Optional<Teacher> getTeacher(int teacherId){
        return teacherDao.getTeacher(teacherId);
    }

    public Teacher addTeacher(Teacher teacher){
        return teacherDao.addTeacher(teacher);
    }

    public Optional<Teacher> updateTeacher(Teacher teacher){
        return teacherDao.updateTeacher(teacher);
    }

    public void deleteTeacher(int teacherId){
        teacherDao.deleteTeacher(teacherId);
    }
}
