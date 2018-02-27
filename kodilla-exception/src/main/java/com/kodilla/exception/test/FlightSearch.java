import com.kodilla.exception.test.Flight;
import com.kodilla.exception.test.RouteNotFoundException;

import java.util.HashMap;
import java.util.Map;

public class FlightSearch {

    public boolean findFilght(Flight flight) throws RouteNotFoundException {
        Map<String, Boolean> airport = new HashMap<String, Boolean>();
        airport.put("Warsaw, Chopin", true);
        airport.put("Paris, Charles de Gaulle", true);
        airport.put("Palma de Mallorca", true);
        boolean found = false;

        if (airport.get(flight.getArrivalAirport())) {
            System.out.println("Your airport is " + flight.getArrivalAirport().toString());
            found = true;
        }

        if (airport.get(flight.getArrivalAirport()) == false) {
            throw new RouteNotFoundException();
        }
        return found;
    }

    public static void main(String[] args){
        Flight flight = new Flight("Warsaw, Chopin", "Palma de Mallorca");
        FlightSearch flightSearch = new FlightSearch();

        try {
            flightSearch.findFilght(flight);
        }
        catch (Exception e) {
            System.out.println("Flight not found.");
        }
        finally {
            System.out.println("End of searching...");
        }

    }
}