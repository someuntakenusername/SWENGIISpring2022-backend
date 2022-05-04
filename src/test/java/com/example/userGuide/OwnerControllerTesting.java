package com.example.userGuide;

import com.example.userGuide.Constroller.OwnerController;
import com.example.userGuide.Service.OwnerService;
import com.example.userGuide.model.Owner;
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

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(value = OwnerController.class)
@WithMockUser
@AutoConfigureMockMvc

public class OwnerControllerTesting {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    OwnerService ownerService;

    @Test
    public void testGetNullOwner() throws Exception {
        RequestBuilder requestBuilder1 = MockMvcRequestBuilders.get("/owner/1")
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult result1 = mockMvc.perform(requestBuilder1).andReturn();
        assert(result1.getResponse().getContentAsString().length() == 0);
    }

    @Test
    public void testRetrieveOwnerWithMockMVC() throws Exception{
        Owner owner = new Owner(1);
        String json = "{\"id\":\"1\"}";
        this.mockMvc.perform(MockMvcRequestBuilders.post("/owner/createowner").contentType(MediaType.APPLICATION_JSON)
                .content(json)).andExpect(status().is2xxSuccessful());
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/owner/1").accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse res = result.getResponse();
        assert(result.getResponse().getContentLength() >= 0);
    }
}
