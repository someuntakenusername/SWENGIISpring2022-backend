package com.example.userGuide.Constroller;

import com.example.userGuide.Forumns.CreatePreferenceForumn;
import com.example.userGuide.Forumns.CreateUserForumn;
import com.example.userGuide.Service.PreferenceService;
import com.example.userGuide.Service.UserService;
import com.example.userGuide.model.Preference;
import com.example.userGuide.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("preference/")
public class PreferenceController {

    @Autowired
    private PreferenceService preferenceService;

    @RequestMapping(value = "/createpreference", method = RequestMethod.POST)
    public Preference createPreference(CreatePreferenceForumn createPreferenceForumn) {
        return preferenceService.createPreference(new Preference(Long.toString(createPreferenceForumn.getId()), createPreferenceForumn.getCost(), createPreferenceForumn.getRating(), createPreferenceForumn.getReviews(), createPreferenceForumn.getContact(), createPreferenceForumn.getCity()));
    }

    @GetMapping("/{id}")
    public Preference searchByLastName(@PathVariable("id") Object id) {
        System.out.println(id);
        return preferenceService.getPreference((String)id);
    }
}
