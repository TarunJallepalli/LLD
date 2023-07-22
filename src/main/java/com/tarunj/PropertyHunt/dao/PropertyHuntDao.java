package com.tarunj.PropertyHunt.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tarunj.PropertyHunt.models.Property;
import com.tarunj.PropertyHunt.models.User;

public class PropertyHuntDao {

    private static PropertyHuntDao propertyDaoInstance;

    private Long nextUserId;
    private Map<Long, User> users;
    private Map<String, User> usersEmail;

    private Map<Long, List<Property>> userListedProperties;
    private Map<Long, List<Property>> userShortListedProperties;

    private Map<Long, Property> listedProperties;

    private PropertyHuntDao() {
        
        nextUserId = 0L;
        users = new HashMap<>();
        usersEmail = new HashMap<>();

        userListedProperties = new HashMap<>();
        userShortListedProperties = new HashMap<>();

        listedProperties = new HashMap<>();
    }

    public static PropertyHuntDao getInstance() {
        
        if(propertyDaoInstance == null) {
            propertyDaoInstance = new PropertyHuntDao();
        }

        return propertyDaoInstance;
    }

    public User findByUserEmail(String email) {
        if(!usersEmail.containsKey(email)) return null;
        return usersEmail.get(email);
    }


    public User findByUserId(Long userId){

        if(users.containsKey(userId)) {
            return users.get(userId);
        }
        return null;
    }

    public User saveUser(User newUser) {

        ++nextUserId;
        newUser.setId(nextUserId);
        users.put(nextUserId, newUser);
        usersEmail.put(newUser.getEmail(), newUser);

        userListedProperties.put(nextUserId, new ArrayList<Property>());
        userShortListedProperties.put(nextUserId, new ArrayList<Property>());

        return newUser;
    }

    public void listProperty(Property property) {

        if(property == null) return ;

        userListedProperties.get(property.getUserId()).add(property);
        listedProperties.put(property.getPropertyId(), property);
    }

    public List<Property> getListedProperties() {

        List<Property> properties = new ArrayList<>(listedProperties.values());
        return properties;
    }

    public List<Property> getListedPropertiesByUser(Long userId) {
        return userListedProperties.get(userId);
    }

    public Property findPropertyById(Long propertyId) {
        return listedProperties.get(propertyId);
    }

    public void shortListProperty(Long userId, Long propertyId) {
        userShortListedProperties.get(userId).add(findPropertyById(propertyId));
    }

    public List<Property> getShortListedProperties(Long userId) {
        return userShortListedProperties.get(userId);
    }

    public void removeListedProperty(Long userId, Long propertyId) {

        userListedProperties.get(userId).remove(listedProperties.get(propertyId));
        listedProperties.remove(propertyId);
    }
    
}
