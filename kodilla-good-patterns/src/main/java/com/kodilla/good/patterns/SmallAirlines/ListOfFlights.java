package com.kodilla.good.patterns.SmallAirlines;

import java.util.*;

public class ListOfFlights {
    City warsaw = new City("Warszawa");
    City krakow = new City("Kraków");
    City gdansk = new City("Gdańsk");
    City poznan = new City("Poznań");
    City wroclaw = new City("Wrocław");
    City katowice = new City("Katowice");
    City lodz = new City("Łódź");
    City lublin = new City("Lublin");
    City szczecin = new City("Szczecin");

    public Map<City, List<City>> getFlights() {
        Map<City, List<City>> flights = new HashMap<>();
        List<City> warsawFlights = Arrays.asList(krakow, wroclaw, gdansk, poznan, katowice);
        List<City> krakowFlights = Arrays.asList(warsaw, gdansk, lublin);
        List<City> gdanskFlights = Arrays.asList(warsaw, krakow, poznan);
        List<City> lodzFlights = Arrays.asList(warsaw, wroclaw, szczecin, lublin);
        flights.put(warsaw, warsawFlights);
        flights.put(krakow, krakowFlights);
        flights.put(gdansk, gdanskFlights);
        flights.put(lodz, lodzFlights);
        return flights;
    }



}
