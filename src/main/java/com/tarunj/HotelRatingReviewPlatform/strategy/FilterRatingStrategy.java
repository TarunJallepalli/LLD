package com.tarunj.HotelRatingReviewPlatform.strategy;

import com.tarunj.HotelRatingReviewPlatform.model.Rating;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class FilterRatingStrategy implements Strategy {

    private final int ratingValue;

    @Override
    public List<Rating> processList(List<Rating> ratings) {
        return ratings.stream().filter(rating -> rating.getRatingValue() == ratingValue)
                .collect(Collectors.toList());
    }
}
