package com.kodilla.testing.forum.statistics;

public class AdvStatistics {
    Statistics statistics;
    private int usersNumber;
    private int postsQuantity;
    private int commentsQuantity ;
    private double postsPerUsersAv;
    private double commentsPerUsersAv;
    private double commentsPerPostsAv;

    public AdvStatistics(Statistics statistics) {
        this.statistics = statistics;
    }

    public void calculateAdvStatistics(Statistics statistics){
        usersNumber = statistics.usersNames().size();
        postsQuantity = statistics.postsCount();
        commentsQuantity = statistics.commentsCount();
        postsPerUsersAv = ((double) postsQuantity / (double) usersNumber);
        commentsPerUsersAv = ((double) commentsQuantity / (double) usersNumber);
        commentsPerPostsAv = ((double) commentsQuantity / (double) postsQuantity);
    }

    public void ShowStatistics(){
        System.out.println("\nLiczba użytkowników: " + usersNumber);
        System.out.println("Liczba postów: " + postsQuantity);
        System.out.println("Liczba komentarzy: " + commentsQuantity);
        System.out.println("Srednia liczba postów na użytkownika: " + postsPerUsersAv);
        System.out.println("Srednia liczba komentarzy na użytkownika: " + commentsPerUsersAv);
        System.out.println("Srednia liczba komentarzy na post: " + commentsPerPostsAv);
    }

    public double getPostsPerUsersAv() {
        return postsPerUsersAv;
    }

    public double getCommentsPerUsersAv() {
        return commentsPerUsersAv;
    }

    public double getCommentsPerPostsAv() {
        return commentsPerPostsAv;
    }
}
