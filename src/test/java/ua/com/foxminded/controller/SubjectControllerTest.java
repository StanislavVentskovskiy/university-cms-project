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
import ua.com.foxminded.model.Subject;
import ua.com.foxminded.service.impl.SubjectServiceImpl;
import java.util.Optional;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(SubjectController.class)
public class SubjectControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private SubjectServiceImpl subjectService;

    private int testId;
    private Subject testSubject = new Subject();

    @Test
    @WithMockUser(value = "user")
    public void givenSubjectsPage_shouldReturnSubjectsView() throws Exception{
        mvc.perform(get("/subjects"))
            .andDo(print())
            .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "user", roles = "{'ADMIN'}")
    public void givenDeleteSubject_shouldReturnSubjectView() throws Exception {
        mvc.perform(get("/subjects/delete/" + testId).with(csrf()))
            .andExpect(status().is3xxRedirection());
    }

    @Test
    @WithMockUser(username = "user", roles = "{'ADMIN'}")
    public void givenSingleSubjectRequest_shouldReturnSingleSubjectView() throws Exception {
        Mockito.when(subjectService.getSubject(testId)).thenReturn(Optional.of(testSubject));
        mvc.perform(get("/subjects/edit/" + testId).with(csrf()))
            .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "user", roles = "{'ADMIN'}")
    public void givenUpdateSubject_shouldReturnSubjectsView() throws Exception {
        Mockito.when(subjectService.updateSubject(testSubject)).thenReturn(Optional.of(testSubject));
        mvc.perform(post("/subjects/update/" + testId).with(csrf()))
            .andExpect(status().is3xxRedirection());
    }

    @Test
    @WithMockUser(username = "user", roles = "{'ADMIN'}")
    public void givenNewGroupForm_shouldReturn200() throws Exception {
        mvc.perform(get("/subjects/new").contentType(MediaType.APPLICATION_JSON)
            .with(csrf())).andExpect(status().isOk());
    }


    @Test
    @WithMockUser(username = "user", roles = "{'ADMIN'}")
    public void givenSaveNewGroup_shouldRedirectToGroupView() throws Exception {
        mvc.perform(post("/subjects/save").with(csrf()))
            .andExpect(status().is3xxRedirection());
    }
}
