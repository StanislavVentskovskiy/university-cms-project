package ua.com.foxminded.dao;

import ua.com.foxminded.model.Subject;

public interface SubjectDao {

    Subject getSubject(int subjectId);

    Subject addSubject(Subject subject);

    Subject updateSubject(Subject subject);

    void deleteSubject(int subjectId);
}
