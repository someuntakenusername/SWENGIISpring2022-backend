package com.example.userGuide.Service;

import com.example.userGuide.model.Bookmark;
import com.example.userGuide.model.User;
import com.example.userGuide.repository.BookmarkRepository;
import com.example.userGuide.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookmarkService {
    @Autowired
    private BookmarkRepository bookmarkRepository;

    public Bookmark removeBookmark(String locationID, String userID){
        List<Bookmark> all = bookmarkRepository.findAll();
        Bookmark toRemove = null;
        for (int i = 0; i < all.size(); i++) {
            if (all.get(i).getLocationID().equals(locationID) && all.get(i).getUserID().equals(userID)){
                toRemove = all.get(i);
                bookmarkRepository.deleteById(all.get(i).getId());
            }
        }
        return toRemove;
    }

    public Bookmark createBookmark(String locationID, String userID){
        return bookmarkRepository.save(new Bookmark(locationID, userID));
    }

    public List<Bookmark> getAll(String userID){
        List<Bookmark> all = bookmarkRepository.findAll();
        List<Bookmark> toReturn = new ArrayList<>();
        for (int i = 0; i < all.size(); i++) {
            if (all.get(i).getUserID().equals(userID)){
                toReturn.add(all.get(i));
            }
        }
        return toReturn;
    }

}
