package com.tarunj.PropertyHunt;

import java.util.ArrayList;
import java.util.List;

import com.tarunj.PropertyHunt.enums.ListingType;
import com.tarunj.PropertyHunt.enums.RoomType;
import com.tarunj.PropertyHunt.service.PropertyHuntService;
import com.tarunj.PropertyHunt.strategy.SearchByPrice;
import com.tarunj.PropertyHunt.strategy.SearchByRooms;
import com.tarunj.PropertyHunt.strategy.SearchStrategy;

public class Main {
    
    public static void main(String[] args) {
        
        PropertyHuntService propertyHuntService = new PropertyHuntService();

        try {
            
            Long userId1 = propertyHuntService.registerUser("Tarun", "Tarun@gmail.com").getId();
            Long userId2 = propertyHuntService.registerUser("Varun", "Varun@gmail.com").getId();
            Long userId3 = propertyHuntService.registerUser("Arun", "Arun@gmail.com").getId();

            propertyHuntService.listProperty(100L, "T1 Layout", "VZG", 1500.00D, ListingType.SALE, 5, RoomType.TwoBHK, userId1);
            propertyHuntService.listProperty(101L, "T2 Layout", "VZG", 1800.00D, ListingType.SALE, 6, RoomType.TwoBHK, userId1);
            propertyHuntService.listProperty(102L, "V Layout", "HYD", 1200.00D, ListingType.SALE, 4, RoomType.OneBHK, userId2);
            propertyHuntService.listProperty(103L, "A Layout", "CHN", 2500.00D, ListingType.SALE, 7, RoomType.ThreeBHK, userId3);

            // propertyHuntService.viewListedProperties(userId1);

            propertyHuntService.shortListProperty(userId1, 102L);
            propertyHuntService.shortListProperty(userId1, 103L);

            // propertyHuntService.viewShortListedProperties(userId1);

            List<SearchStrategy> strategies = new ArrayList<>();

            strategies.add(new SearchByRooms(RoomType.TwoBHK));
            strategies.add(new SearchByPrice(1000.00D, 2000.00D));

            // propertyHuntService.searchProperty(strategies);

            propertyHuntService.markPropertySold(101L, userId1, 1200.00D);
            propertyHuntService.markPropertySold(102L, userId2, 1200.00D);
        } 
        catch (Exception e) {
            
            System.out.println(e.getMessage());
        }
    }
}
