package ua.com.foxminded.service;

import ua.com.foxminded.model.Lesson;

public interface LessonService {

    void deleteLesson(int lessonId);

    Lesson addLesson(Lesson lesson);

    Lesson updateLesson(Lesson lesson);

    Lesson getLesson(int lessonId);
}
