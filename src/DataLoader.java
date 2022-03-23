import java.io.FileReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * A class to load user, flight and hotel data
 * @author Mario Misencik, Evan Scales
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
                    // GET NUM STOPS
                    // GET DISCOUNT PERCENT
                }
                // To-do: rest of the variables
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<Flight>();
    }

    /**
     * Loads the list of users from the json database
     * @return The list of users
     */
    public static ArrayList<RegisteredUser> getUsers() {
        ArrayList<RegisteredUser> users = new ArrayList<RegisteredUser>();
        HashMap<UUID, Friend> friendsList = getFriendsList();
        // HashMap<UUID, Ticket> ticketList = getTicketList();
        // HashMap<UUID, HotelReservation> hotelReservationList = getReservationList();

        try {
            FileReader reader = new FileReader(USERS_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray usersJSON = (JSONArray)new JSONParser().parse(reader);

            if (usersJSON == null) return users;

            for (int i = 0; i < usersJSON.size(); i++) {
                JSONObject userJSON = (JSONObject)usersJSON.get(i);
                UUID userID = UUID.fromString((String)userJSON.get(USERS_ID));
                String firstName = (String)userJSON.get(USERS_FIRST_NAME);
                String lastName = (String)userJSON.get(USERS_LAST_NAME);
                String email = (String)userJSON.get(USERS_EMAIL);
                int age = ((Long) userJSON.get(USERS_AGE)).intValue();
                String address = (String)userJSON.get(USERS_ADDRESS);
                String password = (String)userJSON.get(USERS_PASSWORD);
                String gender = (String)userJSON.get(USERS_GENDER);
                String preferredAirport = (String)userJSON.get(USERS_PREFFERRED_AIRPORT);
                boolean frequentFlyer = (Boolean)userJSON.get(USERS_FREQUENT_FLYER);
                boolean admin = (Boolean)userJSON.get(USERS_ADMIN_STATUS);
                boolean medicalCondition = (Boolean)userJSON.get(USERS_MEDICAL_CONDITION);

                // Get the black listed airports array list
                ArrayList<String> blackListedAirports = new ArrayList<String>();
                JSONArray blackListedAirportsList = (JSONArray)userJSON.get(USERS_BLACKLISTED_AIRPORTS);
                if (blackListedAirportsList != null) {
                    for (int j = 0; j < blackListedAirportsList.size(); j++) {
                        String blackListedAirport = (String) blackListedAirportsList.get(j);
                        blackListedAirports.add(blackListedAirport);
                    }
                }

                // Get the all UUIDs of the users tickets
                // Search the ticket list for those tickets
                // Add those tickets to tickets
                ArrayList<Ticket> tickets = new ArrayList<Ticket>();
                JSONArray ticketsArray = (JSONArray)userJSON.get(USERS_TICKETS_LIST);
                if (ticketsArray != null) {
                    HashMap<UUID, Ticket> ticketList = getTicketList();
                    for (int j = 0; j < ticketsArray.size(); j++) {
                        UUID ticketID = UUID.fromString((String)ticketsArray.get(j));
                        Ticket ticket = ticketList.get(ticketID);
                        tickets.add(ticket);
                    }
                }

                // Get all the UUIDs of the users hotel reservations
                // Search the hotelreservations list for those reservations
                // Add those reservations to hotelReservations
                ArrayList<HotelReservation> hotelReservations = new ArrayList<HotelReservation>();
                JSONArray reservationsArray = (JSONArray)userJSON.get(USERS_HOTEL_RESERVATIONS_LIST);
                if (reservationsArray != null) {
                    HashMap<UUID, HotelReservation> hotelReservationList = getReservationList();
                    for (int j = 0; j < reservationsArray.size(); j++) {
                        UUID reservationID = UUID.fromString((String)reservationsArray.get(j));
                        HotelReservation reservation = hotelReservationList.get(reservationID);
                        hotelReservations.add(reservation);
                    }
                }

                // Get all the UUIDs of the users friends
                // Search the friends list for those friends
                // Add those friends to friends
                ArrayList<Friend> friends = new ArrayList<Friend>();
                JSONArray friendsArray = (JSONArray)userJSON.get(USERS_FRIENDS_LIST);
                if (friendsArray != null) {
                    for (int j = 0; j < friendsArray.size(); j++) {
                        UUID friendID = UUID.fromString((String)friendsArray.get(j));
                        Friend friend = friendsList.get(friendID);
                        friends.add(friend);
                    }
                }

                RegisteredUser user = new RegisteredUser(userID, firstName,
                lastName, email, age, address, password, gender,
                preferredAirport, frequentFlyer, admin, medicalCondition,
                blackListedAirports, tickets, hotelReservations, friends);

                users.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return users;
    }

    /**
     * Loads the list of hotels
     * @return The list of hotels
     */
    public static ArrayList<Hotel> getHotels() {
        return new ArrayList<Hotel>();
    }

    /**
     * Gets all the reservations from reservations.json
     * Puts all those reservations in a hashmap
     * @return The hashmap holding all the hotel reservations
     */
    private static HashMap<UUID, HotelReservation> getReservationList() {
        HashMap<UUID, HotelReservation> hotelReservationsList = new HashMap<UUID, HotelReservation>();
        HashMap<UUID, Room> roomList = getRoomList();
    
        try {
            FileReader reader = new FileReader(RESERVATIONS_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray reservationsJSON = (JSONArray)new JSONParser().parse(reader);

            for (int i = 0; i < reservationsJSON.size(); i++) {
                JSONObject reservationJSON = (JSONObject)reservationsJSON.get(i);
                UUID hotelID = UUID.fromString((String)reservationJSON.get(RESERVATIONS_HOTEL_ID));
                Hotel hotel = HotelList.getHotel(hotelID);
                String firstName = (String) reservationJSON.get(RESERVATIONS_FIRST_NAME);
                String lastName = (String) reservationJSON.get(RESERVATIONS_LAST_NAME);
                UUID roomID = UUID.fromString((String)reservationJSON.get(RESERVATIONS_ROOM_ID));
                Room room = roomList.get(roomID);
                int price = ((Long) reservationJSON.get(RESERVATIONS_PRICE)).intValue();
                LocalDate checkInDate = LocalDate.parse((String)reservationJSON.get(RESERVATIONS_CHECK_IN_DATE), DateTimeFormatter.ofPattern("MM/dd/yyyy"));
                LocalDate checkOutDate = LocalDate.parse((String)reservationJSON.get(RESERVATIONS_CHECK_OUT_DATE), DateTimeFormatter.ofPattern("MM/dd/yyyy"));
                int numGuests = Integer.parseInt((String) reservationJSON.get(RESERVATIONS_NUM_GUESTS));
                UUID id = UUID.fromString((String) reservationJSON.get(RESERVATIONS_ID));



                HotelReservation reservation = new HotelReservation(hotel,
                firstName, lastName, room, price, checkInDate, checkOutDate,
                numGuests, id);

                hotelReservationsList.put(id, reservation);
            }



        } catch (Exception e) {
            e.printStackTrace();
        }


        return hotelReservationsList;
    }

    /**
     * Gets all the reviews from reviewss.json
     * Puts all the reviews and their id in a hashmap
     * @return The hashmap with the reviews
     */
    private static HashMap<UUID, Review> getReviewList() {
        HashMap<UUID, Review> reviewList = new HashMap<UUID, Review>();

        try {
            FileReader reader = new FileReader(REVIEWS_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray reviewsArray = (JSONArray)new JSONParser().parse(reader);

            for (int i = 0; i < reviewsArray.size(); i++) {
                JSONObject reviewJSON = (JSONObject) reviewsArray.get(i);

                int rating = ((Long) reviewJSON.get(REVIEWS_RATING)).intValue();
                String comment = (String) reviewJSON.get(REVIEWS_COMMENT);
                UUID userID = UUID.fromString((String) reviewJSON.get(REVIEWS_USER_ID));
                RegisteredUser user = UserList.getUser(userID);
                UUID id = UUID.fromString((String) reviewJSON.get(REVIEWS_ID));


                Review review = new Review(rating, comment, user, id);
                reviewList.put(id, review);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        return reviewList;
    }

    /**
     * Get all the rooms from rooms.json
     * Puts all the rooms and their id into a hashmap
     * @return The hashmap of the rooms
     */
    private static HashMap<UUID, Room> getRoomList() {
        HashMap<UUID, Room> roomList = new HashMap<UUID, Room>();

        try {
            FileReader reader = new FileReader(ROOMS_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray roomsArray = (JSONArray)new JSONParser().parse(reader);

            for (int i = 0; i < roomsArray.size(); i++) {
                JSONObject roomJSON = (JSONObject)roomsArray.get(i);

                Boolean smokingAllowed = (Boolean) roomJSON.get(ROOMS_SMOKING);
                int numBeds = ((Long) roomJSON.get(ROOMS_NUM_BEDS)).intValue();
                UUID id = UUID.fromString((String) roomJSON.get(ROOMS_ID));
                Boolean booked = (Boolean) roomJSON.get(ROOMS_BOOKED);
                int price = ((Long) roomJSON.get(ROOMS_PRICE)).intValue();
                String type = (String) roomJSON.get(ROOMS_ROOM_TYPE);
                String number = (String) roomJSON.get(ROOMS_ROOM_NUMBER);

                // Get the booked days
                ArrayList<LocalDate> bookedDays = new ArrayList<LocalDate>();
                JSONArray bookedDaysArray = (JSONArray)roomJSON.get(ROOMS_BOOKED_DAYS_LIST);
                if (bookedDaysArray != null) {
                    for (int j = 0; j < bookedDaysArray.size(); j++) {
                        String sDate = (String) bookedDaysArray.get(j);
                        LocalDate date = LocalDate.parse(sDate, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
                        bookedDays.add(date);
                    }
                }


                Room room = new Room(smokingAllowed, bookedDays, numBeds,
                id, booked, price, type, number);

                roomList.put(id, room);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return roomList;
    }

    /**
     * Gets all the seats from seatings,json
     * Puts all the seatins and their id in a hashmap
     * @return The hashmap with all the seatings
     */
    private static HashMap<UUID, Seating> getSeatingList() {
        HashMap<UUID, Seating> seatingList = new HashMap<UUID, Seating>();

        try {
            FileReader reader = new FileReader(SEATINGS_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray seatingsArray = (JSONArray)new JSONParser().parse(reader);

            for (int i = 0; i < seatingsArray.size(); i++) {
                JSONObject seatingJSON = (JSONObject) seatingsArray.get(i);

                Boolean medicalSeat = (Boolean) seatingJSON.get(SEATINGS_MEDICAL_SEAT);
                UUID id = UUID.fromString((String) seatingJSON.get(SEATINGS_ID));
                Boolean booked = (Boolean) seatingJSON.get(SEATINGS_BOOKED);
                int price = ((Long) seatingJSON.get(SEATINGS_PRICE)).intValue();
                String type = (String) seatingJSON.get(SEATINGS_CABIN);
                String number = (String) seatingJSON.get(SEATINGS_SEAT_NUMBER);

                Seating seat = new Seating(medicalSeat, id, booked, price, type, number);
                seatingList.put(id, seat);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }



        return seatingList;
    }

    /**
     * Gets all the tickets from tickets.json
     * Puts the ticket and their id in a hashmap
     * @return The hashmap with the tickets and ids
     */
    private static HashMap<UUID, Ticket> getTicketList() {
        HashMap<UUID, Ticket> ticketList = new HashMap<UUID, Ticket>();
        HashMap<UUID, Seating> seatingList = getSeatingList();

        try {
            FileReader reader = new FileReader(TICKETS_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray ticketsArray = (JSONArray)new JSONParser().parse(reader);

            for (int i = 0; i < ticketsArray.size(); i++) {
                JSONObject ticketJSON = (JSONObject) ticketsArray.get(i);

                String boardingGroup = (String) ticketJSON.get(TICKETS_BOARDING_GROUP);
                String boardingTime = (String) ticketJSON.get(TICKETS_BOARDTING_TME);
                String gate = (String) ticketJSON.get(TICKETS_GATE);
                int numOfCheckedBags = ((Long) ticketJSON.get(TICKETS_CHECKED_BAGS)).intValue();
                UUID flightID = UUID.fromString((String) ticketJSON.get(TICKETS_FLIGHT_ID));
                Flight flight = FlightList.getFlight(flightID);
                UUID seatID = UUID.fromString((String) ticketJSON.get(TICKETS_SEAT_ID));
                Seating seat = seatingList.get(seatID);
                String firstName = (String) ticketJSON.get(TICKETS_FIRST_NAME);
                String lastName = (String) ticketJSON.get(TICKETS_LAST_NAME);
                int price = ((Long) ticketJSON.get(TICKETS_PRICE)).intValue();
                UUID id = UUID.fromString((String) ticketJSON.get(TICKETS_ID));
                String name = firstName + " " + lastName;


                Ticket ticket = new Ticket(boardingGroup, boardingTime, gate,
                name, numOfCheckedBags, flight, seat, firstName, lastName,
                price, id);

                ticketList.put(id, ticket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ticketList;
    }

    /**
     * Get the friends from friends.json
     * Put all the friends and their uuid into a hashmap
     * @return The hashmap of friends
     */
    private static HashMap<UUID, Friend> getFriendsList() {
        HashMap<UUID, Friend> friendList = new HashMap<UUID, Friend>();

        try {
            FileReader reader = new FileReader(FRIENDS_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray friendsArray = (JSONArray)new JSONParser().parse(reader);

            for (int i = 0; i < friendsArray.size(); i++) {
                JSONObject friendJSON = (JSONObject) friendsArray.get(i);

                String firstName = (String) friendJSON.get(FRIENDS_FIRST_NAME);
                String lastName = (String) friendJSON.get(FRIENDS_LAST_NAME);
                int age = ((Long) friendJSON.get(FRIENDS_AGE)).intValue();
                Boolean medicalCondition = (Boolean) friendJSON.get(FRIENDS_MEDICAL_CONDITION);
                String gender = (String) friendJSON.get(FRIENDS_GENDER);
                String email = (String) friendJSON.get(FRIENDS_EMAIL);
                String address = (String) friendJSON.get(FRIENDS_ADDRESS);
                UUID id = UUID.fromString((String) friendJSON.get(FRIENDS_ID));


                Friend friend = new Friend(firstName, lastName, age,
                medicalCondition, gender, email, address, id);
                friendList.put(id, friend);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return friendList;
    }
}