package ua.com.foxminded.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.com.foxminded.dao.RoomDao;
import ua.com.foxminded.dao.repository.RoomRepository;
import ua.com.foxminded.model.Room;

@Repository
public class RoomDaoImpl implements RoomDao {

    @Autowired
    RoomRepository roomRepository;

    public Room addRoom(Room room){
        roomRepository.save(room);

        return room;
    }

    public Room updateRoom(Room room){
        Room other = roomRepository.findById(room.getId()).orElse(null);
        if(other != null){
            other.setFloor(room.getFloor());
            other.setNumber(room.getNumber());
            roomRepository.save(other);
        }

        return other;
    }

    public void deleteRoom(int roomId){
        roomRepository.deleteById(roomId);
    }
}
