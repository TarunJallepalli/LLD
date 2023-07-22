package com.tarunj.PropertyHunt.strategy;

import java.util.ArrayList;
import java.util.List;

import com.tarunj.PropertyHunt.models.Property;

public class SearchByPrice implements SearchStrategy{
    
    private double startPrice, endPrice;

    public SearchByPrice(double startPrice, double endPrice) {
        this.startPrice = startPrice;
        this.endPrice = endPrice;
    }

    @Override
    public List<Property> search(List<Property> properties) {

        List<Property> filteredProperties = new ArrayList<>();
        
        for(Property property : properties) {
            if(property.getPriceRange() >= startPrice && property.getPriceRange() <= endPrice) {
                filteredProperties.add(property);
            }
        }

        return filteredProperties;
    }
}
