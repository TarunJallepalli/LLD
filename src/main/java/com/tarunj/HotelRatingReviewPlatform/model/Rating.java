package com.tarunj.HotelRatingReviewPlatform.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

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

    @Override
    public String toString() {
        StringBuilder st = new StringBuilder("[ ");
        st.append("rating=").append(ratingValue);
        if(Objects.nonNull(review)) {
            st.append(", review=").append(review);
        }
        st.append(", user=").append(userId).append(" ]");
        return st.toString();
    }
}
