package com.example.userGuide.Constroller;

import com.example.userGuide.Service.OwnerService;
import com.example.userGuide.model.Owner;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class OwnerControllerTest {
    @Autowired
    private OwnerService ownerService;

    @BeforeAll
    void setupTests() {
        ownerService.createOwner(new Owner(12345));
    }

    @Test
    void createdOwner() {
        assertEquals(ownerService.getSpecificOwner(12345), new Owner(12345));
    }

    @Test
    void createDuplicateUser() {
        assertNull(ownerService.createOwner(new Owner(12345)));
    }

    @Test
    void ownerRemoved() {
        ownerService.createOwner(new Owner(56789));
        ownerService.removeOwner(56789);
        assertNull(ownerService.getSpecificOwner(56789));
    }

    @Test
    void removeNonExistentOwner() {
        assertNull(ownerService.removeOwner(56789));
    }

    @Test
    void ownerFoundById() {
        assertNotNull(ownerService.getSpecificOwner(12345));
    }

    @Test
    void ownerNotFoundById() {
        assertNull(ownerService.getSpecificOwner(56789));
    }

    @AfterAll
    void finishTests() {
        ownerService.removeOwner(12345);
    }
}
