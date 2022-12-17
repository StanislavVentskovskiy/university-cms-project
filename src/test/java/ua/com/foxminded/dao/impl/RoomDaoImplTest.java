package ua.com.foxminded.dao.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import ua.com.foxminded.model.Lesson;
import ua.com.foxminded.model.Room;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@Sql(scripts = {"classpath:test-schema.sql", "classpath:test-data.sql"})
@SpringBootTest
public class RoomDaoImplTest {

    @Autowired
    RoomDaoImpl roomDaoImpl;

    private Room actualRoom;
    private Room expectedRoom;
    private int testRoomId = 1;
    private int testRoomNumber = 2;

    @Before
    public void initTestData(){
        expectedRoom = new Room(1,1);
    }

    @Test
    public void addRoomTest_shouldReturnRoom(){
        actualRoom = roomDaoImpl.addRoom(expectedRoom);

        assertEquals(expectedRoom,actualRoom);
    }

    @Test
    public void deleteRoomTest_shouldReturnNull(){
        roomDaoImpl.deleteRoom(testRoomId);

        assertTrue(roomDaoImpl.getRoom(testRoomId) == null);
    }

    @Test
    public void getRoomTest_shouldReturnLesson(){
        actualRoom = roomDaoImpl.getRoom(testRoomId);

        assertTrue(actualRoom instanceof Room);
    }

    @Test
    public void updateRoomTest_shouldReturnRoom(){
        expectedRoom = roomDaoImpl.getRoom(testRoomId);
        expectedRoom.setNumber(testRoomNumber);
        actualRoom = roomDaoImpl.updateRoom(expectedRoom);

        assertTrue(actualRoom.equals(expectedRoom));
    }
}
