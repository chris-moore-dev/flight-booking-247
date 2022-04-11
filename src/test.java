import java.util.*;
import java.util.stream.Collectors;
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


        // System.out.println(flights.size());
        // for (Flight flight : flights) {
        //     System.out.println(flight.getIsLayover());
        // }
        

        // String toSplit = "Standard:45";
        // String[] split = toSplit.split(":");
        // System.out.println(split[0]);
        // System.out.println(split[1]);


        // testUserList(users.get(0));
        // testFlightList(flights.get(0));
        // testHotelList(hotels.get(0));

        RegisteredUser user = users.get(0);
        Hotel hotel = hotels.get(0);

        

        /**
         * Use index 0 if testing with a normal flight
         * Use index 3 if testing a flight with a layover
         */
        Flight flight = flights.get(0);


        // testUserList(user);
        testFlightList(flight);
        // testHotelList(hotel);

        // String date1 = "03/07/2022";
        // String date2 = "03/09/2022";

        // // /**
        // //  * How to get number of nights to book for given 2 dates as strings
        // //  */
        // LocalDate tDate = LocalDate.parse(date1, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        // LocalDate tDate2 = LocalDate.parse(date2, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        // List<LocalDate> listOfDates = tDate.datesUntil(tDate2)
		// .collect(Collectors.toList());
        // System.out.println(listOfDates.size());


        // testRegisteredUserMethods(user, flight, hotel);

        /**
         * Testing save users
         * @TEST
         */
        // RegisteredUser evan = new RegisteredUser("Evan", "Scales", "escales@email.sc.edu",
        // 20, "112 Silo ct, Columbia, SC, 29702, USA", "password123", "Male", "CLT", false, true,
        // false, null, null, null, null);
        // users.add(evan);
        DataWriter.saveUsers();
        DataWriter.saveFriends();
        DataWriter.saveFlights();
        DataWriter.saveSeatings();
        DataWriter.saveHotels();
        DataWriter.saveReviews();
        DataWriter.saveRooms();
        DataWriter.saveTickets();
        DataWriter.saveReservations();

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
        System.err.println(user.getEmail());

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

        // // Loding with reservations
        // ArrayList<HotelReservation> reservations = user.getHotelReservations();
        // HotelReservation res = reservations.get(0);
        // System.out.println(res.getRoom().getNumber());
        // System.out.println(res);
        // system.printHotelReservationToFile(res);

        // // Loading with tickets
        // ArrayList<Ticket> tickets = user.getTickets();
        // Ticket ticket = tickets.get(0);
        // System.out.println(ticket.getPrice());
        // system.printTicketToFile(ticket);

        // System.out.println(ticket);
    }

    /**
     * Book flight test: PASS
     * UnBook flight test: PASS
     * Book Hotel test: PASS
     * UnBook Hotel test: PASS
     * @param user The user being tested
     * @param flight Flight to test with
     * @param hotel Hotel to test with
     * @Test
     */
    public static void testRegisteredUserMethods(RegisteredUser user, Flight flight, Hotel hotel) {
        FlightSystem system = new FlightSystem();
        ArrayList<Flight> flights = new ArrayList<>();
        ArrayList<Seating> seating = new ArrayList<>();
        ArrayList<Friend> ticketHolders = new ArrayList<>();

        // flights.add(flight);

        // Map<String, Seating> seats = flight.getSeating();
        // Seating seat = seats.get("A1");
        // seating.add(seat);

        // ticketHolders.add(user.getFriends().get(0));
        // System.out.println(seat.getBooked());

        // // user.unBookFlight(user.getTickets().get(0));

        // System.out.println(seat.getBooked());




        // String date1 = "03/07/2022";
        // String date2 = "03/09/2022";
        // LocalDate checkInDate = LocalDate.parse(date1, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        // LocalDate checkOutDate = LocalDate.parse(date2, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        // HashMap<String, Room> rooms = hotel.getRooms();
        // Room room = rooms.get("U1");
        // int numGuests = 1;


        // user.bookHotel(hotel, room, numGuests, checkInDate, checkOutDate);
        // HotelReservation res = user.getHotelReservations().get(0);
        // // user.unBookHotel(res);
        // System.out.println(res);
        
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
        if (!flight.getIsLayover())
            System.out.println(flight.printSeats());
        // System.out.println(flight.printSeats());
        // flight.book("D30");
        // System.out.println(flight.printSeats());
        // Map<String, Seating> seats = flight.getSeating();


        // for (String seatNum : seats.keySet()) {
        //     System.out.println(seatNum);
        // }


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