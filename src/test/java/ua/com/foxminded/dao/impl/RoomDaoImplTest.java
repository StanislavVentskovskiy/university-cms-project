package ua.com.foxminded.dao.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import ua.com.foxminded.model.Room;
import java.util.Optional;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@Sql(scripts = {"classpath:test-schema.sql"})
@SpringBootTest
public class RoomDaoImplTest {
    @Mock
    RoomDaoImpl roomDaoImpl;

    private Room actualRoom;
    private Room expectedRoom;
    private int testRoomId = 1;
    private int testRoomNumber = 2;
    private Optional<Room> expectedOptional;
    private Optional<Room> actualOptional;

    @Test
    public void addRoomTest_shouldReturnRoom(){
        Mockito.when(roomDaoImpl.addRoom(expectedRoom)).thenReturn(expectedRoom);
        actualRoom = roomDaoImpl.addRoom(expectedRoom);
        assertEquals(expectedRoom,actualRoom);
    }

    @Test
    public void deleteRoomTest_shouldReturnTrue(){
        roomDaoImpl.deleteRoom(testRoomId);
        verify(roomDaoImpl, Mockito.times(1)).deleteRoom(Mockito.anyInt());
    }

    @Test
    public void getRoomTest_shouldReturnOptionalRoom(){
        Mockito.when(roomDaoImpl.getRoom(testRoomId)).thenReturn(expectedOptional);
        actualOptional = roomDaoImpl.getRoom(testRoomId);
        assertEquals(actualOptional, expectedOptional);
    }

    @Test
    public void updateRoomTest_shouldReturnOptionalRoom(){
        Mockito.when(roomDaoImpl.updateRoom(expectedRoom)).thenReturn(expectedOptional);
        actualOptional = roomDaoImpl.updateRoom(expectedRoom);
        assertEquals(actualOptional,expectedOptional);
    }
}
