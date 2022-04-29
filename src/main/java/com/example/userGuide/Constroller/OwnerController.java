package com.example.userGuide.Constroller;

import com.example.userGuide.Forumns.CreateOwnerForumn;
import com.example.userGuide.Service.OwnerService;
import com.example.userGuide.model.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("owner/")
public class OwnerController {
    @Autowired
    private OwnerService ownerService;

    @GetMapping("owners")
    public List<Owner> getOwners() {
        return ownerService.getOwners();
    }

    @GetMapping("/{id}")
    public Owner getSpecificOwner(@PathVariable("id") Object id) {
        return ownerService.getSpecificOwner((Long.parseLong((String)id)));
    }

    @RequestMapping(value = "/createowner", method = RequestMethod.POST)
    public Owner updateAdmission(@RequestBody CreateOwnerForumn createOwnerForumn) {
        System.out.println(createOwnerForumn);
        return ownerService.createOwner(new Owner(createOwnerForumn.getId()));
    }
}
