import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import org.junit.jupiter.api.*;

/**
 * Data Loader Test File
 * @author Evan Scales
 */
public class DataLoaderTest {
    private UserList userList = UserList.getInstance();
    private FlightList flightList = FlightList.getInstance();
    private HotelList hotelList = HotelList.getInstance();

    private ArrayList<RegisteredUser> users = userList.getUsers();
    private ArrayList<Flight> flights = flightList.getFlights();
    private ArrayList<Hotel> hotels = hotelList.getHotels();

    private DateTimeFormatter format = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    

    @BeforeEach
    public void setup() {
        UserList.getInstance().getUsers().clear();
        FlightList.getInstance().getFlights().clear();
        HotelList.getInstance().getHotels().clear();
        DataWriter.saveDatabase();
    }

    @AfterEach
    public void tearDown() {
        UserList.getInstance().getUsers().clear();
        FlightList.getInstance().getFlights().clear();
        HotelList.getInstance().getHotels().clear();
        DataWriter.saveDatabase();
    }

    @Test
    public void testGetFlights() {
        String sDate = "04/01/2022";
        LocalDate date = LocalDate.parse(sDate, format);
        String departingAirport = "CAE";
        String destAirport = "SEA";
        String takeOffTime = "5:17 AM";
        String landingTime = "12:48 PM";
        String totalFlightTime = "10h 31m";
        boolean layover = true;
        String company = "American Airlines";
        HashMap<String, Integer> pricing = new HashMap<>();
        pricing.put("First", 200);
        pricing.put("Main Cabin", 150);
        pricing.put("Economy", 125);
        String departingGate = "17";
        String destGate = "420";
        Map<String, Seating> seats = new HashMap<>();

        flights.add(new Flight(date, departingAirport, destAirport,
        takeOffTime, landingTime, totalFlightTime, layover, company, pricing,
        seats, departingGate, destGate));
        DataWriter.saveDatabase();
        ArrayList<Flight> flightTest = DataLoader.getFlights();
        assertEquals(1, flightTest.size());
    }

    @Test
    public void testGetFlightsWithSeats() {
        String sDate = "04/01/2022";
        LocalDate date = LocalDate.parse(sDate, format);
        String departingAirport = "CAE";
        String destAirport = "SEA";
        String takeOffTime = "5:17 AM";
        String landingTime = "12:48 PM";
        String totalFlightTime = "10h 31m";
        boolean layover = true;
        String company = "American Airlines";
        HashMap<String, Integer> pricing = new HashMap<>();
        pricing.put("First", 200);
        pricing.put("Main Cabin", 150);
        pricing.put("Economy", 125);
        String departingGate = "17";
        String destGate = "420";
        Map<String, Seating> seats = new HashMap<>();

        flights.add(new Flight(date, departingAirport, destAirport,
        takeOffTime, landingTime, totalFlightTime, layover, company, pricing,
        seats, departingGate, destGate));
        DataWriter.saveDatabase();
        
        Map<String, Seating> testSeating = flights.get(0).getSeating();
        assertEquals(120, testSeating.size());
    }

    @Test
    public void testGetUsers() {
        users.add(new RegisteredUser("firstName", "lastName", "email", 20, "address",
        "password", "gender", "preferredAirport", false, false, false,
        null, null, null, null));
        DataWriter.saveDatabase();
        ArrayList<RegisteredUser> userTest = DataLoader.getUsers();
        assertEquals(1, userTest.size());
    }

    @Test
    public void testGetUsersWithFriends() {
        users.add(new RegisteredUser("firstName", "lastName", "email", 20, "address",
        "password", "gender", "preferredAirport", false, false, false,
        null, null, null, null));
        DataWriter.saveDatabase();

        assertEquals("firstName", users.get(0).getFriends().get(0).getFirstName());
    }

    @Test
    public void testGetHotels() {
        String address = "293 Crazy St, Seattle, WA 98101";
        ArrayList<Review> reviews = new ArrayList<>();
        ArrayList<String> amenities = new ArrayList<>();
        amenities.add("Cat Lounge");
        amenities.add("WiFi");
        amenities.add("Pool");
        amenities.add("Office");
        amenities.add("Free Breakfast");
        String closestAirport = "SEA";
        String city = "Seattle";
        String company = "Cat House";
        HashMap<String, Integer> pricing = new HashMap<>();
        pricing.put("Standard", 150);
        pricing.put("Upgraded", 200);

        HashMap<String, Room> rooms = new HashMap<>();

        hotels.add(new Hotel(address, reviews, amenities, closestAirport,
        city, company, pricing, rooms));

        DataWriter.saveDatabase();
        ArrayList<Hotel> hotelTest = DataLoader.getHotels();
        assertEquals(1, hotelTest.size());
    }

    @Test
    public void testGetHotelsWithRooms() {
        String address = "293 Crazy St, Seattle, WA 98101";
        ArrayList<Review> reviews = new ArrayList<>();
        ArrayList<String> amenities = new ArrayList<>();
        amenities.add("Cat Lounge");
        amenities.add("WiFi");
        amenities.add("Pool");
        amenities.add("Office");
        amenities.add("Free Breakfast");
        String closestAirport = "SEA";
        String city = "Seattle";
        String company = "Cat House";
        HashMap<String, Integer> pricing = new HashMap<>();
        pricing.put("Standard", 150);
        pricing.put("Upgraded", 200);

        HashMap<String, Room> rooms = new HashMap<>();

        hotels.add(new Hotel(address, reviews, amenities, closestAirport,
        city, company, pricing, rooms));

        DataWriter.saveDatabase();

        HashMap<String, Room> testRooms = hotels.get(0).getRooms();
        assertEquals(90, testRooms.size());
    }


}
