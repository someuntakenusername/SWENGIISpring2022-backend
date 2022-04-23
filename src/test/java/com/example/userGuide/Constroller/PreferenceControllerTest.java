package com.example.userGuide.Constroller;


import com.example.userGuide.Service.PreferenceService;
import com.example.userGuide.model.Preference;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PreferenceControllerTest {
    @Autowired
    private PreferenceService preferenceService;

    Preference preference = new Preference("1","2","3","great","111","Waco");

    @Test
    void updateAdmission(){
        assertThat(preferenceService.createPreference(new Preference("1","2","3","great","111","Waco")).equals(preference));
    }

    @Test
    void searchPreference(){
       assertThat(preferenceService.getPreference("1").equals(preference));
    }
}
