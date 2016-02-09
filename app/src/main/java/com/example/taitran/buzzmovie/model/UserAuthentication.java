package com.example.taitran.buzzmovie.model;
import java.util.Map;

/**
 * Created by taitr on 2/6/2016.
 */
public interface UserAuthentication {
    boolean loginRequest(String name, String password);
    boolean logoutCheck(String name, String password);
    void nullMap();
    Map getMap();
}
