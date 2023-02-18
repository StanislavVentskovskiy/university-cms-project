package ua.com.foxminded.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import ua.com.foxminded.model.Room;
import ua.com.foxminded.service.impl.RoomServiceImpl;
import java.util.Optional;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(RoomController.class)
public class RoomsControllerTest {
    @Autowired
    private MockMvc mvc;
    @MockBean
    private RoomServiceImpl roomService;

    private int testId;
    private Room testRoom = new Room();

    @Before
    public void setData(){
        testId = 1;
    }

    @Test
    @WithMockUser(value = "user")
    public void givenRoomsPage_shouldReturnStatus200() throws Exception{
        mvc.perform(get("/rooms"))
            .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "user", roles = "{'ADMIN'}")
    public void givenDeleteRoom_shouldReturnRedirect() throws Exception {
        mvc.perform(get("/rooms/delete/" + testId).with(csrf()))
            .andExpect(status().is3xxRedirection());
    }

    @Test
    @WithMockUser(username = "user", roles = "{'ADMIN'}")
    public void givenSingleRoomRequest_shouldReturnStatus200() throws Exception {
        Mockito.when(roomService.getRoom(testId)).thenReturn(Optional.of(testRoom));
        mvc.perform(get("/rooms/edit/" + testId).with(csrf()))
            .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "user", roles = "{'ADMIN'}")
    public void givenUpdateRoom_shouldReturnRedirect() throws Exception {
        Mockito.when(roomService.updateRoom(testRoom)).thenReturn(Optional.of(testRoom));
        mvc.perform(post("/rooms/update/" + testId).with(csrf()))
            .andExpect(status().is3xxRedirection());
    }

    @Test
    @WithMockUser(username = "user", roles = "{'ADMIN'}")
    public void givenNewRoomForm_shouldReturnStatus200() throws Exception {
        mvc.perform(get("/rooms/new").contentType(MediaType.APPLICATION_JSON)
            .with(csrf()))
            .andExpect(status().isOk());
    }


    @Test
    @WithMockUser(username = "user", roles = "{'ADMIN'}")
    public void givenSaveNewRoom_shouldReturnRedirect() throws Exception {
        mvc.perform(post("/rooms/save")
                .with(csrf()))
                .andExpect(status().is3xxRedirection());
    }
}
