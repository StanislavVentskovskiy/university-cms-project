package ua.com.foxminded.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.foxminded.model.Room;

public interface RoomRepository extends JpaRepository<Room,Integer> {
}
