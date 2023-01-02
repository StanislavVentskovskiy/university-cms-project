package ua.com.foxminded.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.com.foxminded.dao.LessonDao;
import ua.com.foxminded.dao.repository.LessonRepository;
import ua.com.foxminded.model.Lesson;
import java.util.List;
import java.util.Optional;

@Repository
public class LessonDaoImpl implements LessonDao {

    @Autowired
    LessonRepository lessonRepository;

    public Optional<Lesson> getLesson(int lessonId){
        return lessonRepository.findById(lessonId);
    }

    public Lesson addLesson(Lesson lesson){
        lessonRepository.save(lesson);

        return lesson;
    }

    public Optional<Lesson> updateLesson(Lesson lesson){
        Optional<Lesson> other = lessonRepository.findById(lesson.getId());
        if(other.isPresent()){
            other.get().setDate(lesson.getDate());
            other.get().setEndTime(lesson.getEndTime());
            other.get().setStartTime(lesson.getStartTime());
            other.get().setDate(lesson.getDate());
            other.get().setGroupId(lesson.getGroupId());
            other.get().setRoomId(lesson.getRoomId());
            other.get().setTeacherId(lesson.getTeacherId());
            lessonRepository.save(other.get());
        }

        return other;
    }

    public void deleteLesson(int lessonId){
        lessonRepository.deleteById(lessonId);
    }

    public List<Lesson> getLessons(){
        return lessonRepository.findAll();
    }
}
