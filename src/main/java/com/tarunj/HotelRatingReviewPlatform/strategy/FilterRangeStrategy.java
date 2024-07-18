package com.tarunj.HotelRatingReviewPlatform.strategy;

import com.tarunj.HotelRatingReviewPlatform.model.Rating;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class FilterRangeStrategy implements Strategy{

    private final String filterRange;

    @Override
    public List<Rating> processList(List<Rating> ratings) {

        List<Integer> filters = switch(filterRange.toUpperCase()) {
            case "LOW" -> List.of(1,2);
            case "MEDIUM" -> List.of(3, 4);
            case "HIGH" -> List.of(5);
            default -> null;
        };

        if(Objects.isNull(filters)) return ratings;

        return ratings.stream().filter(rating -> filters.contains(rating.getRatingValue()))
                .collect(Collectors.toList());
    }
}
