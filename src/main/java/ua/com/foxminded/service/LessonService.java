package ua.com.foxminded.service;

import ua.com.foxminded.model.Lesson;

import java.util.List;
import java.util.Optional;

public interface LessonService {

    void deleteLesson(int lessonId);

    Lesson addLesson(Lesson lesson);

    Optional<Lesson> updateLesson(Lesson lesson);

    Optional<Lesson> getLesson(int lessonId);

    List<Lesson> getLessons();
}
