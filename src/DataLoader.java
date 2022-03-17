import java.util.ArrayList;

/**
 * A class to load user, flight and hotel data
 * @author Mario Misencik
 */
public class DataLoader extends DataConstants {
    
    /**
     * Loads the list of flights
     * @return The list of flights
     */
    public static ArrayList<Flight> getFlights() {
        return new ArrayList<Flight>();
    }

    /**
     * Loads the list of users
     * @return The list of users
     */
    public static ArrayList<User> getUsers() {
        return new ArrayList<User>();
    }

    /**
     * Loads the list of hotels
     * @return The list of hotels
     */
    public static ArrayList<Hotel> getHotels() {
        return new ArrayList<Hotel>();
    }

}