package ua.com.foxminded.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.foxminded.model.Subject;

public interface SubjectRepository extends JpaRepository<Subject,Integer> {
}
