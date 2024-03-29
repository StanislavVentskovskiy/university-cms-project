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
import ua.com.foxminded.model.Group;
import ua.com.foxminded.service.impl.GroupServiceImpl;
import java.util.Optional;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(GroupController.class)
public class GroupControllerTest {
    @Autowired
    private MockMvc mvc;
    @MockBean
    private GroupServiceImpl groupService;

    private int testId;
    private Group testGroup = new Group();

    @Before
    public void initData(){
        testId = 1;
        testGroup.setName("test");
        testGroup.setId(testId);
    }

    @Test
    @WithMockUser(username = "user", roles = "{'ADMIN'}")
    public void givenGroupsPage_shouldReturnStatus200() throws Exception{
          mvc.perform(get("/groups"))
            .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "user", roles = "{'ADMIN'}")
    public void givenDeleteGroup_shouldReturnRedirect() throws Exception {
        mvc.perform(get("/groups/delete/" + testId).with(csrf()))
            .andExpect(status().is3xxRedirection());
    }

    @Test
    @WithMockUser(username = "user", roles = "{'ADMIN'}")
    public void givenSingleGroupRequest_shouldReturnStatus200() throws Exception {
        Mockito.when(groupService.getGroup(testId)).thenReturn(Optional.of(testGroup));
        mvc.perform(get("/groups/edit/" + testId).with(csrf()))
            .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "user", roles = "{'ADMIN'}")
    public void givenUpdateGroup_shouldReturnRedirect() throws Exception {
        Mockito.when(groupService.updateGroup(testGroup)).thenReturn(Optional.of(testGroup));
        mvc.perform(post("/groups/update/" + testId).with(csrf()))
            .andExpect(status().is3xxRedirection());
    }

    @Test
    @WithMockUser(username = "user", roles = "{'ADMIN'}")
    public void givenNewGroupForm_shouldReturnStatus200() throws Exception {
        mvc.perform(get("/groups/new").contentType(MediaType.APPLICATION_JSON)
            .with(csrf()))
            .andExpect(status().isOk());
    }


    @Test
    @WithMockUser(username = "user", roles = "{'ADMIN'}")
    public void givenSaveNewGroup_shouldReturnRedirect() throws Exception {
        mvc.perform(post("/groups/save")
                .with(csrf()))
                .andExpect(status().is3xxRedirection());
    }
}
