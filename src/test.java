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
        System.out.println("@&!@&#");

        // RegisteredUser user = users.get(0);
        // Flight flight = flights.get(0);
        // String date = "09/11/2002";
        // System.out.println(date);
        // LocalDate date2 = LocalDate.parse(date, formatter);
        // System.out.println(date2);


        // System.out.println(flights.size());
        // for (Flight flight : flights) {
        //     System.out.println(flight.getIsLayover());
        // }
        

        // String toSplit = "Standard:45";
        // String[] split = toSplit.split(":");
        // System.out.println(split[0]);
        // System.out.println(split[1]);


        // testUserList(users.get(0));
        testFlightList(flights.get(0));
        // testHotelList(hotels.get(0));

        /**
         * Testing save users
         * @TEST
         */
        // RegisteredUser test = new RegisteredUser("TEST", "TEST", "TEST",
        // 0, "TEST", "TEST", "TEST", "TEST", false, false,
        // false, null, null, null, null);
        // users.add(test);
        // DataWriter.saveUsers();
        // DataWriter.saveFriends();
        // DataWriter.saveFlights();

        System.out.println(UUID.randomUUID());
    }

    /**
     * Testing UserList
     * Loading user by its self: PASS
     * Loading user with blackListed airports: PASS
     * Loading users with friends: PASS
     * Loading users tickets: PASS
     * Loading users with reservations: 
     * @param user The users being tested
     * @TEST
     */
    public static void testUserList(RegisteredUser user) {
        FlightSystem system = new FlightSystem();
        // Loading users by itself
        System.out.println(user.getFirstName());

        System.out.println(user.getAdmin());

        // user.addBlackListedAirport("CLT");

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

        // Loding with reservations
        // ArrayList<HotelReservation> reservations = user.getHotelReservations();
        // HotelReservation res = reservations.get(0);
        // HashMap<String, Room> rooms = res.getHotel().getRooms();
        // Room room = rooms.get("U1");
        // res.setRoom(room);
        // System.out.println(res);
        // system.printHotelReservationToFile(res);

        // // Loading with tickets
        // ArrayList<Ticket> tickets = user.getTickets();
        // Ticket ticket = tickets.get(0);
        // // System.out.println(ticket.getFlight().getCompany());
        // HashMap<String, Seating> seats = ticket.getFlight().getSeating();
        // Seating seat = seats.get("A1");
        // ticket.setSeat(seat);

        // system.printTicketToFile(ticket);

        // System.out.println(ticket);
    }

    /**
     * Basic loading of the flight (name, date, etc): PASS
     * Loading of pricing hashmap: PASS
     * Loading of seating hashmap: PASS
     * Loading of flights with layovers: PASS
     * @param flight The flight being tested
     * @TEST
     */
    public static void testFlightList(Flight flight) {
        System.out.println("-----TESTING FLIGHT-----");
        System.out.println(flight);
        Map<String, Seating> seats = flight.getSeating();


        for (String seatNum : seats.keySet()) {
            System.out.println(seatNum);
        }


        // System.out.println(flight.printSeats());
        // HashMap<String, Seating> seats = flight.getSeating();
        // System.out.println(seats.get("A11").getIsMedicalSeat());
        // System.out.println(flight.getID());
        // System.out.println(flight.getCompany());
        // System.out.println(flight.getDate());
        // System.out.println(flight.getDepartingAirport());
        // System.out.println(flight.getDestAirport());
        // System.out.println(flight.getTakeOffTime());
        // System.out.println(flight.getLandingTime());
        // System.out.println(flight.getTotalFlightTime());
        // System.out.println(flight.getIsLayover());
        // System.out.println(flight.getDepartingGate());
        

        // System.out.println(flight.getPrice("First"));
        // System.out.println(flight.getPrice("Main Cabin"));
        // System.out.println(flight.getPrice("Economy"));

        // HashMap<String, Seating> seats = flight.getSeating();
        // for (Seating seat : seats.values()) {
        //     System.out.println(seat.getID());
        // }


        // System.out.println(seats.get("D1").getIsMedicalSeat());

        // System.out.println(flight.getDate());

        // if (flight.getIsLayover()) {
        //     for (Flight flight2 : flight.getFlights()) {
        //         System.out.println("TESTING LAYOVER FLIGHTS");
        //         testFlightList(flight2);
        //     }
        // }

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
        System.out.println(hotel);
        // System.out.println(hotel.getID());
        // System.out.println(hotel.getCompany());
        // System.out.println(hotel.getCity());
        // System.out.println(hotel.getClosestAirport());
        // System.out.println(hotel.getAddress());

        // for (String s : hotel.getAmenities()) {
        //     System.out.println(s);
        // }

        // HashMap<String, Room> rooms = hotel.getRooms();
        // System.out.println(rooms.get("U1").getNumber());

        // ArrayList<Review> reviews = hotel.getReviews();
        // Review review = reviews.get(0);
        // // if (review == null) System.out.println("fuck");
        // System.out.println(review);
    }

    
    
}