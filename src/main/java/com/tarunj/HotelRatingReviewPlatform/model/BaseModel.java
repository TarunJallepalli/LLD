package com.tarunj.HotelRatingReviewPlatform.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class BaseModel {

    private int id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public BaseModel() {}

    public BaseModel(int id) {
        this.id = id;
        LocalDateTime currTime = LocalDateTime.now();
        createdAt = currTime;
        updatedAt = currTime;
    }
}
