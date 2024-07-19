package com.flipkart.bean;

public class FlipFitUser {
    private String userId;
    private String userName;
    private String email;
    private String password;
    //private String age;
    private Role role;
    //private Address address;
    //private String phoneNumber;

    public FlipFitUser() {
    }

    public FlipFitUser(String id, String userName, String email, String password, Role role) {
        this.userId = id;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public String getUserName() {
        return userName;
    }





    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailId() {
        return email;
    }

    public void setEmailId(String emailId) {
        this.email = emailId;
    }

    public void setUserName(String firstName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
