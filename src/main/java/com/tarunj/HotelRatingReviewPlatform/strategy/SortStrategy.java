package com.tarunj.HotelRatingReviewPlatform.strategy;

import com.tarunj.HotelRatingReviewPlatform.model.Rating;
import lombok.RequiredArgsConstructor;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class SortStrategy implements Strategy {

    private final String order;

    @Override
    public List<Rating> processList(List<Rating> ratings) {

        Comparator<Rating> comparator = Comparator.comparingInt(Rating::getRatingValue);

        if("DESC".equalsIgnoreCase(order)) comparator.reversed();

        return ratings.stream()
                .sorted(comparator.thenComparing(Rating::getUpdatedAt))
                .collect(Collectors.toList());
    }
}
