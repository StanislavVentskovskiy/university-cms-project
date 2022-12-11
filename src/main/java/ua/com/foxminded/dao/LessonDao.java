package ua.com.foxminded.dao;

import ua.com.foxminded.model.Lesson;

public interface LessonDao {

    Lesson addLesson(Lesson lesson);

    Lesson updateLesson(Lesson lesson);

    void deleteLesson(int lessonId);

    Lesson getLesson(int lessonId);
}
