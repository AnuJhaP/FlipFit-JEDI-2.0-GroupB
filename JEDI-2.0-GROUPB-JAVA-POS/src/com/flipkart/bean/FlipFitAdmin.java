package com.flipkart.bean;

/**
 * FlipFitAdmin class represents an administrator user in the FlipFit system,
 * extending from the FlipFitUser class.
 */
public class FlipFitAdmin extends FlipFitUser {
    private String userId;      // User ID of the administrator
    private String password;    // Password of the administrator
    private String email;       // Email address of the administrator

    /**
     * Getter method for retrieving the email address of the administrator.
     *
     * @return The email address of the administrator.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter method for updating the email address of the administrator.
     *
     * @param email The new email address to be set for the administrator.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Getter method for retrieving the password of the administrator.
     *
     * @return The password of the administrator.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter method for updating the password of the administrator.
     *
     * @param password The new password to be set for the administrator.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Getter method for retrieving the user ID of the administrator.
     *
     * @return The user ID of the administrator.
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Setter method for updating the user ID of the administrator.
     *
     * @param userId The new user ID to be set for the administrator.
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }
}
