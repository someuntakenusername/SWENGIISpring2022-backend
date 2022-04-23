package com.example.userGuide.Constroller;

import com.example.userGuide.Service.BookmarkService;
import com.example.userGuide.model.Bookmark;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = {BookmarkConstrollerConfig.class})
@SpringBootTest
class BookmarkControllerTest {
    @Autowired
    BookmarkService bookmarkService;

    @Test
    void createPreference() {
        Bookmark bm = new Bookmark();
        bm.setUserID("johndoe");
        bm.setLocationID("hell, michigan");
        Bookmark result = bookmarkService.createBookmark("hell, michigan", "johndoe");
        assertThat(bm.equals(result));
    }

    @Test
    void removeBookmark() {
        Bookmark bm = new Bookmark();
        bm.setUserID("johndoe");
        bm.setLocationID("hell, michigan");
        Bookmark result = bookmarkService.removeBookmark("hell, michigan", "johndoe");
        assertThat(bm.equals(result));
    }

    @Test
    void getBookmarks() {
        assertThat(bookmarkService.getAll("johndoe")).isNotNull();
    }
}