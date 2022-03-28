import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * A class to write data to the JSON files
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
     * Extracts the information about the flight passed in and stores it in a JSON object.
     * @param flight The flight passed in
     * @return The flight's information, stored in a JSON object
     */
    public static JSONObject getFlightJSON(Flight flight) {
        JSONObject flightDetails = new JSONObject();
        flightDetails.put(FLIGHTS_ID, flight.getID().toString());
        flightDetails.put(FLIGHTS_COMPANY, flight.getCompany());
        flightDetails.put(FLIGHTS_DATE, flight.getDate().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
        flightDetails.put(FLIGHTS_DEPARTING_AIRPORT, flight.getDepartingAirport());
        flightDetails.put(FLIGHTS_DEST_AIRPORT, flight.getDestAirport());
        flightDetails.put(FLIGHTS_TAKE_OFF_TIME, flight.getTakeOffTime());
        flightDetails.put(FLIGHTS_LANDING_TIME, flight.getLandingTime());
        flightDetails.put(FLIGHTS_TOTAL_TIME, flight.getTotalFlightTime());
        flightDetails.put(FLIGHTS_LAYOVER, flight.getIsLayover());
        flightDetails.put(FLIGHTS_DEPARTING_GATE, flight.getDepartingGate());
        flightDetails.put(FLIGHTS_DEST_GATE, flight.getDestGate());
        if (flight.getFlights() != null) {
            JSONArray flightsArray = new JSONArray();
            for (Flight flt : flight.getFlights()) {
                flightsArray.add(flt.getID().toString());
            }
            flightDetails.put(FLIGHTS_FLIGHT_LIST, flightsArray);
        }
        flightDetails.put(FLIGHTS_NUM_STOPS, flight.getNumStops());
        flightDetails.put("discountPercent", flight.getDiscountPercent());
        JSONArray priceArray = new JSONArray();
        for (Map.Entry price : flight.getPricing().entrySet()) {
            priceArray.add(price.getKey() + ":" + price.getValue());
        }
        flightDetails.put(FLIGHTS_PRICING_LIST, priceArray);
        JSONArray seatArray = new JSONArray();
        if (!flight.getIsLayover()) {
            for (Map.Entry<String, Seating> seat : flight.getSeating().entrySet()) {
                seatArray.add(seat.getValue().getID().toString());
            }
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
     * Extracts the information about the user passed in and stores it in a JSON object.
     * @param user The user passed in
     * @return The user's information, stored in a JSON object
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
            ticketArray.add(tick.getID().toString());
        }
        userDetails.put(USERS_TICKETS_LIST, ticketArray);
        JSONArray reservationArray = new JSONArray();
        for (HotelReservation reserv : user.getHotelReservations()) {
            reservationArray.add(reserv.getID().toString());
        }
        userDetails.put(USERS_HOTEL_RESERVATIONS_LIST, reservationArray);
        JSONArray friendArray = new JSONArray();
        for (Friend friend : user.getFriends()) {
            friendArray.add(friend.getID().toString());
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
     * Extracts the information about the hotel passed in and stores it in a JSON object.
     * @param hotel The hotel passed in
     * @return The hotel's information, stored in a JSON object
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
            priceArray.add(price.getKey() + ":" + price.getValue());
        }
        hotelDetails.put(HOTELS_PRICING_LIST, priceArray);
        JSONArray roomArray = new JSONArray();
        for (Map.Entry<String, Room> room : hotel.getRooms().entrySet()) {
            roomArray.add(room.getValue().getID().toString());
        }
        hotelDetails.put(HOTELS_INDIVIDUALBOOKINGS_LIST, roomArray);
        JSONArray reviewArray = new JSONArray();
        for (Review rev : hotel.getReviews()) {
            reviewArray.add(rev.getId().toString());
        }
        hotelDetails.put(HOTELS_REVIEWS_LIST, reviewArray);
        return hotelDetails;
    }

    /**
     * Saves friends to the friend JSON file
     */
    public static void saveFriends() {
        UserList userList = UserList.getInstance();
        ArrayList<RegisteredUser> users = userList.getUsers();
        JSONArray jsonFriendList = new JSONArray();
        for (int i = 0; i < users.size(); i++) {
            for (int j = 0; j < users.get(i).getFriends().size(); j++) {
                jsonFriendList.add(getFriendJSON(users.get(i).getFriends().get(j)));
            }
        }
        try (FileWriter file = new FileWriter(FRIENDS_FILE_NAME)) {
            file.write(jsonFriendList.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Extracts the information about the friend passed in and stores it in a JSON object.
     * @param friend The friend passed in
     * @return The friend's information, stored in a JSON object
     */
    public static JSONObject getFriendJSON(Friend friend) {
        JSONObject friendDetails = new JSONObject();
        friendDetails.put(FRIENDS_ID, friend.getID().toString());
        friendDetails.put(FRIENDS_FIRST_NAME, friend.getFirstName());
        friendDetails.put(FRIENDS_LAST_NAME, friend.getLastName());
        friendDetails.put(FRIENDS_AGE, friend.getAge());
        friendDetails.put(FRIENDS_MEDICAL_CONDITION, friend.getMedicalCondition());
        friendDetails.put(FRIENDS_GENDER, friend.getGender());
        friendDetails.put(FRIENDS_EMAIL, friend.getEmail());
        friendDetails.put(FRIENDS_ADDRESS, friend.getAddress());
        return friendDetails;
    }

    /**
     * Saves tickets to the ticket JSON file
     */
    public static void saveTickets() {
        UserList userList = UserList.getInstance();
        ArrayList<RegisteredUser> users = userList.getUsers();
        ArrayList<Ticket> tickets = new ArrayList<Ticket>();
        for (RegisteredUser user : users) {
            ArrayList<Ticket> subTickets = user.getTickets();
            for (Ticket subTicket : subTickets) {
                tickets.add(subTicket);
            }
        }
        JSONArray jsonTicketList = new JSONArray();
        for (int i = 0; i < users.size(); i++) {
            for (int j = 0; j < users.get(i).getTickets().size(); j++) {
                jsonTicketList.add(getTicketJSON(users.get(i), users.get(i).getTickets().get(j)));
            }
        }
        try (FileWriter file = new FileWriter(TICKETS_FILE_NAME)) {
            file.write(jsonTicketList.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Extracts the information about the ticket passed in and stores it in a JSON object.
     * @param user The user the ticket belongs to
     * @param ticket The ticket passed in
     * @return The ticket's information, stored in a JSON object
     */
    public static JSONObject getTicketJSON(RegisteredUser user, Ticket ticket) {
        JSONObject ticketDetails = new JSONObject();
        ticketDetails.put(TICKETS_ID, ticket.getID().toString());
        ticketDetails.put(TICKETS_FLIGHT_ID, ticket.getFlight().getID().toString());
        ticketDetails.put(TICKETS_SEAT_ID, ticket.getSeat().getID().toString());
        ticketDetails.put(TICKETS_PRICE, ticket.getPrice());
        ticketDetails.put(TICKETS_FIRST_NAME, user.getFirstName());
        ticketDetails.put(TICKETS_LAST_NAME, user.getLastName());
        ticketDetails.put(TICKETS_BOARDING_GROUP, ticket.getBoardingGroup());
        ticketDetails.put(TICKETS_BOARDTING_TME, ticket.getBoardingTime());
        ticketDetails.put(TICKETS_CHECKED_BAGS, ticket.getNumOfCheckedBags());
        ticketDetails.put(TICKETS_GATE, ticket.getGate());
        return ticketDetails;
    }

    /**
     * Saves hotel reservations to the reservation JSON file
     */
    public static void saveReservations() {
        UserList userList = UserList.getInstance();
        ArrayList<RegisteredUser> users = userList.getUsers();
        JSONArray jsonReservationList = new JSONArray();
        for (int i = 0; i < users.size(); i++) {
            for (int j = 0; j < users.get(i).getHotelReservations().size(); j++) {
                jsonReservationList.add(getReservationsJSON(users.get(i).getHotelReservations().get(j)));
            }
        }
        try (FileWriter file = new FileWriter(RESERVATIONS_FILE_NAME)) {
            file.write(jsonReservationList.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Extracts the information about the hotel reservation passed in and stores it in a JSON object.
     * @param reservation The reservation passed in
     * @return The reservation's information, stored in a JSON object
     */
    public static JSONObject getReservationsJSON(HotelReservation reservation) {
        JSONObject reservationDetails = new JSONObject();
        reservationDetails.put(RESERVATIONS_ID, reservation.getID().toString());
        reservationDetails.put(RESERVATIONS_HOTEL_ID, reservation.getHotel().getID().toString());
        reservationDetails.put(RESERVATIONS_ROOM_ID, reservation.getRoom().getID().toString());
        reservationDetails.put(RESERVATIONS_PRICE, reservation.getPrice());
        reservationDetails.put(RESERVATIONS_FIRST_NAME, reservation.getReservationHolderFirstName());
        reservationDetails.put(RESERVATIONS_LAST_NAME, reservation.getReservationHolderLastName());
        reservationDetails.put(RESERVATIONS_CHECK_IN_DATE, reservation.getCheckInDate().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
        reservationDetails.put(RESERVATIONS_CHECK_OUT_DATE, reservation.getChecOutDate().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
        reservationDetails.put(RESERVATIONS_NUM_GUESTS, reservation.getNumGuests());
        return reservationDetails;
    }

    /**
     * Saves hotel reviews to the review JSON file
     */
    public static void saveReviews() {
        HotelList hotelList = HotelList.getInstance();
        ArrayList<Hotel> hotels = hotelList.getHotels();
        JSONArray jsonReviewList = new JSONArray();
        for (int i = 0; i < hotels.size(); i++) {
            for (int j = 0; j < hotels.get(i).getReviews().size(); j++) {
                jsonReviewList.add(getReviewJSON(hotels.get(i).getReviews().get(j)));
            }
        }
        try (FileWriter file = new FileWriter(REVIEWS_FILE_NAME)) {
            file.write(jsonReviewList.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Extracts the information about the review passed in and stores it in a JSON object.
     * @param review The review passed in
     * @return The review's information, stored in a JSON object
     */
    public static JSONObject getReviewJSON(Review review) {
        JSONObject reviewDetails = new JSONObject();
        reviewDetails.put(REVIEWS_ID, review.getId().toString());
        reviewDetails.put(REVIEWS_USER, review.getUser());
        reviewDetails.put(REVIEWS_COMMENT, review.getComment());
        reviewDetails.put(REVIEWS_RATING, review.getRating());
        return reviewDetails;
    }

    /**
     * Saves hotel rooms to the room JSON file
     */
    public static void saveRooms() {
        HotelList hotelList = HotelList.getInstance();
        ArrayList<Hotel> hotels = hotelList.getHotels();
        JSONArray jsonRoomList = new JSONArray();
        for (int i = 0; i < hotels.size(); i++) {
            for (Map.Entry<String, Room> room : hotels.get(i).getRooms().entrySet()) {
                jsonRoomList.add(getRoomJSON(room));
            }
        }
        try (FileWriter file = new FileWriter(ROOMS_FILE_NAME)) {
            file.write(jsonRoomList.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Extracts the information about the hotel room passed in and stores it in a JSON object.
     * @param room The room passed in
     * @return The room's information, stored in a JSON object
     */
    public static JSONObject getRoomJSON(Map.Entry<String, Room> room) {
        JSONObject roomDetails = new JSONObject();
        roomDetails.put(ROOMS_ID, room.getValue().getID().toString());
        roomDetails.put(ROOMS_ROOM_NUMBER, room.getValue().getNumber());
        roomDetails.put(ROOMS_BOOKED, room.getValue().getBooked());
        roomDetails.put(ROOMS_SMOKING, room.getValue().getIsSmokingAllowed());
        roomDetails.put(ROOMS_PRICE, room.getValue().getPrice());
        roomDetails.put(ROOMS_ROOM_TYPE, room.getValue().getType());
        roomDetails.put(ROOMS_NUM_BEDS, room.getValue().getNumBeds());
        JSONArray bookedArray = new JSONArray();
        for (LocalDate date : room.getValue().getBookedDays()) {
            bookedArray.add(date.format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
        }
        roomDetails.put(ROOMS_BOOKED_DAYS_LIST, bookedArray);
        return roomDetails;
    }

    /**
     * Saves seats to the seat JSON file
     */
    public static void saveSeatings() {
        FlightList flightList = FlightList.getInstance();
        ArrayList<Flight> flights = flightList.getFlights();
        JSONArray jsonSeatList = new JSONArray();
        for (int i = 0; i < flights.size(); i++) {
            if (flights.get(i).getIsLayover()) continue;
            for (Map.Entry<String, Seating> seat : flights.get(i).getSeating().entrySet()) {
                jsonSeatList.add(getSeatJSON(seat));
            }
        }
        try (FileWriter file = new FileWriter(SEATINGS_FILE_NAME)) {
            file.write(jsonSeatList.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Extracts the information about the seat passed in and stores it in a JSON object.
     * @param seat The seat passed in
     * @return The seat's information, stored in a JSON object
     */
    public static JSONObject getSeatJSON(Map.Entry<String, Seating> seat) {
        JSONObject seatDetails = new JSONObject();
        seatDetails.put(SEATINGS_ID, seat.getValue().getID().toString());
        seatDetails.put(SEATINGS_SEAT_NUMBER, seat.getValue().getNumber());
        seatDetails.put(SEATINGS_BOOKED, seat.getValue().getBooked());
        seatDetails.put(SEATINGS_MEDICAL_SEAT, seat.getValue().getIsMedicalSeat());
        seatDetails.put(SEATINGS_PRICE, seat.getValue().getPrice());
        seatDetails.put(SEATINGS_CABIN, seat.getValue().getType());
        return seatDetails;
    }

}
