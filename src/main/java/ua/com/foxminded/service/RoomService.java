package ua.com.foxminded.service;

import ua.com.foxminded.model.Room;

public interface RoomService {

    Room addRoom(Room room);

    Room updateRoom(Room room);

    void deleteRoom(int roomId);
}
