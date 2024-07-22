package com.flipkart.bean;

/**
 * FlipFitUser class represents a user in the FlipFit system.
 * It encapsulates information about a user including ID, name, email address, password, and role.
 */
public class FlipFitUser {
    private String userId;      // Unique identifier for the user
    private String userName;    // User's name
    private String email;       // User's email address
    private String password;    // User's password
    private Role role;          // User's role in the system

    /**
     * Default constructor for creating a FlipFitUser object.
     * Initializes the object with default values.
     */
    public FlipFitUser() {
    }

    /**
     * Constructor to initialize a FlipFitUser object with specified attributes.
     *
     * @param id       The unique identifier for the user.
     * @param userName The name of the user.
     * @param email    The email address of the user.
     * @param password The password of the user.
     * @param role     The role of the user in the system.
     */
    public FlipFitUser(String id, String userName, String email, String password, Role role) {
        this.userId = id;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    /**
     * Getter method to retrieve the user's name.
     *
     * @return The name of the user as a String.
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Setter method to update the user's name.
     *
     * @param userName The new name to be set for the user.
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Getter method to retrieve the user's role.
     *
     * @return The role of the user as a Role enum.
     */
    public Role getRole() {
        return role;
    }

    /**
     * Setter method to update the user's role.
     *
     * @param role The new role to be set for the user.
     */
    public void setRole(Role role) {
        this.role = role;
    }

    /**
     * Getter method to retrieve the user's password.
     *
     * @return The password of the user as a String.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter method to update the user's password.
     *
     * @param password The new password to be set for the user.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Getter method to retrieve the user's email address.
     *
     * @return The email address of the user as a String.
     */
    public String getEmailId() {
        return email;
    }

    /**
     * Setter method to update the user's email address.
     *
     * @param email The new email address to be set for the user.
     */
    public void setEmailId(String email) {
        this.email = email;
    }

    /**
     * Getter method to retrieve the user's ID.
     *
     * @return The ID of the user as a String.
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Setter method to update the user's ID.
     *
     * @param userId The new ID to be set for the user.
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }
}
