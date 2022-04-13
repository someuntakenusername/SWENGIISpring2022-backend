package com.example.userGuide;

import com.example.userGuide.Service.UserService;
import com.example.userGuide.Service.YelpService;
import com.example.userGuide.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@WebMvcTest(value = UserController.class)
@WithMockUser
public class UserController {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private UserService userService;


    User mockUsers = new User("sam", "Beyer", "sam_beyer1@baylor.edu", "password");
    @Test
    public void retrieveDetailsForUser() throws Exception {
        Mockito.when(userService.userByLastname(Mockito.anyString())).thenReturn(mockUsers);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/user/Beyer").accept(
                MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        System.out.println(result.getResponse().getContentLength());
        assert(result.getResponse().getContentAsString().length() > 0);
        //This isn't working, I am going to request help
    }

}
