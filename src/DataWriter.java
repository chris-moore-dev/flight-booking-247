import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * A class to write data to the flight, user and hotel JSON files
 * @author Mario Misencik
 */
public class DataWriter extends DataConstants {
    
    /**
     * Saves flights to the flight JSON file
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
        flightDetails.put(FLIGHTS_DEST_GATE, flight.getDestGate());
        JSONArray flightsArray = new JSONArray();
        for (Flight flt : flight.getFlights()) {
            flightsArray.add(flt);
        }
        flightDetails.put(FLIGHTS_FLIGHT_LIST, flightsArray);
        flightDetails.put(FLIGHTS_NUM_STOPS, flight.getNumStops());
        flightDetails.put("discountPercent", flight.getDiscountPercent());
        JSONArray priceArray = new JSONArray();
        for (Map.Entry price : flight.getPricing().entrySet()) {
            priceArray.add(price);
        }
        flightDetails.put(FLIGHTS_PRICING_LIST, priceArray);
        JSONArray seatArray = new JSONArray();
        for (Map.Entry seat : flight.getSeating().entrySet()) {
            seatArray.add(seat);
        }
        flightDetails.put(FLIGHTS_INDIVIDUALBOOKINGS_LIST, seatArray);
        return flightDetails;
    }

    /**
     * Saves users to the user JSON file
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
        userDetails.put(USERS_FIRST_NAME, user.getFirstName());
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
        JSONArray blackListedAirportsArray = new JSONArray();
        for (String bla : user.getBlackListedAirports()) {
            blackListedAirportsArray.add(bla);
        }
        userDetails.put(USERS_BLACKLISTED_AIRPORTS, blackListedAirportsArray);
        JSONArray ticketArray = new JSONArray();
        for (Ticket tick : user.getTickets()) {
            ticketArray.add(tick);
        }
        userDetails.put(USERS_TICKETS_LIST, ticketArray);
        JSONArray reservationArray = new JSONArray();
        for (HotelReservation reserv : user.getHotelReservations()) {
            reservationArray.add(reserv);
        }
        userDetails.put(USERS_HOTEL_RESERVATIONS_LIST, reservationArray);
        JSONArray friendArray = new JSONArray();
        for (Friend friend : user.getFriends()) {
            friendArray.add(friend);
        }
        userDetails.put(USERS_FRIENDS_LIST, friendArray);
        return userDetails;
    }

    /**
     * Saves hotels to the hotel JSON file
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

    /**
     * 
     * @param hotel
     * @return
     */
    public static JSONObject getHotelJSON(Hotel hotel) {
        JSONObject hotelDetails = new JSONObject();
        hotelDetails.put(HOTELS_ID, hotel.getID().toString());
        hotelDetails.put(HOTELS_COMPANY, hotel.getCompany());
        hotelDetails.put(HOTELS_CITY, hotel.getCity());
        hotelDetails.put(HOTELS_CLOSEST_AIRPORT, hotel.getClosestAirport());
        hotelDetails.put(HOTELS_ADDRESS, hotel.getAddress());
        JSONArray amenitiesArray = new JSONArray();
        for (String amen : hotel.getAmenities()) {
            amenitiesArray.add(amen);
        }
        hotelDetails.put(HOTELS_AMMENITIES_LIST, amenitiesArray);
        JSONArray priceArray = new JSONArray();
        for (Map.Entry price : hotel.getPricing().entrySet()) {
            priceArray.add(price);
        }
        hotelDetails.put(HOTELS_PRICING_LIST, priceArray);
        JSONArray roomArray = new JSONArray();
        for (Map.Entry room : hotel.getRooms().entrySet()) {
            roomArray.add(room);
        }
        hotelDetails.put(HOTELS_INDIVIDUALBOOKINGS_LIST, roomArray);
        JSONArray reviewArray = new JSONArray();
        for (Review rev : hotel.getReviews()) {
            reviewArray.add(rev);
        }
        hotelDetails.put(HOTELS_REVIEWS_LIST, reviewArray);
        return hotelDetails;
    }

}
