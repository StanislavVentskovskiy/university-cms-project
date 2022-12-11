package ua.com.foxminded.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.foxminded.model.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher,Integer> {
}
