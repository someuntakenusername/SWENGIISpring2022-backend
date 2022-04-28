package com.example.userGuide.Service;

import com.example.userGuide.model.Owner;
import com.example.userGuide.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OwnerService {
    @Autowired
    private OwnerRepository ownerRepository;

    public List<Owner> getOwners() {
        return this.ownerRepository.findAll();
    }

    public Owner createOwner(Owner owner) {
        System.out.println(owner);
        return ownerRepository.save(owner);
    }

    public Owner getSpecificOwner(long id) {
        List<Owner> owners = this.ownerRepository.findAll();
        System.out.println(owners);
        for (Owner owner : owners) {
            if (owner.getId() == id) {
                return owner;
            }
        }

        return null;
    }
}
