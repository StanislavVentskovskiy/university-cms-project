package ua.com.foxminded.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import ua.com.foxminded.dao.impl.RoomDaoImpl;
import ua.com.foxminded.model.Room;
import ua.com.foxminded.service.RoomService;

public class RoomServiceImpl implements RoomService {

    @Autowired
    RoomDaoImpl roomDaoImpl;

    public Room addRoom(Room room){
        return roomDaoImpl.addRoom(room);
    }

    public Room updateRoom(Room room){
        return roomDaoImpl.updateRoom(room);
    }

    public void deleteRoom(int roomId){
        roomDaoImpl.deleteRoom(roomId);
    }
}
