package ua.com.foxminded.dao;

import ua.com.foxminded.model.Subject;

import java.util.List;
import java.util.Optional;

public interface SubjectDao {

    Optional<Subject> getSubject(int subjectId);

    Subject addSubject(Subject subject);

    Optional<Subject> updateSubject(Subject subject);

    void deleteSubject(int subjectId);

    List<Subject> getSubjects();
}
