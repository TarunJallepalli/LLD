package com.tarunj.HotelRatingReviewPlatform.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Rating extends BaseModel {

    private static int nextId;
    private int ratingValue;
    private String review;
    private int userId;
    private int hotelId;

    public Rating(int id, int ratingValue, String review, int userId, int hotelId) {
        super(id);
        this.ratingValue = ratingValue;
        this.review = review;
        this.userId = userId;
        this.hotelId = hotelId;
    }

    public static int generateId() {
        return nextId++;
    }
}
