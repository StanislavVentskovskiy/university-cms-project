package ua.com.foxminded.service;

import ua.com.foxminded.model.Room;
import java.util.Optional;

public interface RoomService {

    Optional<Room> getRoom(int roomId);

    Room addRoom(Room room);

    Optional<Room> updateRoom(Room room);

    void deleteRoom(int roomId);
}
