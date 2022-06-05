package com.smof.data;


import java.io.Serializable;
public class UserDTO implements Serializable {
    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

    public UserDTO(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "password='" + password + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }

    private String userName;
    private String password;
}
