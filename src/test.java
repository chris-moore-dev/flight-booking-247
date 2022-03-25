import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * test
 */
public class test {

    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");


        FlightList flightList = FlightList.getInstance();
        HotelList hotelList = HotelList.getInstance();
        UserList userList = UserList.getInstance();

        ArrayList<Flight> flights = flightList.getFlights();
        ArrayList<Hotel> hotels = hotelList.getHotels();
        ArrayList<RegisteredUser> users = userList.getUsers();

        // RegisteredUser user = users.get(0);
        // Flight flight = flights.get(0);
        // String date = "09/11/2002";
        // System.out.println(date);
        // LocalDate date2 = LocalDate.parse(date, formatter);
        // System.out.println(date2);

        

        // String toSplit = "Standard:45";
        // String[] split = toSplit.split(":");
        // System.out.println(split[0]);
        // System.out.println(split[1]);
        // testUserList(users.get(0));
        // testFlightList(flights.get(0));
        testHotelList(hotels.get(0));
        System.out.println(UUID.randomUUID());
    }

    /**
     * Testing UserList
     * Loading user by its self: PASS
     * Loading user with blackListed airports: PASS
     * Loading users with friends: PASS
     * Loading users tickets:
     * Loading users with reservations: 
     * @param user The users being tested
     * @TEST
     */
    public static void testUserList(RegisteredUser user) {
        // Loading users by itself
        System.out.println(user.getFirstName());

        System.out.println(user.getAdmin());

        // Loading user with blackListed airports
        ArrayList<String> blackListedAirports = user.getBlackListedAirports();
        for (String blackListedAirport : blackListedAirports) {
            System.out.println(blackListedAirport);
        }

        // Loading user with friends
        ArrayList<Friend> friends = user.getFriends();
        for (Friend friend : friends) {
            System.out.println(friend);
        }
    }

    /**
     * Basic loading of the flight (name, date, etc): PASS
     * Loading of pricing hashmap: PASS
     * Loading of seating hashmap: Pass
     * @param flight The flight being tested
     * @TEST
     */
    public static void testFlightList(Flight flight) {
        System.out.println("-----TESTING FLIGHT-----");
        System.out.println(flight.getID());
        System.out.println(flight.getCompany());
        System.out.println(flight.getDate());
        System.out.println(flight.getDepartingAirport());
        System.out.println(flight.getDestAirport());
        System.out.println(flight.getTakeOffTime());
        System.out.println(flight.getLandingTime());
        System.out.println(flight.getTotalFlightTime());
        System.out.println(flight.getIsLayover());
        System.out.println(flight.getDepartingGate());
        

        System.out.println(flight.getPrice("First"));
        System.out.println(flight.getPrice("Main Cabin"));
        System.out.println(flight.getPrice("Economy"));

        HashMap<String, Seating> seats = flight.getSeating();


        System.out.println(seats.get("D1").getIsMedicalSeat());

        System.out.println(flight.getDate());

        // testFlightList(FlightList.getFlight(flight.getID()));
    }

    /**
     * Basic loading of hotel (name, id, etc): PASS
     * Loading of rooms and prcing hashmap: PASS
     * Loading of ammenities array list: PASS
     * Loading of reviews array list: PASS
     * @param hotel
     * @TEST
     */
    public static void testHotelList(Hotel hotel) {
        System.out.println("-----TESTING HOTEL-----");
        System.out.println(hotel.getID());
        System.out.println(hotel.getCompany());
        System.out.println(hotel.getCity());
        System.out.println(hotel.getClosestAirport());
        System.out.println(hotel.getAddress());

        for (String s : hotel.getAmenities()) {
            System.out.println(s);
        }

        HashMap<String, Room> rooms = hotel.getRooms();
        System.out.println(rooms.get("U1").getNumber());

        ArrayList<Review> reviews = hotel.getReviews();
        Review review = reviews.get(0);
        // if (review == null) System.out.println("fuck");
        System.out.println(review.getComment());
        System.out.println(review.getRating());
        System.out.println(review.getUser().getFirstName());
    }

    
    
}