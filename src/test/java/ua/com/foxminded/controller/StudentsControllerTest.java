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
import ua.com.foxminded.model.Student;
import ua.com.foxminded.service.impl.GroupServiceImpl;
import ua.com.foxminded.service.impl.StudentServiceImpl;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(StudentController.class)
public class StudentsControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private StudentServiceImpl studentService;

    @MockBean
    private GroupServiceImpl groupService;

    private int testId;
    private Student testStudent = new Student();


    @Before
    public void setData(){
        testId = 1;
        testStudent.setId(1);
        testStudent.setGroupId(1);
    }

    @Test
    @WithMockUser(value = "user")
    public void givenStudentsPage_shouldReturnStudentsView() throws Exception{
        mvc.perform(get("/students"))
            .andDo(print())
            .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(value = "user", roles = {"ADMIN"})
    public void givenAddNewStudent_shouldReturn200() throws Exception {
        mvc.perform(get("/students/new").contentType(MediaType.APPLICATION_JSON)
            .with(csrf())
            .with(user("user")))
            .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(value = "user", roles = {"ADMIN"})
    public void givenSingleStudentRequest_shouldReturnStudentsView() throws Exception {
        Mockito.when(studentService.getStudent(1)).thenReturn(testStudent);
        mvc.perform(get("/students/edit/" + testId).with(csrf()))
            .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(value = "user", roles = {"ADMIN"})
    public void givenDeleteStudent_shouldReturnStudentView() throws Exception {
        mvc.perform(get("/students/delete/" + testId).with(csrf()))
            .andExpect(status().is3xxRedirection());
    }

    @Test
    @WithMockUser(value = "user", roles = {"ADMIN"})
    public void givenUpdateStudent_shouldReturnStudentView() throws Exception {
        Mockito.when(studentService.updateStudent(testStudent)).thenReturn(testStudent);
        mvc.perform(post("/students/update/" + testId).with(csrf()))
            .andExpect(status().is3xxRedirection());
    }
}
