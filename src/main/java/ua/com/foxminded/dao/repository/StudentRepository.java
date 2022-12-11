package ua.com.foxminded.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.foxminded.model.Student;

public interface StudentRepository extends JpaRepository<Student,Integer> {
}
