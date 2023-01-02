package ua.com.foxminded.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.com.foxminded.dao.SubjectDao;
import ua.com.foxminded.dao.repository.SubjectRepository;
import ua.com.foxminded.model.Subject;
import java.util.List;
import java.util.Optional;

@Repository
public class SubjectDaoImpl implements SubjectDao {

    @Autowired
    SubjectRepository subjectRepository;

    public Optional<Subject> getSubject(int subjectId){
        return subjectRepository.findById(subjectId);
    }

    public Subject addSubject(Subject subject){
        subjectRepository.save(subject);

        return subject;
    }

    public Optional<Subject> updateSubject(Subject subject){
        Optional<Subject> other = subjectRepository.findById(subject.getId());
        if (other.isPresent()){
            other.get().setName(subject.getName());
            subjectRepository.save(other.get());
        }

        return other;
    }

    public void deleteSubject(int subjectId){
        subjectRepository.deleteById(subjectId);
    }

    public List<Subject> getSubjects(){
        return subjectRepository.findAll();
    }
}
