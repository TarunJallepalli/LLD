package com.tarunj.HotelRatingReviewPlatform.strategy;

import com.tarunj.HotelRatingReviewPlatform.HotelReviewManagement;
import com.tarunj.HotelRatingReviewPlatform.model.Rating;
import com.tarunj.HotelRatingReviewPlatform.model.User;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class OrderUserLevelStrategy implements Strategy{
    @Override
    public List<Rating> processList(List<Rating> ratings) {

        Comparator<Rating> comparator = new Comparator<Rating>() {
            @Override
            public int compare(Rating r1, Rating r2) {

                User u1 = HotelReviewManagement.getUserById(r1.getUserId());
                User u2 = HotelReviewManagement.getUserById(r2.getUserId());

                return Integer.compare(u2.getLevel(), u1.getLevel());
            }
        };

        comparator = comparator.thenComparing(Rating::getRatingValue).reversed()
                                .thenComparing(Rating::getUpdatedAt);

        return ratings.stream().sorted(comparator).collect(Collectors.toList());
    }
}
