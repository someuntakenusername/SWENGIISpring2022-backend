package com.example.userGuide.model;

import javax.persistence.*;

@Entity
@Table(name = "owner")
public class Owner {
    @Id
    private long id;

    public Owner() {

    }

    public Owner(long id) {
        super();
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
