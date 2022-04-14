package com.example.userGuide;

import com.example.userGuide.Forumns.CreateUserForumn;
import com.example.userGuide.Service.UserService;
import com.example.userGuide.model.User;
import com.example.userGuide.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.containsString;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertTrue;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
/*
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestRestTemplates {
    @LocalServerPort
    private int port;

    TestRestTemplate restTemplate = new TestRestTemplate();

    HttpHeaders headers = new HttpHeaders();

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }


    @Test
    public void testCreateUser() throws JSONException {
        HttpEntity<User> entity = new HttpEntity<>(new User("Sam", "Beyer", "test@gmail.com", "test"), headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/user/createuser"), HttpMethod.POST, entity, String.class);

        assertTrue(response.getBody().length() != 0);
    }


    @Test
    public void testRetrieveUser() throws Exception {
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/user/Beyer"), HttpMethod.GET, entity,
                String.class);

        String expected = "{\"id\":3,\"firstName\":\"Sam\",\"lastName\":\"Beyer\",\"password\":\"$2a$10$aPF3nD6XTcCN6xgv234M4eK69.YrQIZYPNoJ5V0u7NzF7PA7TOIdq\",\"email\":\"sam_beyer1@baylor.edu\"}";

        JSONAssert.assertEquals(expected, response.getBody(), false);
    }

    @Test
    public void testRetrieveLocations() throws Exception {
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/locations/1/1/1/no/Vail"), HttpMethod.GET, entity,
                String.class);

        assertTrue(response.getBody().toString().length() > 0);
    }
}

 */


/*
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestRestTemplates {
    @LocalServerPort
    private int port;

    TestRestTemplate restTemplate = new TestRestTemplate();

    HttpHeaders headers = new HttpHeaders();

    @Autowired
    private UserService studentService;

    @MockBean
    private UserRepository studentRepository;

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }

    @Test
    public void testRetrieveUserWithMockRepository() throws Exception {
        List<User> optStudent = List.of( new
                User("Sam","Beyer","Test@gmail.com", "password"));
        when(studentRepository.findAll()).thenReturn(optStudent);
        assertTrue(studentService.userByLastname("Beyer").getLastName().contains("Beyer"));
    }
}


 */




@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TestRestTemplates {
    @Autowired
    private MockMvc mockMvc;
    @Test
    public void testCreateRetrieveWithMockMVC() throws Exception {
        User user = new User("Sam", "Beyer", "sam_beyer1@baylor.edu", "password");
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(user);
        requestJson = requestJson.replaceAll(" ", "");
        requestJson = requestJson.replaceAll("\n", "");
        this.mockMvc.perform(post("/user/createuser").content(requestJson).accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().is2xxSuccessful());
        this.mockMvc.perform(get("/user/Beyer")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("sam_beyer1@baylor.edu")));
    }
}


