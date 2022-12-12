package ua.com.foxminded.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import ua.com.foxminded.dao.impl.SubjectDaoImpl;
import ua.com.foxminded.model.Subject;
import ua.com.foxminded.service.SubjectService;

public class SubjectServiceImpl implements SubjectService {

    @Autowired
    SubjectDaoImpl subjectDaoImpl;

    public Subject addSubject(Subject subject){
        return subjectDaoImpl.addSubject(subject);
    }

    public Subject updateSubject(Subject subject){
        return subjectDaoImpl.updateSubject(subject);
    }

    public void deleteSubject(int subjectId){
        subjectDaoImpl.deleteSubject(subjectId);
    }
}
