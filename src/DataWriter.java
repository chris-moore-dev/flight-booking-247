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
        FlightList flightList = FlightList.getInstance();
        ArrayList<Flight> flights = flightList.getFlights();
        JSONArray jsonFlightList = new JSONArray();
        for (int i = 0; i < flights.size(); i++) {
            jsonFlightList.add(getFlightJSON(flights.get(i)));
        }
        try (FileWriter file = new FileWriter(FLIGHTS_FILE_NAME)) {
            file.write(jsonFlightList.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 
     * @param flight
     * @return
     */
    public static JSONObject getFlightJSON(Flight flight) {
        JSONObject flightDetails = new JSONObject();
        flightDetails.put(FLIGHTS_ID, flight.getID().toString());
        flightDetails.put(FLIGHTS_COMPANY, flight.getCompany());
        flightDetails.put(FLIGHTS_DATE, flight.getDate().toString());
        flightDetails.put(FLIGHTS_DEPARTING_AIRPORT, flight.getDepartingAirport());
        flightDetails.put(FLIGHTS_DEST_AIRPORT, flight.getDestAirport());
        flightDetails.put(FLIGHTS_TAKE_OFF_TIME, flight.getTakeOffTime());
        flightDetails.put(FLIGHTS_LANDING_TIME, flight.getLandingTime());
        flightDetails.put(FLIGHTS_TOTAL_TIME, flight.getTotalFlightTime());
        flightDetails.put(FLIGHTS_LAYOVER, flight.getIsLayover());
        flightDetails.put(FLIGHTS_DEPARTING_GATE, flight.getDepartingGate());
        // To-do: destination gate (no getter)
        flightDetails.put(FLIGHTS_FLIGHT_LIST, flight.getFlights());
        flightDetails.put(FLIGHTS_NUM_STOPS, flight.getNumStops());
        // To-do: discount percentage (no data constant)
        flightDetails.put(FLIGHTS_PRICING_LIST, flight.getPricing());
        // To-do: individual bookings (no getter)
        return flightDetails;
    }

    /**
     * Saves users to the list
     */
    public static void saveUsers() {
        UserList userList = UserList.getInstance();
        ArrayList<RegisteredUser> users = userList.getUsers();
        JSONArray jsonUserList = new JSONArray();
        for (int i = 0; i < users.size(); i++) {
            jsonUserList.add(getUserJSON(users.get(i)));
        }
        try (FileWriter file = new FileWriter(USERS_FILE_NAME)) {
            file.write(jsonUserList.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 
     * @param user
     * @return
     */
    public static JSONObject getUserJSON(RegisteredUser user) {
        JSONObject userDetails = new JSONObject();
        userDetails.put(USERS_ID, user.getUUID().toString());
        userDetails.put(USERS_FIRST_NAME, user.getFirstname());
        userDetails.put(USERS_LAST_NAME, user.getLastName());
        userDetails.put(USERS_EMAIL, user.getEmail());
        userDetails.put(USERS_AGE, user.getAge());
        userDetails.put(USERS_ADDRESS, user.getAddress());
        userDetails.put(USERS_PASSWORD, user.getPassword());
        userDetails.put(USERS_GENDER, user.getGender());
        userDetails.put(USERS_PREFFERRED_AIRPORT, user.getPreferredAirport());
        userDetails.put(USERS_FREQUENT_FLYER, user.getFrequentFlyer());
        userDetails.put(USERS_ADMIN_STATUS, user.getAdmin());
        userDetails.put(USERS_MEDICAL_CONDITION, user.getMedicalCondition());
        userDetails.put(USERS_BLACKLISTED_AIRPORTS, user.getBlackListedAirports());
        userDetails.put(USERS_TICKETS_LIST, user.getTickets());
        userDetails.put(USERS_HOTEL_RESERVATIONS_LIST, user.getHotelReservations());
        userDetails.put(USERS_FRIENDS_LIST, user.getFriends());
        return userDetails;
    }

    /**
     * Saves hotels to the list
     */
    public static void saveHotels() {
        HotelList hotelList = HotelList.getInstance();
        ArrayList<Hotel> hotels = hotelList.getHotels();
        JSONArray jsonHotelList = new JSONArray();
        for (int i = 0; i < hotels.size(); i++) {
            jsonHotelList.add(getHotelJSON(hotels.get(i)));
        }
        try (FileWriter file = new FileWriter(HOTELS_FILE_NAME)) {
            file.write(jsonHotelList.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static JSONObject getHotelJSON(Hotel hotel) {
        JSONObject hotelDetails = new JSONObject();
        hotelDetails.put(HOTELS_ID, hotel.getID().toString());
        hotelDetails.put(HOTELS_COMPANY, hotel.getCompany());
        hotelDetails.put(HOTELS_CITY, hotel.getCity());
        hotelDetails.put(HOTELS_CLOSEST_AIRPORT, hotel.getClosestAirport());
        hotelDetails.put(HOTELS_ADDRESS, hotel.getAddress());
        hotelDetails.put(HOTELS_AMMENITIES_LIST, hotel.getAmenities());
        hotelDetails.put(HOTELS_PRICING_LIST, hotel.getPricing());
        // To-do: individual bookings (no getter)
        hotelDetails.put(HOTELS_REVIEWS_LIST, hotel.getReviews());
        return hotelDetails;
    }

}
