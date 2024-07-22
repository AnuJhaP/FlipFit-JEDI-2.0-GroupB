package com.flipkart.bean;

// FlipFitUser class represents a user in the FlipFit system
public class FlipFitUser {
    private String userId;      // Unique identifier for the user
    private String userName;    // User's name
    private String email;       // User's email address
    private String password;    // User's password
    private Role role;          // User's role in the system

    // Default constructor
    public FlipFitUser() {
    }

    // Constructor to initialize FlipFitUser object with id, userName, email, password, and role
    public FlipFitUser(String id, String userName, String email, String password, Role role) {
        this.userId = id;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    // Getter method for retrieving user's name
    public String getUserName() {
        return userName;
    }

    // Setter method for updating user's name
    public void setUserName(String userName) {
        this.userName = userName;
    }

    // Getter method for retrieving user's role
    public Role getRole() {
        return role;
    }

    // Setter method for updating user's role
    public void setRole(Role role) {
        this.role = role;
    }

    // Getter method for retrieving user's password
    public String getPassword() {
        return password;
    }

    // Setter method for updating user's password
    public void setPassword(String password) {
        this.password = password;
    }

    // Getter method for retrieving user's email address
    public String getEmailId() {
        return email;
    }

    // Setter method for updating user's email address
    public void setEmailId(String email) {
        this.email = email;
    }

    // Getter method for retrieving user's ID
    public String getUserId() {
        return userId;
    }

    // Setter method for updating user's ID
    public void setUserId(String userId) {
        this.userId = userId;
    }
}
