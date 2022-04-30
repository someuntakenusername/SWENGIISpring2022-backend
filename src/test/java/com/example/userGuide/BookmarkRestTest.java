package com.example.userGuide;

import com.example.userGuide.Constroller.BookmarkController;
import com.example.userGuide.Service.BookmarkService;
import com.example.userGuide.model.Bookmark;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
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

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(value = BookmarkController.class)
@WithMockUser
@AutoConfigureMockMvc
public class BookmarkRestTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    BookmarkController bookmarkController;

    @Autowired
    @MockBean
    BookmarkService bookmarkService;
    String bookmarkJson = "{" +
            "\"id\":\"1\"," +
            "\"locationID\":\"null island\"," +
            "\"userID\":\"1\"" +
            "}";

    @Test
    public void testCreateBookmark() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/bookmark/createbookmark")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(bookmarkJson)
                ).andDo(print())
                .andExpect(status().is2xxSuccessful());

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .get("/bookmark/1")
                ).andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }
    @Test
    public void testRemoveBookmark() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/bookmark/removebookmark")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(bookmarkJson)
                ).andDo(print())
                .andExpect(status().is2xxSuccessful());

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .get("/bookmark/johndoe")
                ).andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }
    @Test
    public void testCreateBookmarkNull() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/bookmark/createbookmark")
                ).andDo(print())
                .andExpect(status().is4xxClientError());
    }
}
