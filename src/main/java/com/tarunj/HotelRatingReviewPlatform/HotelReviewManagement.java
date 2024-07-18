package com.tarunj.HotelRatingReviewPlatform;

import com.tarunj.HotelRatingReviewPlatform.model.Hotel;
import com.tarunj.HotelRatingReviewPlatform.model.HotelType;
import com.tarunj.HotelRatingReviewPlatform.model.Rating;
import com.tarunj.HotelRatingReviewPlatform.model.User;
import com.tarunj.HotelRatingReviewPlatform.strategy.FilterRangeStrategy;
import com.tarunj.HotelRatingReviewPlatform.strategy.RecentSortStrategy;
import com.tarunj.HotelRatingReviewPlatform.strategy.SortStrategy;
import com.tarunj.HotelRatingReviewPlatform.strategy.Strategy;

import java.util.*;
import java.util.stream.Collectors;

public class HotelReviewManagement {

    private final Map<Integer, User> users;
    private final Map<Integer, Hotel> hotels;

    private final Map<Integer, Rating> ratings;

    public HotelReviewManagement() {
        this.users = new HashMap<>();
        this.hotels = new HashMap<>();
        this.ratings = new HashMap<>();
    }

    public void addUsers(List<User> userList) {
        userList.forEach(user -> users.put(user.getId(), user));
    }

    public void addHotels(List<Hotel> hotelList) {
        hotelList.forEach(hotel -> hotels.put(hotel.getId(), hotel));
    }

    public String addRating(int ratingValue, String review, int userId, int hotelId) throws Exception {

        if(!users.containsKey(userId) || !hotels.containsKey(hotelId)) {
            throw new Exception("Invalid User/Hotel Details");
        }

        if(ratingValue < 1 || ratingValue > 5) {
            throw new Exception("Rating should be between 1 and 5");
        }

        Hotel hotel = hotels.get(hotelId);
        Rating rating = hotel.addRating(ratingValue, userId, review);
        ratings.put(rating.getId(), rating);

        return "Rating and Review added Successfully";
    }

    public String describeHotel(int hotelId) {

        if(!hotels.containsKey(hotelId)) {
            return "Invalid Hotel Id";
        }

        Hotel hotel = hotels.get(hotelId);
        return hotel.toString();
    }

    public List<Rating> getHotelRatings(int hotelId, String orderType, String filterType) throws Exception {

        Hotel hotel = hotels.get(hotelId);
        List<Strategy> strategies = new ArrayList<>();

        if(Objects.isNull(hotel)) {
            throw new Exception("Hotel not Found");
        }

        if(Objects.nonNull(filterType)) {
            strategies.add(new FilterRangeStrategy(filterType));
        }

        strategies.add(
                switch(orderType.toUpperCase()) {
                    case "ASC", "DESC" -> new SortStrategy(orderType.toUpperCase());
                    case "LATEST" -> new RecentSortStrategy();
                    default -> new SortStrategy("DESC");
                }
        );

        return hotel.getHotelRatings(strategies);
    }

    public List<String> listHotels() {

        List<Hotel> hotelList = new ArrayList<>(hotels.values());
        return hotelList.stream().sorted((h1, h2) -> {
                if(h1.getHotelType().equals(HotelType.PLUS_HOTEL)
                        && h2.getHotelType().equals(HotelType.PLUS_HOTEL)) {
                    return Double.compare(h1.getAvgRating(), h2.getAvgRating());
                }
                return h1.getHotelType().equals(HotelType.PLUS_HOTEL) ? -1 : 1;
            })
            .map(hotel -> "Hotel[id=".concat(String.valueOf(hotel.getId())).concat("]"))
            .collect(Collectors.toList());
    }
}
