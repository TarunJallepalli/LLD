package com.tarunj.HotelRatingReviewPlatform.model;

import com.tarunj.HotelRatingReviewPlatform.HotelReviewManagement;
import com.tarunj.HotelRatingReviewPlatform.model.BaseModel;
import com.tarunj.HotelRatingReviewPlatform.model.HotelType;
import com.tarunj.HotelRatingReviewPlatform.model.Rating;
import com.tarunj.HotelRatingReviewPlatform.strategy.Strategy;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Getter
@Setter
public class Hotel extends BaseModel {

    private String name;
    private double avgRating;
    private HotelType hotelType;
    private Map<Integer, Rating> ratings;

    public Hotel(int id, String name, HotelType hotelType) {

        super(id);
        this.name = name;
        avgRating = 0;
        this.hotelType = hotelType;
        ratings = new HashMap<>();
    }

    public Rating addRating(int ratingValue, int userId, String review) {

        Rating rating = ratings.get(userId);

        if(Objects.nonNull(rating)) {

            rating = ratings.get(userId);
            int updatedRating = ratingValue - rating.getRatingValue();
            avgRating = ((avgRating * ratings.size()) + updatedRating) / ratings.size();
            rating.setRatingValue(ratingValue);
            rating.setReview(review);
            rating.setUpdatedAt(LocalDateTime.now());
        }

        else {

            rating = new Rating(Rating.generateId(), ratingValue, review, userId, this.getId());
            avgRating = ((avgRating * ratings.size()) + ratingValue) / (ratings.size() + 1);
            ratings.put(userId, rating);
        }

        return rating;
    }

    @Override
    public String toString() {
        StringBuilder st = new StringBuilder("[ ");
        st.append("id=").append(this.getId()).append(", name=")
          .append(name).append(", avgRating=").append(avgRating);
        if(hotelType.equals(HotelType.PLUS_HOTEL)) {
            st.append(", Type=").append(hotelType);
        }
        st.append(" ]");
        return st.toString();
    }

    public List<Rating> getHotelRatings(List<Strategy> strategies) {

        List<Rating> hotelRatings = new ArrayList<>(ratings.values());
        for (Strategy strategy : strategies) {
            hotelRatings = strategy.processList(hotelRatings);
        }
        return hotelRatings;
    }

}
