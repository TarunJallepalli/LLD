package com.tarunj.PropertyHunt.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tarunj.PropertyHunt.models.Property;

public class PropertyHuntDao {

    private static PropertyHuntDao propertyDaoInstance;

    private Map<Long, Property> listedProperties;

    private PropertyHuntDao() {
        listedProperties = new HashMap<>();
    }

    public static PropertyHuntDao getInstance() {
        
        if(propertyDaoInstance == null) {
            propertyDaoInstance = new PropertyHuntDao();
        }

        return propertyDaoInstance;
    }

    public void listProperty(Property property) {
        listedProperties.put(property.getPropertyId(), property);
    }

    public List<Property> getListedProperties() {
        List<Property> properties = new ArrayList<>(listedProperties.values());
        return properties;
    }

    public Property findPropertyById(Long propertyId) {
        return listedProperties.get(propertyId);
    }

    public void removeListedProperty(Long propertyId) {
        listedProperties.remove(propertyId);
    }
    
}
