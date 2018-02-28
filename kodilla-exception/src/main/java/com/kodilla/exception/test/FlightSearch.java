import com.kodilla.exception.test.Flight;
import com.kodilla.exception.test.RouteNotFoundException;

import java.util.HashMap;
import java.util.Map;

public class FlightSearch {

    public Boolean findFilght(Flight flight) throws RouteNotFoundException {
        Map<String, Boolean> airport = new HashMap<String, Boolean>();
        airport.put("Warsaw, Chopin", true);
        airport.put("Paris, Charles de Gaulle", true);
        airport.put("Palma de Mallorca", false);

        if (airport.containsKey(flight.getArrivalAirport())) {
            return airport.get(flight.getArrivalAirport());
        }
        throw new RouteNotFoundException();

    }

    public static void main(String[] args){
        Flight flight = new Flight("Warsaw, Chopin", "Paris, Orly");
        FlightSearch flightSearch = new FlightSearch();

        try {
            System.out.println("Flight possibility: " + flightSearch.findFilght(flight));
        }
        catch (Exception e) {
            System.out.println("Flight not found.");
        }
        finally {
            System.out.println("End of searching...");
        }

    }
}