package com.kodilla.good.patterns.SmallAirlines;

import java.util.List;
import java.util.stream.Collectors;

public class FindFlightTo {
    public List<City> find(City city){
        ListOfFlights listOfFlights = new ListOfFlights();
        List<City> flightsTo = listOfFlights.getFlights().entrySet().stream()
                .filter(entry -> entry.getValue().stream().anyMatch(s -> s.equals(city)))
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());
        return flightsTo;
    }
}
