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

    public Lesson updateLesson(Lesson lesson){
        Optional<Lesson> lessonOptional = lessonRepository.findById(lesson.getId());
        Lesson other = lessonOptional.get();
        if (other!=null) {
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

    public List<Lesson> getLessons(){
        return lessonRepository.findAll();
    }
}
