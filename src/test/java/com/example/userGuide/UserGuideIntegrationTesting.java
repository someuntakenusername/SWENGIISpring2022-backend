package com.example.userGuide;

import com.example.userGuide.model.User;
import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserGuideApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserGuideIntegrationTesting {

    @LocalServerPort
    private int port;

    TestRestTemplate restTemplate = new TestRestTemplate();

    HttpHeaders headers = new HttpHeaders();

    @Test
    public void testRetrieveStudentCourse() throws JSONException {

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/user/1"),
                HttpMethod.GET, entity, String.class);

        String expected = "{id:1,firstName:Ramesh,lastName:Fadatare,email:ramesh@gmail.com}";

        JSONAssert.assertEquals(expected, response.getBody(), false);
    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }

//    @Test
//    public void addCourse() {
//
//        User user = new User("Himel", "Rahman", "rahman@gmail.com");
//
//        HttpEntity<User> entity = new HttpEntity<User>(user, headers);
//
//        ResponseEntity<String> response = restTemplate.exchange(
//                createURLWithPort("/user/post"),
//                HttpMethod.POST, entity, String.class);
//
//        String actual = response.getHeaders().get(HttpHeaders.LOCATION).get(0);
//
//        assertTrue(actual.contains("/user/post/"));
//
//    }

}
