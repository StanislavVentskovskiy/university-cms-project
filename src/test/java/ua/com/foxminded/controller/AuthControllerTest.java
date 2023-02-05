package ua.com.foxminded.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import ua.com.foxminded.service.impl.RoleServiceImpl;
import ua.com.foxminded.service.impl.UserServiceImpl;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AdminController.class)
public class AuthControllerTest {

    @Autowired
    private MockMvc mvc;
    @MockBean
    private UserServiceImpl userService;
    @MockBean
    private RoleServiceImpl roleService;

    @WithMockUser(value = "admin", roles = {"ADMIN"})
    @Test
    public void givenAuthRequestOnPrivateServiceAdminRole_shouldReturn200() throws Exception {
        mvc.perform(get("/login").contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());
    }

    @WithMockUser(value = "user", roles = {"USER"})
    @Test
    public void givenAuthRequestOnPrivateServiceUserRole_shouldReturn200() throws Exception {
        mvc.perform(get("/login").contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());
    }

    @WithMockUser(value = "teacher", roles = {"TEACHER"})
    @Test
    public void givenAuthRequestOnPrivateServiceTeacherRole_shouldReturn200() throws Exception {
        mvc.perform(get("/login").contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());
    }
}
