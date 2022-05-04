package com.example.userGuide;
import com.example.userGuide.Constroller.BookmarkController;
import com.example.userGuide.Constroller.ReviewController;
import com.example.userGuide.Service.BookmarkService;
import com.example.userGuide.Service.ReviewService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.containsString;
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ReviewControllerMockmvcTests {
    @Autowired
    private MockMvc mockMvc;

    ReviewController reviewController;
    ReviewService reviewService;

    String reviewJson = "{" +
            "\"id\":\"1\"," +
            "\"locationID\":\"null island\"," +
            "\"reviewtext\":\"1\"" +
            "}";

    @Test
    public void testCreateRetrieveWithMockMVC() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/review/createreview")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(reviewJson)
                ).andDo(print())
                .andExpect(status().is2xxSuccessful());

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .get("/review/getreviews/1")
                ).andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/review/1").accept(MediaType.APPLICATION_JSON);
        MvcResult result1 = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse res = result1.getResponse();
        assert(result1.getResponse().getContentLength() >= 0);
    }

    @Test
    public void testReviewNull() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/review/createreview")
                ).andDo(print())
                .andExpect(status().is4xxClientError());
    }
}
