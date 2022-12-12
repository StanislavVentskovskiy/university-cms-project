package ua.com.foxminded.dao;

import ua.com.foxminded.model.Room;

public interface RoomDao {

    Room getRoom(int roomId);

    Room addRoom(Room room);

    Room updateRoom(Room room);

    void deleteRoom(int roomId);
}
