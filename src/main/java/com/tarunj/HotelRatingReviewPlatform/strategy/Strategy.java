package com.tarunj.HotelRatingReviewPlatform.strategy;

import com.tarunj.HotelRatingReviewPlatform.model.Rating;

import java.util.List;

public interface Strategy {
    public List<Rating> processList(List<Rating> ratings);
}
