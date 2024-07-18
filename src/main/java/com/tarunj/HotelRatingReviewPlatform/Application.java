package com.tarunj.HotelRatingReviewPlatform;

import com.tarunj.HotelRatingReviewPlatform.model.Hotel;
import com.tarunj.HotelRatingReviewPlatform.model.HotelType;
import com.tarunj.HotelRatingReviewPlatform.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        HotelReviewManagement management = new HotelReviewManagement();
        initializeSystem(management);

        System.out.println("Starting Hotel Review System");
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("Enter command: ");
            String command = scanner.nextLine().trim();

            if("Exit".equalsIgnoreCase(command)) break;

            try {
                processCommand(command, management);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        scanner.close();
        System.out.println("Exiting Hotel Review System");
    }

    private static void initializeSystem(HotelReviewManagement management) {

        List<Hotel> hotels = new ArrayList<>();
        hotels.add(new Hotel(0, "Hotel_000", HotelType.PLUS_HOTEL));
        hotels.add(new Hotel(1, "Hotel_001", HotelType.NORMAL_HOTEL));
        hotels.add(new Hotel(2, "Hotel_002", HotelType.PLUS_HOTEL));
        hotels.add(new Hotel(3, "Hotel_003", HotelType.NORMAL_HOTEL));

        List<User> users = new ArrayList<>();
        users.add(new User(0, "User_000", "User_000@gmail.com"));
        users.add(new User(1, "User_001", "User_001@gmail.com"));
        users.add(new User(2, "User_002", "User_002@gmail.com"));
        users.add(new User(3, "User_003", "User_003@gmail.com"));
        users.add(new User(4, "User_004", "User_004@gmail.com"));
        users.add(new User(5, "User_005", "User_005@gmail.com"));

        management.addHotels(hotels);
        management.addUsers(users);
    }

    private static void processCommand(String command, HotelReviewManagement management) throws Exception {

        String[] parts = command.split("\\s+");
        if(parts.length == 0) {
            System.out.println("Please Enter any Command");
        }
        String commandType = parts[0];

        switch (commandType.toUpperCase()) {

            case "ADD_RATING": {

                if(parts.length < 4) throw new Exception("Invalid Command");

                String review = null;
                if(parts.length >= 5) review = parts[4];

                System.out.println(management.addRating(Integer.parseInt(parts[1]), review,
                        Integer.parseInt(parts[2]), Integer.parseInt(parts[3])));
                break;
            }

            case "GET_RATINGS": {

                if(parts.length < 2) throw new Exception("Invalid Command");

                String orderType = "", filterType = null;

                if(parts.length > 2) orderType = parts[2];
                if(parts.length > 3) filterType = parts[3];

                management.getHotelRatings(Integer.parseInt(parts[1]), orderType, filterType)
                          .forEach(System.out::println);
                break;
            }

            case "DESCRIBE_HOTEL": {

                if(parts.length < 2) throw new Exception("Invalid Command");
                System.out.println(management.describeHotel(Integer.parseInt(parts[1])));
                break;
            }

            case "LIST_HOTELS": {

                management.listHotels().forEach(System.out::println);
                break;
            }

            default: throw new Exception("Invalid Command");
        }
    }

}
