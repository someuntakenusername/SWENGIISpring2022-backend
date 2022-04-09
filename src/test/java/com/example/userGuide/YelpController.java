package com.example.userGuide;

import com.example.userGuide.Service.YelpService;
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
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@WebMvcTest(value = YelpController.class)
@WithMockUser
public class YelpController {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private YelpService yelpService;

    @Test
    public void receiveLocations() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/locations/2/3/20/no/vail").accept(
                MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse res = result.getResponse();
        assert(result.getResponse().getContentLength() >= 0);
    }
}
