package ua.com.foxminded.service;

import ua.com.foxminded.model.Subject;

public interface SubjectService {

    Subject getSubject(int subjectId);

    Subject addSubject(Subject subject);

    Subject updateSubject(Subject subject);

    void deleteSubject(int subjectId);
}
