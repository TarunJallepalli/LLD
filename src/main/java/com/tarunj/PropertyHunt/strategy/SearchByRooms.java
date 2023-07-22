package com.tarunj.PropertyHunt.strategy;

import java.util.ArrayList;
import java.util.List;

import com.tarunj.PropertyHunt.enums.RoomType;
import com.tarunj.PropertyHunt.models.Property;

public class SearchByRooms implements SearchStrategy{

    RoomType roomType;

    public SearchByRooms(RoomType roomType) {
        this.roomType = roomType;
    }

    @Override
    public List<Property> search(List<Property> properties) {
        
        List<Property> filteredProperties = new ArrayList<>();
        
        for(Property property : properties) {
            if(property.getRoomType().equals(roomType)) {
                filteredProperties.add(property);
            }
        }

        return filteredProperties;
    }
    
}
