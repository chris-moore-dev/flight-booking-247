import java.util.ArrayList;

/**
 * The list of flights
 * @author Mario Misencik
 */
public class FlightList {
    private static FlightList flightList;
    private ArrayList<Flight> flights;

    /**
     * The list of flights
     */
    private FlightList() {

    }

    /**
     * Returns the flight list
     * @return The flight list
     */
    public static FlightList getInstance() {
        return flightList;
    }

    /**
     * Returns the flights based on the user's inputs
     * @return Flights
     */
    public ArrayList<Flight> getFlights() {
        return flights;
    }

}
