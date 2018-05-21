package com.kodilla.hibernate.manytomany.facade;

public class SearchingException extends Exception {
    public static final String ERR_SEARCHING = "Fragment can't be null";

    public SearchingException(String message){
        super(message);
    }
}
