package com.example.userGuide.Service;

import com.example.userGuide.model.Preference;
import com.example.userGuide.model.User;
import com.example.userGuide.repository.PreferenceRepository;
import com.example.userGuide.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class PreferenceService {
    @Autowired
    private PreferenceRepository preferenceRepository;

    public Preference createPreference(Preference preference){
        try{
            preferenceRepository.deleteAllById(Collections.singleton(preference.id));
        }catch (Exception e){

        }
        return preferenceRepository.save(preference);
    }

    public Preference getPreference(String id){
        Optional<Preference> x = preferenceRepository.findById(Long.parseLong(id));
        return x.orElse(null);
    }
}
