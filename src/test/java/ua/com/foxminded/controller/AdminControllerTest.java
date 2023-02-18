package ua.com.foxminded.controller;

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
import ua.com.foxminded.dao.impl.UserDaoImpl;
import ua.com.foxminded.dao.repository.UserRepository;
import ua.com.foxminded.model.UserEntity;
import ua.com.foxminded.service.impl.RoleServiceImpl;
import ua.com.foxminded.service.impl.UserServiceImpl;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = AdminController.class)
public class AdminControllerTest {
    @Autowired
    private MockMvc mvc;
    @Autowired
    private AdminController adminController;
    @MockBean
    private UserServiceImpl userService;
    @MockBean
    private UserDaoImpl userDao;
    @MockBean
    private UserRepository userRepository;
    @MockBean
    private RoleServiceImpl roleService;

    private int testId = 1;

    @Test
    @WithMockUser(value = "user")
    public void givenGroupsPage_shouldReturnStatus200() throws Exception{
        mvc.perform(get("/admin-panel").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(value = "user")
    public void givenPostRequest_shouldReturnRedirect() throws Exception {
        mvc.perform(post("/admin-panel/save")
                .with(csrf()))
                .andExpect(status().is3xxRedirection());
    }

    @Test
    @WithMockUser(value = "user")
    public void givenGetSingleEntityRequest_shouldReturnStatus200() throws Exception{
        Mockito.when(userService.getUser(1)).thenReturn(new UserEntity());
        mvc.perform(get("/admin-panel/edit/" + testId)
                .with(csrf()))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(value = "user")
    public void givenRoleFormGetRequest_shouldReturnStatus200() throws Exception {
        mvc.perform(get("/admin-panel/new-role").contentType(MediaType.APPLICATION_JSON)
            .with(csrf()))
            .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(value = "user")
    public void givenRolePostRequest_shouldReturnRedirect() throws Exception {
        mvc.perform(post("/admin-panel/save-role")
                .with(csrf()))
                .andExpect(status().is3xxRedirection());
    }
}
