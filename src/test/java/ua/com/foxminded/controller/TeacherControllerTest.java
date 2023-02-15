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
import ua.com.foxminded.model.Subject;
import ua.com.foxminded.model.Teacher;
import ua.com.foxminded.service.impl.SubjectServiceImpl;
import ua.com.foxminded.service.impl.TeacherServiceImpl;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringRunner.class)
@WebMvcTest(TeacherController.class)
public class TeacherControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private TeacherServiceImpl teacherService;

    @MockBean
    private SubjectServiceImpl subjectService;

    private int testId;
    private Teacher testTeacher = new Teacher();
    private Subject testSubject = new Subject();

    @Before
    public void setData(){
        testId = 1;
        testTeacher.setPosition("test");
        testTeacher.setSubjectId(1);
        testTeacher.setEmail("test");
    }

    @Test
    @WithMockUser(value = "user")
    public void givenTeachersPage_shouldReturnTeachersView() throws Exception{
        mvc.perform(get("/teachers"))
            .andDo(print())
            .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(value = "user", roles = {"ADMIN"})
    public void givenCreateNewTeacherForm_shouldReturn200() throws Exception {
        mvc.perform(get("/teachers/new").contentType(MediaType.APPLICATION_JSON)
            .with(csrf())
            .with(user("user")))
            .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(value = "user", roles = {"ADMIN"})
    public void givenSaveNewTeacher_shouldRedirectToTeacherView() throws Exception {
        mvc.perform(post("/teachers/save").with(csrf()))
            .andExpect(status().is3xxRedirection());
    }

    @Test
    @WithMockUser(value = "user", roles = {"ADMIN"})
    public void givenTeacherEditRequest_shouldReturnSingleTeacherView() throws Exception {
        Mockito.when(teacherService.getTeacher(testId)).thenReturn(testTeacher);
        mvc.perform(get("/teachers/edit/" + testId).with(csrf()))
            .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(value = "user", roles = {"ADMIN"})
    public void givenDeleteTeacher_shouldReturnTeachersView() throws Exception {
        mvc.perform(get("/teachers/delete/" + testId).with(csrf()))
            .andExpect(status().is3xxRedirection());
    }

    @Test
    @WithMockUser(value = "user", roles = {"ADMIN"})
    public void givenUpdateTeacherRequest_shouldReturnTeachersView() throws Exception {
        Mockito.when(teacherService.updateTeacher(testTeacher)).thenReturn(testTeacher);
        mvc.perform(post("/teachers/update/" + testId).with(csrf()))
            .andExpect(status().is3xxRedirection());
    }
}
