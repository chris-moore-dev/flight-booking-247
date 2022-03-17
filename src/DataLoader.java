import java.io.FileReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

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
        ArrayList<Flight> flights = new ArrayList<Flight>();
        try {
            FileReader reader = new FileReader(FLIGHTS_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray flightsJSON = (JSONArray)new JSONParser().parse(reader);

            for (int i = 0; i < flightsJSON.size(); i++) {
                JSONObject flightJSON = (JSONObject)flightsJSON.get(i);
                UUID id = UUID.fromString((String)flightJSON.get(FLIGHTS_ID));
                String company = (String)flightJSON.get(FLIGHTS_COMPANY);
                LocalDate date = LocalDate.parse((String)flightJSON.get(FLIGHTS_DATE), DateTimeFormatter.ofPattern("MM/dd/yyyy"));
                String departingAirport = (String)flightJSON.get(FLIGHTS_DEPARTING_AIRPORT);
                String destAirport = (String)flightJSON.get(FLIGHTS_DEST_AIRPORT);
                String takeOffTime = (String)flightJSON.get(FLIGHTS_TAKE_OFF_TIME);
                String landingTime = (String)flightJSON.get(FLIGHTS_LANDING_TIME);
                String totalFlightTime = (String)flightJSON.get(FLIGHTS_TOTAL_TIME);
                boolean layover = (Boolean)flightJSON.get(FLIGHTS_LAYOVER);
                if (layover) {
                    ArrayList<Flight> flightList = new ArrayList<Flight>();
                    JSONArray flightArray = (JSONArray)flightJSON.get(FLIGHTS_FLIGHT_LIST);
                    for (int j = 0; j < flightArray.size(); j++) {
                        UUID flightID = UUID.fromString((String)flightArray.get(j));
                        Flight flight = FlightList.getFlight(flightID);
                        flightList.add(flight);
                    }
                }
                // To-do: rest of the variables
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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