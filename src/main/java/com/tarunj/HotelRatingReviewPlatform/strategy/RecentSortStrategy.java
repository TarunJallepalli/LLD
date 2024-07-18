package com.tarunj.HotelRatingReviewPlatform.strategy;

import com.tarunj.HotelRatingReviewPlatform.model.Rating;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RecentSortStrategy implements Strategy {
    @Override
    public List<Rating> processList(List<Rating> ratings) {
        return ratings.stream()
                .sorted(Comparator.comparing(Rating::getUpdatedAt))
                .collect(Collectors.toList());
    }
}
