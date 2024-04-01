package ru.test.task.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import ru.test.task.dto.Request;
import ru.test.task.dto.Response;
import ru.test.task.service.StatusServiceImpl;

import java.nio.charset.StandardCharsets;

import static org.mockito.Mockito.when;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(MockitoExtension.class)
class StatusRestControllerImplTest {

    private MockMvc mvc;

    @Mock
    private StatusServiceImpl statusService;
    @InjectMocks
    private StatusRestControllerImpl controller;

    @BeforeEach
    public void setup() {
        mvc = MockMvcBuilders.standaloneSetup(controller)
                .defaultResponseCharacterEncoding(StandardCharsets.UTF_8)
                .build();
    }

    @Test
    void addData() throws Exception {
        Request request = Request.builder().userId(1000).useData("new user").build();
        Response response = Response.builder().answer(OK.toString()).build();
        when(statusService.saveData(request)).thenReturn(response);

        mvc.perform(MockMvcRequestBuilders.post("/api/add_data")
                        .content(asJsonString(request))
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(MockMvcResultMatchers.jsonPath("answer").value("200 OK"))
                        .andExpect(status().isOk()).andReturn();

    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}