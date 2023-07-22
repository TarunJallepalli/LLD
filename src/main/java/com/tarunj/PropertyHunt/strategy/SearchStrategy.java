package com.tarunj.PropertyHunt.strategy;

import java.util.List;

import com.tarunj.PropertyHunt.models.Property;

public interface SearchStrategy {
    
    public List<Property> search(List<Property> properties);
}
