package com.example.taitran.buzzmovie.model;

import java.util.HashMap;
import java.util.Map;
/**
 * Created by taitr on 2/6/2016.
 */
public class UserManager implements UserAuthentication, UserManagement{
    private static Map<String, User> userList = new HashMap<>();
    private static Map<String, User> logUser = new HashMap<>();

    public User userId(String userId) {
        return userList.get(userId);
    }

    public void addUser(String name, String password) {
        if(userList.containsKey(name)) {
            throw new IllegalArgumentException("Username already exists");
        }
        User user = new User(name, password);
        userList.put(name, user);
    }

    public void logUser(String username, String password) {
        User user = new User(username, password);
        logUser.put(username, user);
    }

    public boolean logoutCheck(String username, String password) {
        if (logUser.get(username).username == username) {
            return true;
        } else {
            return false;
        }
    }

    public Map<String, User> getMap() {
        return logUser;
    }

    public void nullMap() {
        logUser = null;
    }

    public boolean loginRequest(String username, String password) {
        User user = userId(username);
        if (user == null) {
            return false;
        }
        return user.passwordHandler(password);
    }

}

