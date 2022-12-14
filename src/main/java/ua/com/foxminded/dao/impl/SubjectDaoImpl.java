package ua.com.foxminded.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.com.foxminded.dao.SubjectDao;
import ua.com.foxminded.dao.repository.SubjectRepository;
import ua.com.foxminded.model.Subject;

@Repository
public class SubjectDaoImpl implements SubjectDao {

    @Autowired
    SubjectRepository subjectRepository;

    public Subject getSubject(int subjectId){
        return subjectRepository.findById(subjectId).orElse(null);
    }

    public Subject addSubject(Subject subject){
        subjectRepository.save(subject);

        return subject;
    }

    public Subject updateSubject(Subject subject){
        Subject other = subjectRepository.findById(subject.getId()).orElse(null);
        if (other != null){
            other.setName(subject.getName());
            subjectRepository.save(other);
        }

        return subject;
    }

    public void deleteSubject(int subjectId){
        subjectRepository.deleteById(subjectId);
    }
}
