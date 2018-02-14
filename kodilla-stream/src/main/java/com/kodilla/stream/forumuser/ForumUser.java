package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public final class ForumUser {
    private final int userID;
    private final String username;
    private final char sex;
    private final LocalDate birthDetails;
    private final int numberOfPosts;

    public ForumUser(final int userID, final String username, final char sex, final LocalDate birthDetails, final int numberOfPosts) {
        this.userID = userID;
        this.username = username;
        this.sex = sex;
        this.birthDetails = birthDetails;
        this.numberOfPosts = numberOfPosts;
    }

    public int getUserID() {
        return userID;
    }

    public String getUsername() {
        return username;
    }

    public char getSex() {
        return sex;
    }

    public LocalDate getBirthDetails() {
        return birthDetails;
    }

    public int getNumberOfPosts() {
        return numberOfPosts;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "userID=" + userID +
                ", username='" + username + '\'' +
                ", sex=" + sex +
                ", birthDetails=" + birthDetails +
                ", numberOfPosts=" + numberOfPosts +
                '}';
    }
}
