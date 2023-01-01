package ua.com.foxminded.dao;

import ua.com.foxminded.model.Room;

import java.util.List;
import java.util.Optional;

public interface RoomDao {

    Optional<Room> getRoom(int roomId);

    Room addRoom(Room room);

    Optional<Room> updateRoom(Room room);

    void deleteRoom(int roomId);

    List<Room> getRooms();
}
