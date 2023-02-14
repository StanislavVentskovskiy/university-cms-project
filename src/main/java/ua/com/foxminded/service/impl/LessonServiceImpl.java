package ua.com.foxminded.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.foxminded.dao.impl.LessonDaoImpl;
import ua.com.foxminded.dto.LessonDto;
import ua.com.foxminded.model.Lesson;
import ua.com.foxminded.service.LessonService;
import java.util.List;

@Service
public class LessonServiceImpl implements LessonService {

    @Autowired
    LessonDaoImpl lessonDaoImpl;

    public Lesson addLesson(Lesson lesson){
        return lessonDaoImpl.addLesson(lesson);
    }

    public Lesson updateLesson(Lesson lesson){
        return lessonDaoImpl.updateLesson(lesson);
    }

    public void deleteLesson(int lessonId){
        lessonDaoImpl.deleteLesson(lessonId);
    }

    public Lesson getLesson(int lessonId){
        return lessonDaoImpl.getLesson(lessonId).get();
    }

    public List<Lesson> getLessons(){
        return lessonDaoImpl.getLessons();
    }

    public Lesson mapLessonDtoToLesson(LessonDto lessonDto){
        Lesson lesson = new Lesson();
        lesson.setRoomId(lessonDto.getRoomId());
        lesson.setGroupId(lessonDto.getGroupId());
        lesson.setTeacherId(lessonDto.getTeacherId());
        lesson.setSubjectId(lessonDto.getSubjectId());
        lesson.setDate(lessonDto.getDate());
        lesson.setStartTime(lessonDto.getStartTime());
        lesson.setEndTime(lessonDto.getEndTime());

        return lesson;
    }
}
