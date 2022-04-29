package com.example.userGuide.Constroller;

import com.example.userGuide.Service.BookmarkService;
import com.example.userGuide.model.Bookmark;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = {BookmarkConstrollerConfig.class})
@SpringBootTest
class BookmarkControllerTest {
    @Autowired
    BookmarkService bookmarkService;

    @Test
    public void createNewBookmark() {
        assertNotNull(bookmarkService.createBookmark("Waco", "esong"));
        bookmarkService.removeBookmark("Waco", "esong");
    }

    @Test
    public void createDuplicateBookmark() {
        bookmarkService.createBookmark("Waco", "esong");
        assertNotNull(bookmarkService.createBookmark("Waco", "esong"));
        bookmarkService.removeBookmark("Waco", "esong");
    }

    @Test
    public void removeExistingBookmark() {
        bookmarkService.createBookmark("Waco", "esong");
        assertNotNull(bookmarkService.removeBookmark("Waco", "esong"));
    }

    @Test
    public void removeDuplicateBookmarks() {
        bookmarkService.createBookmark("Waco", "esong");
        bookmarkService.createBookmark("Waco", "esong");
        bookmarkService.removeBookmark("Waco", "esong");
        assertNull(bookmarkService.removeBookmark("Waco", "esong"));
    }

    @Test
    public void removeNonExistingBookmark() {
        assertNull(bookmarkService.removeBookmark("Waco", "esong"));
    }

    @Test
    public void getExistingBookmarks() {
        bookmarkService.createBookmark("Waco", "esong");
        assertThat(!bookmarkService.getAll("esong").isEmpty());
        bookmarkService.removeBookmark("Waco", "esong");
    }

    @Test
    public void getNonExistingBookmark() {
        assertThat(bookmarkService.getAll("Waco").isEmpty());
    }

    /*
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
     */
}