package com.example.userGuide.Constroller;


import com.example.userGuide.Forumns.CreateBookmarkForumn;
import com.example.userGuide.Forumns.CreatePreferenceForumn;
import com.example.userGuide.Service.BookmarkService;
import com.example.userGuide.Service.PreferenceService;
import com.example.userGuide.model.Bookmark;
import com.example.userGuide.model.Preference;
import com.example.userGuide.model.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("bookmark/")
public class BookmarkController {
    @Autowired
    private BookmarkService bookmarkService;

    @RequestMapping(value = "/createbookmark", method = RequestMethod.POST)
    public Bookmark createPreference(@RequestBody CreateBookmarkForumn createBookmarkForumn) {
        return bookmarkService.createBookmark(createBookmarkForumn.getLocationID(), createBookmarkForumn.getUserID());
    }

    @RequestMapping(value = "/removebookmark", method = RequestMethod.POST)
    public Bookmark removeBookmark(@RequestBody CreateBookmarkForumn createBookmarkForumn) {
        return bookmarkService.removeBookmark(createBookmarkForumn.getLocationID(), createBookmarkForumn.getUserID());
    }

    @GetMapping("/{id}")
    public List<Bookmark> getBookmarks(@PathVariable("id") Object ids) {
        return bookmarkService.getAll((String)ids);
    }


}
