import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * A class to write data to the flight, user and hotel lists
 * @author Mario Misencik
 */
public class DataWriter extends DataConstants {
    
    /**
     * Saves flights to the list
     */
    public static void saveFlights() {
        UserList userList = UserList.getInstance();
        ArrayList<RegisteredUser> users = userList.getUsers();
        JSONArray jsonUserList = new JSONArray();
        // To-do: rest of method
    }

    /**
     * Saves users to the list
     */
    public static void saveUsers() {
        FlightList flightList = FlightList.getInstance();
        ArrayList<Flight> flights = flightList.getFlights();
        JSONArray jsonFlightList = new JSONArray();
        // To-do: rest of method
    }

    /**
     * Saves hotels to the list
     */
    public static void saveHotels() {
        HotelList hotelList = HotelList.getInstance();
        ArrayList<Hotel> hotels = hotelList.getHotels();
        JSONArray jsonHotelList = new JSONArray();
        // To-do: rest of method
    }

}
