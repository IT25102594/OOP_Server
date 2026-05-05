package com.adminmanagement.adminmanagement;

public class Review {
    private Long id;
    private String userName;
    private String comment;

    // Constructor
    public Review(Long id, String userName, String comment) {
        this.id = id;
        this.userName = userName;
        this.comment = comment;
    }

    // Getters and Setters (Encapsulation)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }
    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }
}