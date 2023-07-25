package com.tarunj.PropertyHunt.service;

import java.util.List;

import com.tarunj.PropertyHunt.dao.UserDao;
import com.tarunj.PropertyHunt.models.Property;
import com.tarunj.PropertyHunt.models.User;

public class UserService {
    
    UserDao userDao;

    public UserService() {
        this.userDao = UserDao.getUserDaoInstance();
    }

    public User registerUser(String userName, String email) throws Exception {

        if(email == null || email.length() == 0) throw new Exception("Invalid Email");
        User user = userDao.findByUserEmail(email);

        if(user != null) throw new Exception("Use different email to register the User");
        user = new User(userName, email);

        return userDao.saveUser(user);
    }

    public User findByUserId(Long userId) {
        return userDao.findByUserId(userId);
    }

    public void viewListedProperties(Long userId) throws Exception {

        User user = findByUserId(userId);
        List<Property> userListedProperties = user.getListedPropertiesByUser();
        PropertyHuntDisplay.displayProperties(userListedProperties);
    }

    public void viewShortListedProperties(Long userId) throws Exception {

        User user = findByUserId(userId);
        List<Property> userShortListedProperties = user.getUserShortListedProperties();
        PropertyHuntDisplay.displayProperties(userShortListedProperties);
    }

    public void listProperty(Long userId, Property property) {

        User user = findByUserId(userId);
        user.getListedPropertiesByUser().add(property);
    }

    public void shortListProperty(Long userId, Property property) {

        User user = findByUserId(userId);
        user.getUserShortListedProperties().add(property);
    }

    public void removeListedProperty(Long userId, Property property) {

        User user = findByUserId(userId);
        user.getListedPropertiesByUser().remove(property);
    }

}
