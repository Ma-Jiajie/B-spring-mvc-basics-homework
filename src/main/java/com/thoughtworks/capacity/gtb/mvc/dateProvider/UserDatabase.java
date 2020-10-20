package com.thoughtworks.capacity.gtb.mvc.dateProvider;

import com.thoughtworks.capacity.gtb.mvc.model.User;
import com.thoughtworks.capacity.gtb.mvc.service.UserNotFoundException;

import java.util.Map.Entry;

import java.util.*;

public final class UserDatabase {
    private static final Map<Integer, User> userMap = new HashMap<>();
    private static boolean isInitialized = false;
    public static int userCount = 1;
    private static void makeUsers() {
        userMap.put(userCount++, new User("Jiajie", "287622", "jiajie@Gmail.com"));
        userMap.put(userCount++, new User("Min", "123456", "Min@Gmail.com"));
        userMap.put(userCount++, new User("Yunpeng", "987654", "Lv@Gmail.com"));
        isInitialized = true;
    }
    public static Map<Integer, User> usersDataProvider() {
        if(!isInitialized) makeUsers();
        return userMap;
    }
    public static void addUser(User user) {
        userMap.put(userCount++, user);
    }
}
