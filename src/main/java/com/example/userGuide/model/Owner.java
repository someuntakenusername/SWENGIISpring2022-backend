package com.example.userGuide.model;

import javax.persistence.*;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Owner owner = (Owner) o;
        return id == owner.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
