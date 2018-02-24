package com.kodilla.exception.test;

public class ExceptionHandling extends Exception{

    public static void main(String[] args) {

        SecondChallenge secondChallenge = new SecondChallenge();

        try {
            String result = secondChallenge.probablyIWillThrowException(1, 1.5);
            System.out.println(result);

        } catch (Exception e) {
            System.out.println("Attention! x must be >= 2 or < 1 and y can't be 1,5");
        } finally {
            System.out.println("Closing...");
        }
    }

}
