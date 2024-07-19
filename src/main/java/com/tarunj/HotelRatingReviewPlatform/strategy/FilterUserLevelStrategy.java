package com.tarunj.HotelRatingReviewPlatform.strategy;

import com.tarunj.HotelRatingReviewPlatform.HotelReviewManagement;
import com.tarunj.HotelRatingReviewPlatform.model.Rating;
import com.tarunj.HotelRatingReviewPlatform.model.User;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class FilterUserLevelStrategy implements Strategy{

    private final int userLevel;

    @Override
    public List<Rating> processList(List<Rating> ratings) {

        return ratings.stream().filter(rating -> {
            User user = HotelReviewManagement.getUserById(rating.getUserId());
            return (userLevel == user.getLevel());
        }).collect(Collectors.toList());
    }
}
