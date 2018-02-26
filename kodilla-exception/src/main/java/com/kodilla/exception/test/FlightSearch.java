package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightSearch {
    public boolean findFilght(Flight flight) throws RouteNotFoundException{
        Map<String, Boolean> airport = new HashMap<String, Boolean>();
        airport.put("Warsaw, Chopin", true);
        airport.put("Paris, Charles de Gaulle", true);
        airport.put("Palma de Mallorca", true);
        boolean found = false;

        for (Map.Entry<String, Boolean> entry : airport.entrySet()) {
            if (entry.getKey().equals(flight.getArrivalAirport())) {
                System.out.println("Your airport is " + entry.getKey());
                found = true;
            }
        }

        if(found != false){
            return found;
        }
        else
        throw new RouteNotFoundException();
   }

    public static void main(String[] args){
        Flight flight = new Flight("Warsaw, Chopin", "Paris, Orly");
        FlightSearch flightSearch = new FlightSearch();

        try {
            flightSearch.findFilght(flight);
        }
        catch (RouteNotFoundException e) {
            System.out.println("Flight not found.");
        }
        finally {
            System.out.println("End of searching...");
        }

    }
}
