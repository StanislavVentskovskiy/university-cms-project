package ua.com.foxminded.dao;

import ua.com.foxminded.model.Lesson;

import java.util.List;
import java.util.Optional;

public interface LessonDao {

    Lesson addLesson(Lesson lesson);

    Optional<Lesson> updateLesson(Lesson lesson);

    void deleteLesson(int lessonId);

    Optional<Lesson> getLesson(int lessonId);

    List<Lesson> getLessons();
}
