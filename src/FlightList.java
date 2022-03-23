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
     * 
     * @param id
     * @return
     */
    public static Flight getFlight(UUID id) {
        
    }

}
