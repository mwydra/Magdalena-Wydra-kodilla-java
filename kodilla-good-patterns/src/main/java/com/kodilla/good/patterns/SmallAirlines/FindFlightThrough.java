package com.kodilla.good.patterns.SmallAirlines;

import java.util.List;
import java.util.stream.Collectors;

public class FindFlightThrough {

   public List<City> find(City cityFrom, City cityTo){
        ListOfFlights listOfFlights = new ListOfFlights();
        List<City> flightsThrough = listOfFlights.getFlights().entrySet().stream()
                .filter(entry -> entry.getKey().equals(cityFrom) || entry.getValue().stream().anyMatch(s -> s.equals(cityTo)))
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());
        return flightsThrough;
    }
}
