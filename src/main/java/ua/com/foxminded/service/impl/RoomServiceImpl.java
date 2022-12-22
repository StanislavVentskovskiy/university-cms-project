package ua.com.foxminded.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.foxminded.dao.impl.RoomDaoImpl;
import ua.com.foxminded.model.Room;
import ua.com.foxminded.service.RoomService;
import java.util.Optional;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    RoomDaoImpl roomDaoImpl;

    public Optional<Room> getRoom(int roomId){
        return roomDaoImpl.getRoom(roomId);
    }

    public Room addRoom(Room room){
        return roomDaoImpl.addRoom(room);
    }

    public Optional<Room> updateRoom(Room room){
        return roomDaoImpl.updateRoom(room);
    }

    public void deleteRoom(int roomId){
        roomDaoImpl.deleteRoom(roomId);
    }
}
