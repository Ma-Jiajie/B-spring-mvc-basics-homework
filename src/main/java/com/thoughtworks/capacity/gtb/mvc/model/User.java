package com.thoughtworks.capacity.gtb.mvc.model;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class User {
    @NotNull(message = "用户名不为空")
    @Pattern(regexp = "^[a-zA-Z0-9_]{3,10}$",message = "用户名不合法")
    @NotSameUserName
    private String username;

    @NotBlank(message = "密码不为空")
    @Pattern(regexp = "^[0-9]{5,12}$",message = "密码不合法")
    private String password;

    @Email(message = "邮箱地址不合法")
    private String email;

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
