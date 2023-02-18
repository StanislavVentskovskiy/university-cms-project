package ua.com.foxminded.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import ua.com.foxminded.dao.impl.RoomDaoImpl;
import ua.com.foxminded.model.Room;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoomServiceImplTest {
    @Autowired
    RoomServiceImpl roomService;
    @MockBean
    RoomDaoImpl roomDao;

    public Room testRoom;
    private int testRoomId = 1;

    @Test
    public void addRoomTest_shouldCallDaoMethod(){
        roomService.addRoom(testRoom);
        verify(roomDao, Mockito.times(1)).addRoom(Mockito.any());
    }

    @Test
    public void updateRoomTest_shouldCallDaoMethod(){
        roomService.updateRoom(testRoom);
        verify(roomDao, Mockito.times(1)).updateRoom(Mockito.any());
    }

    @Test
    public void deleteRoomTest_shouldCallDaoMethod(){
        roomService.deleteRoom(testRoomId);
        verify(roomDao, Mockito.times(1)).deleteRoom(Mockito.anyInt());
    }

    @Test
    public void getRoomTest_shouldCallDaoMethod(){
        roomService.deleteRoom(testRoomId);
        verify(roomDao, Mockito.times(1)).deleteRoom(Mockito.anyInt());
    }
}
