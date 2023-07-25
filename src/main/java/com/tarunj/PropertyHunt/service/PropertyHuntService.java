package com.tarunj.PropertyHunt.service;

import java.util.List;

import com.tarunj.PropertyHunt.dao.PropertyHuntDao;
import com.tarunj.PropertyHunt.enums.ListingStatus;
import com.tarunj.PropertyHunt.enums.ListingType;
import com.tarunj.PropertyHunt.enums.RoomType;
import com.tarunj.PropertyHunt.models.Property;
import com.tarunj.PropertyHunt.strategy.SearchStrategy;

public class PropertyHuntService {

    private PropertyHuntDao propertyDao;
    private UserService userService;

    public PropertyHuntService(UserService userService) {
        this.propertyDao = PropertyHuntDao.getInstance();
        this.userService = userService;
    }

    public void listProperty(Long propertyId, String propertyTitle, String location, double priceRange,
            ListingType listingType, int propertySize, RoomType roomType, Long userId) throws Exception {

        Property newProperty = new Property(propertyId, propertyTitle, location, priceRange, listingType, 
                                             propertySize, roomType, userId);                            
        propertyDao.listProperty(newProperty);
        userService.listProperty(userId, newProperty);
        System.out.println("Property " + propertyId + " is Succesfully Listed by User " + userId);
    }

    public void shortListProperty(Long userId, Long propertyId) throws Exception{

        Property property = propertyDao.findPropertyById(propertyId);
        userService.shortListProperty(userId, property);
    }

    public void searchProperty(List<SearchStrategy> searchStrategies) {

        List<Property> properties = propertyDao.getListedProperties();

        for(SearchStrategy strategy : searchStrategies) {
            properties = strategy.search(properties);
        }

        PropertyHuntDisplay.displayProperties(properties);
    }

    public void markPropertySold(Long propertyId, Long userId, double price) throws Exception {

        Property property = propertyDao.findPropertyById(propertyId);

        if(property.getUserId() != userId) throw new Exception("User is not the property owner");
        if(!property.getListingType().equals(ListingType.SALE)) throw new Exception("Not for Sale");

        property.setListingStatus(ListingStatus.Sold);
        propertyDao.removeListedProperty(propertyId);
        userService.removeListedProperty(userId, property);
    }
}
