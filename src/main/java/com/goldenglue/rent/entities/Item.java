package com.goldenglue.rent.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Item {
    @Id
    @GeneratedValue
    private long id;

    private String name;
    private String description;
    @ManyToOne
    private WebUser owner;


    Item() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public WebUser getOwner() {
        return owner;
    }

    public void setOwner(WebUser owner) {
        this.owner = owner;
    }
}
