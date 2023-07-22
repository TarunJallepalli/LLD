package com.tarunj.PropertyHunt.service;

import java.util.List;

import com.tarunj.PropertyHunt.dao.PropertyHuntDao;
import com.tarunj.PropertyHunt.enums.ListingStatus;
import com.tarunj.PropertyHunt.enums.ListingType;
import com.tarunj.PropertyHunt.enums.RoomType;
import com.tarunj.PropertyHunt.models.Property;
import com.tarunj.PropertyHunt.models.User;
import com.tarunj.PropertyHunt.strategy.SearchStrategy;

public class PropertyHuntService {

    private PropertyHuntDao propertyDao;

    public PropertyHuntService() {
        this.propertyDao = PropertyHuntDao.getInstance();
    }

    public User registerUser(String userName, String email) throws Exception {

        if(email == null || email.length() == 0) throw new Exception("Invalid Email");
        User user = propertyDao.findByUserEmail(email);

        if(user != null) throw new Exception("Use different email to register the User");
        user = new User(userName, email);

        return propertyDao.saveUser(user);
    }

    public void listProperty(Long propertyId, String propertyTitle, String location, double priceRange,
            ListingType listingType, int propertySize, RoomType roomType, Long userId) throws Exception {

        if(propertyDao.findByUserId(userId) == null) throw new Exception("User not Registered");
        if(propertyDao.findPropertyById(propertyId) != null) throw new Exception("Property Already Listed");

        Property newProperty = new Property(propertyId, propertyTitle, location, priceRange, listingType, 
                                             propertySize, roomType, userId);
                                            
        propertyDao.listProperty(newProperty);

        System.out.println("Property " + propertyId + " is Succesfully Listed by User " + userId);
    }

    public void viewListedProperties(Long userId) throws Exception {

        if(propertyDao.findByUserId(userId) == null) throw new Exception("User not Registered");

        List<Property> userListedProperties = propertyDao.getListedPropertiesByUser(userId);
        PropertyHuntDisplay.displayProperties(userListedProperties);
    }

    public void shortListProperty(Long userId, Long propertyId) throws Exception{
        
        if(propertyDao.findByUserId(userId) == null) throw new Exception("User not Registered");
        if(propertyDao.findPropertyById(propertyId) == null) throw new Exception("Property Not Listed");

        propertyDao.shortListProperty(userId, propertyId);
    }

    public void viewShortListedProperties(Long userId) throws Exception {

        if(propertyDao.findByUserId(userId) == null) throw new Exception("User not Registered");

        List<Property> userShortListedProperties = propertyDao.getShortListedProperties(userId);
        PropertyHuntDisplay.displayProperties(userShortListedProperties);
    } 

    public void searchProperty(List<SearchStrategy> searchStrategies) {

        List<Property> properties = propertyDao.getListedProperties();

        for(SearchStrategy strategy : searchStrategies) {
            properties = strategy.search(properties);
        }

        PropertyHuntDisplay.displayProperties(properties);
    }

    public void markPropertySold(Long propertyId, Long userId, double price) throws Exception {

        if(propertyDao.findByUserId(userId) == null) throw new Exception("User not Registered");

        Property property = propertyDao.findPropertyById(propertyId);

        if(property == null) throw new Exception("Property Not Listed");
        if(property.getUserId() != userId) throw new Exception("User is not the property owner");
        if(!property.getListingType().equals(ListingType.SALE)) throw new Exception("Not for Sale");

        property.setListingStatus(ListingStatus.Sold);

        propertyDao.removeListedProperty(userId, propertyId);
    }
}
