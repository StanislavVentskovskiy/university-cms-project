package ua.com.foxminded.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.foxminded.dao.impl.SubjectDaoImpl;
import ua.com.foxminded.model.Subject;
import ua.com.foxminded.service.SubjectService;

import java.util.Optional;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    SubjectDaoImpl subjectDaoImpl;

    public Optional<Subject> getSubject(int subjectId){
        return subjectDaoImpl.getSubject(subjectId);
    }

    public Subject addSubject(Subject subject){
        return subjectDaoImpl.addSubject(subject);
    }

    public Optional<Subject> updateSubject(Subject subject){
        return subjectDaoImpl.updateSubject(subject);
    }

    public void deleteSubject(int subjectId){
        subjectDaoImpl.deleteSubject(subjectId);
    }
}
