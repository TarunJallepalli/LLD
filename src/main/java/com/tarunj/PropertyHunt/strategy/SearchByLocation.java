package com.tarunj.PropertyHunt.strategy;

import java.util.ArrayList;
import java.util.List;

import com.tarunj.PropertyHunt.models.Property;

public class SearchByLocation implements SearchStrategy {

    private String location;

    public SearchByLocation(String location) {
        this.location = location;
    }

    @Override
    public List<Property> search(List<Property> properties) {

        List<Property> filteredProperties = new ArrayList<>();
        
        for(Property property : properties) {
            if(property.getLocation().equalsIgnoreCase(location)) {
                filteredProperties.add(property);
            }
        }

        return filteredProperties;
    }
    
}
