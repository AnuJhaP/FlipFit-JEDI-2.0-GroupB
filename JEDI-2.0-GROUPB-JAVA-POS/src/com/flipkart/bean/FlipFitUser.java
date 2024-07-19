package com.flipkart.bean;

public class FlipFitUser {
    private String userId;
    private String userName;
    private String emailId;
    private String password;
    private String age;
    private Role role;
    private Address address;
    private String phoneNumber;
    public FlipFitUser(String id, String userName, String email, String password, Role role) {
        this.userId = id;
        this.userName = userName;
        this.emailId = email;
        this.password = password;
        this.role = role;
    }
    public String getUserName() {
        return userName;
    }

    public Address getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
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
