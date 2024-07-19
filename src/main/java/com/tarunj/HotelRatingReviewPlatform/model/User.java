package com.tarunj.HotelRatingReviewPlatform.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User extends BaseModel {

    private String name;
    private String email;
    private int level;
    private int ratingsGiven;

    public User(int id, String name, String email) {
        super(id);
        this.name = name;
        this.email = email;
        level = 1;
        ratingsGiven = 0;
    }

    public void setLevel() {
        if (ratingsGiven >= 16) {
            level = 4;
        } else if (ratingsGiven >= 8) {
            level = 3;
        } else if (ratingsGiven >= 4) {
            level = 2;
        } else {
            level = 1;
        }
    }

    public void addRating() {
        ratingsGiven++;
        setLevel();
    }
}
