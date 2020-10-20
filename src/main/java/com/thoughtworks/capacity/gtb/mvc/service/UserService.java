package com.thoughtworks.capacity.gtb.mvc.service;

import com.thoughtworks.capacity.gtb.mvc.dateProvider.UserDatabase;
import com.thoughtworks.capacity.gtb.mvc.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    private Map<Integer, User> userMap;

    public UserService() {
        userMap = UserDatabase.usersDataProvider();
    }

    public void register(User user) {
        UserDatabase.addUser(user); //just for test self-defined validator annotation
        userMap = UserDatabase.usersDataProvider(); //reAssign
    }

    public List<User> getUsers() {
        return new ArrayList<>(userMap.values());
    }

    public User login(String username, String password) throws UserNotFoundException {
        if(!username.matches("^[a-zA-Z0-9_]{3,10}$")) throw new UserNotFoundException("用户名不合法");
        if(!password.matches("^[0-9]{5,12}$")) throw new UserNotFoundException("密码不合法");
        for(User user :userMap.values()) {
            if(user.getUsername().equals(username) && user.getPassword().equals(password)) return user;
        }
        throw new UserNotFoundException("用户名或密码错误");
    }

    public int findIdbyUser(User user) throws UserNotFoundException {
        for(int key: userMap.keySet()){
            if(userMap.get(key).equals(user)){
                return key;
            }
        }
        throw new UserNotFoundException("用户id不正确");
    }
}
