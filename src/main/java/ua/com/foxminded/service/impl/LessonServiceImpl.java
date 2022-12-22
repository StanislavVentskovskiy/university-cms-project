package ua.com.foxminded.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.foxminded.dao.impl.LessonDaoImpl;
import ua.com.foxminded.model.Lesson;
import ua.com.foxminded.service.LessonService;

import java.util.Optional;

@Service
public class LessonServiceImpl implements LessonService {

    @Autowired
    LessonDaoImpl lessonDaoImpl;

    public Lesson addLesson(Lesson lesson){
        return lessonDaoImpl.addLesson(lesson);
    }

    public Optional<Lesson> updateLesson(Lesson lesson){
        return lessonDaoImpl.updateLesson(lesson);
    }

    public void deleteLesson(int lessonId){
        lessonDaoImpl.deleteLesson(lessonId);
    }

    public Optional<Lesson> getLesson(int lessonId){
        return lessonDaoImpl.getLesson(lessonId);
    }
}
