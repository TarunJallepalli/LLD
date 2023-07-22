package com.tarunj.PropertyHunt.service;

import java.util.List;

import com.tarunj.PropertyHunt.models.Property;

public class PropertyHuntDisplay {

    public static void displayProperties(List<Property> properties) {

        for (Property property : properties) {
            System.out.println("---------------------");
            System.out.println("Property ID: " + property.getPropertyId());
            System.out.println("Location: " + property.getLocation());
            System.out.println("Price: " + property.getPriceRange());
            System.out.println("Listing Type: " + property.getListingType());
            System.out.println("Size: " + property.getPropertySize());
            System.out.println("Rooms: " + property.getRoomType());
            System.out.println("Status: " + property.getListingStatus());
            System.out.println("Owner ID: " + property.getUserId());
            System.out.println("---------------------");
        }
    }

}
