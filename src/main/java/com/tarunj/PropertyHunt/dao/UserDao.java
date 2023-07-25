package com.tarunj.PropertyHunt.dao;

import java.util.HashMap;
import java.util.Map;

import com.tarunj.PropertyHunt.models.User;

public class UserDao {

    private static UserDao userDaoInstance = null;
    
    private Long nextUserId;
    private Map<Long, User> users;
    private Map<String, User> usersEmail;

    private UserDao() {

        nextUserId = 0L;
        users = new HashMap<>();
        usersEmail = new HashMap<>();
    }

    public static UserDao getUserDaoInstance() {
        if(userDaoInstance == null) userDaoInstance = new UserDao();
        return userDaoInstance;
    }

    public User findByUserEmail(String email) {
        if(!usersEmail.containsKey(email)) return null;
        return usersEmail.get(email);
    }


    public User findByUserId(Long userId){
        if(!users.containsKey(userId)) return null;
        return users.get(userId);
    }

    public User saveUser(User newUser) {

        ++nextUserId;
        newUser.setId(nextUserId);
        users.put(nextUserId, newUser);
        usersEmail.put(newUser.getEmail(), newUser);

        return newUser;
    }
}
