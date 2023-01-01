package ua.com.foxminded.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.com.foxminded.dao.RoomDao;
import ua.com.foxminded.dao.repository.RoomRepository;
import ua.com.foxminded.model.Room;

import java.util.List;
import java.util.Optional;

@Repository
public class RoomDaoImpl implements RoomDao {

    @Autowired
    RoomRepository roomRepository;

    public Optional<Room> getRoom(int roomId){
        return roomRepository.findById(roomId);
    }

    public Room addRoom(Room room){
        roomRepository.save(room);

        return room;
    }

    public Optional<Room> updateRoom(Room room){
        Optional<Room> other = roomRepository.findById(room.getId());
        if(other.isPresent()){
            other.get().setFloor(room.getFloor());
            other.get().setNumber(room.getNumber());
            roomRepository.save(other.get());
        }

        return other;
    }

    public void deleteRoom(int roomId){
        roomRepository.deleteById(roomId);
    }

    public List<Room> getRooms(){
        return roomRepository.findAll();
    }
}
