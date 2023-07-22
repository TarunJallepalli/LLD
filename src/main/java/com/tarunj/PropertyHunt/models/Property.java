 package com.tarunj.PropertyHunt.models;

import com.tarunj.PropertyHunt.enums.ListingStatus;
import com.tarunj.PropertyHunt.enums.ListingType;
import com.tarunj.PropertyHunt.enums.RoomType;

public class Property {

    private Long propertyId;
    private String propertyTitle;
    private String location;
    private double priceRange;
    private ListingType listingType;
    private int propertySize;
    private RoomType roomType;
    private ListingStatus listingStatus;
    private Long userId;

    public Property(Long propertyId, String propertyTitle, String location, double priceRange,
            ListingType listingType, int propertySize, RoomType roomType, Long userId) {
        
        this.propertyId = propertyId;
        this.propertyTitle = propertyTitle;
        this.location = location;
        this.priceRange = priceRange;
        this.listingType = listingType;
        this.propertySize = propertySize;
        this.roomType = roomType;
        this.listingStatus = ListingStatus.Listed;
        this.userId = userId;
    }

    public Long getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Long propertyId) {
        this.propertyId = propertyId;
    }

    public String getPropertyTitle() {
        return propertyTitle;
    }

    public void setPropertyTitle(String propertyTitle) {
        this.propertyTitle = propertyTitle;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getPriceRange() {
        return priceRange;
    }

    public void setPriceRange(double priceRange) {
        this.priceRange = priceRange;
    }

    public ListingType getListingType() {
        return listingType;
    }

    public void setListingType(ListingType listingType) {
        this.listingType = listingType;
    }

    public int getPropertySize() {
        return propertySize;
    }

    public void setPropertySize(int propertySize) {
        this.propertySize = propertySize;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public ListingStatus getListingStatus() {
        return listingStatus;
    }

    public void setListingStatus(ListingStatus listingStatus) {
        this.listingStatus = listingStatus;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

}
