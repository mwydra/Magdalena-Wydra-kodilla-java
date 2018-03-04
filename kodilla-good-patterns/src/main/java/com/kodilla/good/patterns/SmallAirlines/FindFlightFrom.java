package com.kodilla.good.patterns.SmallAirlines;

import java.util.List;
import java.util.stream.Collectors;

public class FindFlightFrom {

    public List<City> find(City city){
        ListOfFlights listOfFlights = new ListOfFlights();
        List<City> flightsFrom = listOfFlights.getFlights().entrySet().stream()
                .filter(entry -> entry.getKey().equals(city))
                .flatMap(entry -> entry.getValue().stream())
                .collect(Collectors.toList());
        return flightsFrom;
    }
}
