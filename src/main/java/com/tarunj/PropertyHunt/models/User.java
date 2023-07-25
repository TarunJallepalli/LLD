package com.tarunj.PropertyHunt.models;

import java.util.ArrayList;
import java.util.List;

public class User {

    private Long id;
    private String userName;
    private final String email;

    private List<Property> userListedProperties;
    private List<Property> userShortListedProperties;

    public User(String userName, String email) {
        this.userName = userName;
        this.email = email;
        userListedProperties = new ArrayList<>();
        userShortListedProperties = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long userId) {
        this.id = userId;
    } 

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public List<Property> getListedPropertiesByUser() {
        return userListedProperties;
    }

    public List<Property> getUserShortListedProperties() {
        return userShortListedProperties;
    }

}
