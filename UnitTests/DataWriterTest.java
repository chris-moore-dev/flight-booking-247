import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DataWriterTest {
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
    void TestWritingNoUser() {
        users = DataLoader.getUsers();
        assertEquals(0, users.size());
    }

    @Test
    void testWritingUser() {
        users.add(new RegisteredUser("Michael","Myers","mmyers@gmail.com",65,"123 Killer St.","H@1l0w33n","Male","LAX",false,false,false,new ArrayList<String>(),new ArrayList<Ticket>(),new ArrayList<HotelReservation>(),new ArrayList<Friend>()));
        DataWriter.saveUsers();
        assertEquals("Michael", DataLoader.getUsers().get(0).getFirstName());
    }

    @Test
    void testWritingNullUser() {
        users.add(new RegisteredUser(null,null,null,0,null,null,null,null,false,false,false,new ArrayList<String>(),new ArrayList<Ticket>(),new ArrayList<HotelReservation>(),new ArrayList<Friend>()));
        DataWriter.saveUsers();
        assertEquals("", DataLoader.getUsers().get(0).getFirstName());
    }

    @Test
    void testWritingEmptyUser() {
        users.add(new RegisteredUser("","","",0,"","","","",false,false,false,new ArrayList<String>(),new ArrayList<Ticket>(),new ArrayList<HotelReservation>(),new ArrayList<Friend>()));
        DataWriter.saveUsers();
        assertEquals("", DataLoader.getUsers().get(0).getFirstName());
    }

    @Test
    void testWritingNoFlight() {
        flights = DataLoader.getFlights();
        assertEquals(0, flights.size());
    }

    @Test
    void testWritingFlight() {
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
        DataWriter.saveFlights();
        assertEquals("CAE", DataLoader.getFlights().get(0).getDepartingAirport());
    }

    @Test
    void testWritingNullFlight() {
        HashMap<String, Integer> pricing = new HashMap<String, Integer>();
        pricing.put("First",500);
        pricing.put("Main Cabin", 350);
        pricing.put("Economy",200);
        flights.add(new Flight(LocalDate.of(2022,4,15),null,null,null,null,null,false,null,pricing,new HashMap<String,Seating>(),null,null));
        DataWriter.saveFlights();
        assertEquals(null, DataLoader.getFlights().get(0).getDepartingAirport());
    }

    @Test
    void testWritingEmptyFlight() {
        HashMap<String, Integer> pricing = new HashMap<String, Integer>();
        pricing.put("First",500);
        pricing.put("Main Cabin", 350);
        pricing.put("Economy",200);
        flights.add(new Flight(LocalDate.of(2022,4,15),"","","","","",false,"",pricing,new HashMap<String,Seating>(),"",""));
        DataWriter.saveFlights();
        assertEquals("", DataLoader.getFlights().get(0).getDepartingAirport());
    }

    @Test
    void testWritingNoHotel() {
        hotels = DataLoader.getHotels();
        assertEquals(0, hotels.size());
    }

    @Test
    void testWritingHotel() {
        HashMap<String, Integer> pricing = new HashMap<String, Integer>();
        pricing.put("Standard",350);
        pricing.put("Upgraded", 500);
        hotels.add(new Hotel("21 Jump St.",new ArrayList<Review>(),new ArrayList<String>(),"ATL","Atlanta","Hyatt",pricing,new HashMap<String,Room>()));
        DataWriter.saveHotels();
        assertEquals("21 Jump St.", DataLoader.getHotels().get(0).getAddress());
    }

    @Test
    void testWritingNullHotel() {
        HashMap<String, Integer> pricing = new HashMap<String, Integer>();
        pricing.put("Standard",350);
        pricing.put("Upgraded", 500);
        hotels.add(new Hotel(null,new ArrayList<Review>(),new ArrayList<String>(),null,null,null,pricing,new HashMap<String,Room>()));
        DataWriter.saveHotels();
        assertEquals(null, DataLoader.getHotels().get(0).getAddress());
    }

    @Test
    void testWritingEmptyHotel() {
        HashMap<String, Integer> pricing = new HashMap<String, Integer>();
        pricing.put("Standard",350);
        pricing.put("Upgraded", 500);
        hotels.add(new Hotel("",new ArrayList<Review>(),new ArrayList<String>(),"","","",pricing,new HashMap<String,Room>()));
        DataWriter.saveHotels();
        assertEquals("", DataLoader.getHotels().get(0).getAddress());
    }

    @Test
    void testWritingFriend() {
        RegisteredUser mike = new RegisteredUser("Michael","Myers","mmyers@gmail.com",65,"123 Killer St.","H@1l0w33n","Male","LAX",false,false,false,new ArrayList<String>(),new ArrayList<Ticket>(),new ArrayList<HotelReservation>(),new ArrayList<Friend>());
        mike.addFriend(new Friend("Freddy","Krueger",50,false,"Male","krueger@gmail.com","666 Elm St."));
        users.add(mike);
        DataWriter.saveDatabase();
        assertEquals("Freddy", DataLoader.getUsers().get(0).getFriends().get(1).getFirstName());
    }

    @Test
    void testWritingNullFriend() {
        RegisteredUser mike = new RegisteredUser("Michael","Myers","mmyers@gmail.com",65,"123 Killer St.","H@1l0w33n","Male","LAX",false,false,false,new ArrayList<String>(),new ArrayList<Ticket>(),new ArrayList<HotelReservation>(),new ArrayList<Friend>());
        mike.addFriend(new Friend(null,null,0,false,null,null,null));
        users.add(mike);
        DataWriter.saveDatabase();
        assertEquals(null, DataLoader.getUsers().get(0).getFriends().get(1).getFirstName());
    }

    @Test
    void testWritingEmptyFriend() {
        RegisteredUser mike = new RegisteredUser("Michael","Myers","mmyers@gmail.com",65,"123 Killer St.","H@1l0w33n","Male","LAX",false,false,false,new ArrayList<String>(),new ArrayList<Ticket>(),new ArrayList<HotelReservation>(),new ArrayList<Friend>());
        mike.addFriend(new Friend("","",0,false,"","",""));
        users.add(mike);
        DataWriter.saveDatabase();
        assertEquals("", DataLoader.getUsers().get(0).getFriends().get(1).getFirstName());
    }
}
