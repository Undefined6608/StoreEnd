package com.store.storeend.param.request.user;

// Register param class
public class RegisterBody {
    // username
    private String username;
    // password
    private String password;

    // Empty constructor
    public RegisterBody() {
    }

    // Constructor with username and password
    public RegisterBody(String username, String password) {
        this.username = username;
        this.password = password;
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

    @Override
    public String toString() {
        return "RegisterBody{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
