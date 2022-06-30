package com.c1221g1.pharmacy.dto.user.payload;

/**
 * Created by HuuNQ
 * Time 12:00 30/06/2022
 * Function: use for login request when user submit sing in
 */
public class LoginRequest {
    private String username;
    private String password;

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
}
