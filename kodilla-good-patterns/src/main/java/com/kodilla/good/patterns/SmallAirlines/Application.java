package com.kodilla.good.patterns.SmallAirlines;

public class Application {
    public static void main(String[] args) {
        City city = new City("Warszawa");
        City cityFrom = new City("Warszawa");
        City cityTo = new City("Lublin");

        FindFlight findFlight = new FindFlight();

        System.out.print("From " + city.getName() + " you can fly to: \n");
        for(City result : findFlight.findFrom(city)){
            System.out.println(result.getName());
        }

        System.out.print("\nTo " + city.getName() + " you can fly from: \n");
        for(City result : findFlight.findTo(city)){
            System.out.println(result.getName());
        }

        System.out.print("\nTo " + cityTo.getName() + " you can fly from " + cityFrom.getName() + " through:\n");
        for(City result : findFlight.findThrough(cityFrom, cityTo)){
            System.out.println(result.getName());
        }

    }
}
