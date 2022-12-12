package ua.com.foxminded.service;

import ua.com.foxminded.model.Room;

public interface RoomService {

    Room getRoom(int roomId);

    Room addRoom(Room room);

    Room updateRoom(Room room);

    void deleteRoom(int roomId);
}
