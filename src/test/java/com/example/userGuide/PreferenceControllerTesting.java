package com.example.userGuide;

import com.example.userGuide.Constroller.PreferenceController;
import com.example.userGuide.Service.PreferenceService;
import com.example.userGuide.model.Preference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
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
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(value = PreferenceController.class)
@WithMockUser
@AutoConfigureMockMvc
public class PreferenceControllerTesting {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    PreferenceService preferenceService;

    Preference preference = new Preference("1","2","3","great","111","Waco");

    @Test
    public void testGetNullPerference() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/preference/createpreference")
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        RequestBuilder requestBuilder1 = MockMvcRequestBuilders.get("/preference/1")
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult result1 = mockMvc.perform(requestBuilder1).andReturn();

        assert(result.getResponse().getContentAsString().length() == 0);
        assert(result1.getResponse().getContentAsString().length() == 0);
    }

    @Test
    public void testRetrievePreferenceWithMockMVC() throws Exception {
        String json = "{\"id\":\"1\",\"cost\":\"2\",\"rating\":\"3\",\"reviews\":\"great\",\"contact\":\"111\",\"city\":\"Waco\"}";
        this.mockMvc.perform(MockMvcRequestBuilders.post("/preference/createpreference").contentType(MediaType.APPLICATION_JSON)
                        .content(json)).andExpect(status().is2xxSuccessful());
        this.mockMvc.perform(MockMvcRequestBuilders.get("/preference/1").contentType(MediaType.APPLICATION_JSON)
                .content(json)).andExpect(MockMvcResultMatchers.status().isOk());;
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/preference/1").accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse res = result.getResponse();
        assert(result.getResponse().getContentLength() >= 0);

    }
}

