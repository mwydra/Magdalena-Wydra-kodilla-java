package com.kodilla.good.patterns.SmallAirlines;

public class Application {
    public static void main(String[] args) {
        City city = new City("Warszawa");
        City cityFrom = new City("Warszawa");
        City cityTo = new City("Lublin");

        FindFlightFrom findFlightFrom = new FindFlightFrom();
        System.out.print("From " + city.getName() + " you can fly to: \n");
        for(City result : findFlightFrom.find(city)){
            System.out.println(result.getName());
        }

        FindFlightTo findFlightTo = new FindFlightTo();
        System.out.print("\nTo " + city.getName() + " you can fly from: \n");
        for(City result : findFlightTo.find(city)){
            System.out.println(result.getName());
        }

        FindFlightThrough findFlightThrough = new FindFlightThrough();
        //System.out.println(findFlightThrough.find(cityFrom, cityTo).size());
        System.out.print("\nTo " + cityTo.getName() + " you can fly from " + cityFrom.getName() + " through:\n");
        for(City result : findFlightThrough.find(cityFrom, cityTo)){
            System.out.println(result.getName());
        }

    }
}
