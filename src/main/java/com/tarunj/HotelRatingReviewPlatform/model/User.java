package com.tarunj.HotelRatingReviewPlatform.model;

import com.tarunj.HotelRatingReviewPlatform.model.BaseModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User extends BaseModel {

    private String name;
    private String email;
}
