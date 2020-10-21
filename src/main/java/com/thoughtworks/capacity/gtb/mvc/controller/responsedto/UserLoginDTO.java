package com.thoughtworks.capacity.gtb.mvc.controller.responsedto;

import com.thoughtworks.capacity.gtb.mvc.model.User;

public class UserLoginDTO {
    private int id;
    private User user;

    public UserLoginDTO(int id, User user) {
        this.id = id;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
