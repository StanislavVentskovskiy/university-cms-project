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
import ua.com.foxminded.model.*;
import ua.com.foxminded.service.impl.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(LessonController.class)
public class LessonsControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private LessonServiceImpl lessonService;

    @MockBean
    private RoomServiceImpl roomService;

    @MockBean
    private RoleServiceImpl roleService;

    @MockBean
    private GroupServiceImpl groupService;

    @MockBean
    private SubjectServiceImpl subjectService;

    @MockBean
    private TeacherServiceImpl teacherService;

    private int testId;
    private Lesson testLesson = new Lesson();
    private Room testRoom = new Room();
    private Teacher testTeacher = new Teacher();
    private Group testGroup = new Group();
    private Subject testSubject = new Subject();

    @Before
    public void setData(){
        testId = 1;
        testRoom.setNumber(1);
        testTeacher.setName("test");
        testGroup.setName("test");
        testSubject.setName("test");
        testLesson.setGroup(testGroup);
        testLesson.setTeacher(testTeacher);
        testLesson.setRoom(testRoom);
        testLesson.setSubject(testSubject);
    }

    @Test
    @WithMockUser(value = "user")
    public void givenLessonsPage_shouldReturnLessonsView() throws Exception {
        mvc.perform(get("/lessons"))
            .andDo(print())
            .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(value = "user", roles = {"ADMIN"})
    public void givenCreateNewLessonForm_shouldReturn200() throws Exception {
        mvc.perform(get("/lessons/new").contentType(MediaType.APPLICATION_JSON)
                .with(csrf())
                .with(user("user")))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(value = "user", roles = {"ADMIN"})
    public void givenSaveNewLesson_shouldRedirectToLessonView() throws Exception {
        mvc.perform(post("/lessons/save").with(csrf()))
            .andExpect(status().is3xxRedirection());
    }

    @Test
    @WithMockUser(value = "user", roles = {"ADMIN"})
    public void givenSingleLessonRequest_shouldReturnSingleLessonView() throws Exception {
        Mockito.when(lessonService.getLesson(1)).thenReturn(testLesson);
        mvc.perform(get("/lessons/edit/" + testId).with(csrf()))
            .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(value = "user", roles = {"ADMIN"})
    public void givenDeleteLesson_shouldReturnLessonView() throws Exception {
        mvc.perform(get("/lessons/delete/" + testId).with(csrf()))
            .andExpect(status().is3xxRedirection());
    }

    @Test
    @WithMockUser(value = "user", roles = {"ADMIN"})
    public void givenUpdateLesson_shouldReturnLessonView() throws Exception {
        Mockito.when(lessonService.updateLesson(testLesson)).thenReturn(testLesson);
        mvc.perform(post("/lessons/update/" + testId).with(csrf()))
            .andExpect(status().is3xxRedirection());
    }
}
