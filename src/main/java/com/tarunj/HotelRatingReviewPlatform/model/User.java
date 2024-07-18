package com.tarunj.HotelRatingReviewPlatform.model;

import com.tarunj.HotelRatingReviewPlatform.model.BaseModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User extends BaseModel {

    private String name;
    private String email;

    public User(int id, String name, String email) {
        super(id);
        this.name = name;
        this.email = email;
    }
}
