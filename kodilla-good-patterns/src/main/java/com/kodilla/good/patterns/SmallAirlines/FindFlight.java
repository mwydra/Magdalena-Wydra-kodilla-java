package com.kodilla.good.patterns.SmallAirlines;

import java.util.List;
import java.util.stream.Collectors;

public class FindFlight {

    public List<City> findFrom(City city){
        ListOfFlights listOfFlights = new ListOfFlights();
        List<City> flightsFrom = listOfFlights.getFlights().entrySet().stream()
                .filter(entry -> entry.getKey().equals(city))
                .flatMap(entry -> entry.getValue().stream())
                .collect(Collectors.toList());
        return flightsFrom;
    }

    public List<City> findTo(City city){
        ListOfFlights listOfFlights = new ListOfFlights();
        List<City> flightsTo = listOfFlights.getFlights().entrySet().stream()
                .filter(entry -> entry.getValue().stream().anyMatch(s -> s.equals(city)))
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());
        return flightsTo;
    }

    public List<City> findThrough(City cityFrom, City cityTo){
        ListOfFlights listOfFlights = new ListOfFlights();
        List<City> flightsThrough = findTo(cityTo).stream()
                .filter(city -> findFrom(cityFrom).contains(city))
                .collect(Collectors.toList());
        return flightsThrough;
    }
}
