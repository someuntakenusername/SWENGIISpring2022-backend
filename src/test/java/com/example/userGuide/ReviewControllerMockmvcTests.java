package com.example.userGuide;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
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

    @Test
    public void testCreateRetrieveWithMockMVC() throws Exception {

        this.mockMvc.perform(post("review/createreview")).andExpect(status().is2xxSuccessful());
        this.mockMvc.perform(get("review/getreviews/1")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Sam")));
    }
}

