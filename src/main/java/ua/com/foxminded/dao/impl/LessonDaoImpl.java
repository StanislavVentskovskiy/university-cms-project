package ua.com.foxminded.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.com.foxminded.dao.LessonDao;
import ua.com.foxminded.dao.repository.LessonRepository;
import ua.com.foxminded.model.Lesson;

@Repository
public class LessonDaoImpl implements LessonDao {

    @Autowired
    LessonRepository lessonRepository;

    public Lesson getLesson(int lessonId){
        return lessonRepository.findById(lessonId).orElse(null);
    }

    public Lesson addLesson(Lesson lesson){
        lessonRepository.save(lesson);

        return lesson;
    }

    public Lesson updateLesson(Lesson lesson){
        Lesson other = lessonRepository.findById(lesson.getId()).orElse(null);
        if(other != null){
            other.setDate(lesson.getDate());
            other.setEndTime(lesson.getEndTime());
            other.setStartTime(lesson.getStartTime());
            other.setDate(lesson.getDate());
            other.setGroupId(lesson.getGroupId());
            other.setRoomId(lesson.getRoomId());
            other.setTeacherId(lesson.getTeacherId());
            lessonRepository.save(other);
        }

        return other;
    }

    public void deleteLesson(int lessonId){
        lessonRepository.deleteById(lessonId);
    }
}
