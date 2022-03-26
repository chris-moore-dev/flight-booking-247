import java.util.ArrayList;

/**
 * The list of flights
 * @author Mario Misencik
 */
import java.util.*;
public class FlightList {
    private static FlightList flightList;
    private ArrayList<Flight> flights;

    /**
     * The list of flights
     */
    private FlightList() {
        flights = DataLoader.getFlights();
    }


    /**
     * Returns the flight list
     * @return The flight list
     */
    public static FlightList getInstance() {
        if (flightList == null) {
            flightList = new FlightList();
        }
        return flightList;
    }

    /**
     * Returns the flight list in the form of an ArrayList of flights
     * @return The flight list
     */
    public ArrayList<Flight> getFlights() {
        return flights;
    }

    /**
     * Returns the flight in the list that corresponds with the ID passed in
     * @param id The ID to be compared
     * @return The flight that corresponds with the ID
     */
    public Flight getFlight(UUID id) {
        for (Flight flight : flightList.flights) {
            if (flight.getID().equals(id)) {
                return flight;
            }
        }
        return null;
    }

}
