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
        DataWriter.saveDatabase();
        assertEquals("Michael", DataLoader.getUsers().get(0).getFirstName());
    }

    @Test
    void testWritingNullUser() {
        users.add(new RegisteredUser(null,null,null,0,null,null,null,null,false,false,false,new ArrayList<String>(),new ArrayList<Ticket>(),new ArrayList<HotelReservation>(),new ArrayList<Friend>()));
        DataWriter.saveDatabase();
        assertEquals("", DataLoader.getUsers().get(0).getFirstName());
    }

    @Test
    void testWritingEmptyUser() {
        users.add(new RegisteredUser("","","",0,"","","","",false,false,false,new ArrayList<String>(),new ArrayList<Ticket>(),new ArrayList<HotelReservation>(),new ArrayList<Friend>()));
        DataWriter.saveDatabase();
        assertEquals("", DataLoader.getUsers().get(0).getFirstName());
    }

    @Test
    void testWritingNoFlight() {
        flights = DataLoader.getFlights();
        assertEquals(0, flights.size());
    }

    @Test
    void testWritingFlight() {
        HashMap<String, Integer> pricing = new HashMap<String, Integer>();
        pricing.put("First", 500);
        pricing.put("Main Cabin", 350);
        pricing.put("Economy", 200);
        flights.add(new Flight(LocalDate.of(2022,4,15),"LAX","ATL","8:00 AM","12:00 PM","4 hrs",false,"Delta Airlines",pricing,new HashMap<String,Seating>(),"A21","B46"));
        DataWriter.saveDatabase();
        assertEquals("LAX", DataLoader.getFlights().get(0).getDepartingAirport());
    }

    @Test
    void testWritingNullFlight() {
        HashMap<String, Integer> pricing = new HashMap<String, Integer>();
        pricing.put("First", 500);
        pricing.put("Main Cabin", 350);
        pricing.put("Economy", 200);
        flights.add(new Flight(LocalDate.of(2022,4,15),null,null,null,null,null,false,null,pricing,new HashMap<String,Seating>(),null,null));
        DataWriter.saveDatabase();
        assertEquals(null, DataLoader.getFlights().get(0).getDepartingAirport());
    }

    @Test
    void testWritingEmptyFlight() {
        HashMap<String, Integer> pricing = new HashMap<String, Integer>();
        pricing.put("First", 500);
        pricing.put("Main Cabin", 350);
        pricing.put("Economy", 200);
        flights.add(new Flight(LocalDate.of(2022,4,15),"","","","","",false,"",pricing,new HashMap<String,Seating>(),"",""));
        DataWriter.saveDatabase();
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
        pricing.put("Standard", 350);
        pricing.put("Upgraded", 500);
        hotels.add(new Hotel("21 Jump St.",new ArrayList<Review>(),new ArrayList<String>(),"ATL","Atlanta","Hyatt",pricing,new HashMap<String,Room>()));
        DataWriter.saveDatabase();
        assertEquals("21 Jump St.", DataLoader.getHotels().get(0).getAddress());
    }

    @Test
    void testWritingNullHotel() {
        HashMap<String, Integer> pricing = new HashMap<String, Integer>();
        pricing.put("Standard", 350);
        pricing.put("Upgraded", 500);
        hotels.add(new Hotel(null,new ArrayList<Review>(),new ArrayList<String>(),null,null,null,pricing,new HashMap<String,Room>()));
        DataWriter.saveDatabase();
        assertEquals(null, DataLoader.getHotels().get(0).getAddress());
    }

    @Test
    void testWritingEmptyHotel() {
        HashMap<String, Integer> pricing = new HashMap<String, Integer>();
        pricing.put("Standard", 350);
        pricing.put("Upgraded", 500);
        hotels.add(new Hotel("",new ArrayList<Review>(),new ArrayList<String>(),"","","",pricing,new HashMap<String,Room>()));
        DataWriter.saveDatabase();
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

    @Test
    void testWritingTicket() {
        RegisteredUser mike = new RegisteredUser("Michael","Myers","mmyers@gmail.com",65,"123 Killer St.","H@1l0w33n","Male","LAX",false,false,false,new ArrayList<String>(),new ArrayList<Ticket>(),new ArrayList<HotelReservation>(),new ArrayList<Friend>());
        HashMap<String, Integer> pricing = new HashMap<String, Integer>();
        pricing.put("First", 500);
        pricing.put("Main Cabin", 350);
        pricing.put("Economy", 200);
        Flight mikeFlight = new Flight(LocalDate.of(2022,4,15),"LAX","ATL","8:00 AM","12:00 PM","4 hrs",false,"Delta Airlines",pricing,new HashMap<String,Seating>(),"A21","B46");
        mike.addTicket(new Ticket("1A","7:30 AM","A21","Michael Myers",0,mikeFlight,mikeFlight.getSeating().get("A1"),"Michael","Myers",500));
        users.add(mike);
        DataWriter.saveDatabase();
        assertEquals("Michael Myers", DataLoader.getUsers().get(0).getTickets().get(0).getName());
    }

    @Test
    void testWritingReservation() {
        RegisteredUser mike = new RegisteredUser("Michael","Myers","mmyers@gmail.com",65,"123 Killer St.","H@1l0w33n","Male","LAX",false,false,false,new ArrayList<String>(),new ArrayList<Ticket>(),new ArrayList<HotelReservation>(),new ArrayList<Friend>());
        HashMap<String, Integer> pricing = new HashMap<String, Integer>();
        pricing.put("Standard", 350);
        pricing.put("Upgraded", 500);
        Hotel mikeHotel = new Hotel("21 Jump St.",new ArrayList<Review>(),new ArrayList<String>(),"ATL","Atlanta","Hyatt",pricing,new HashMap<String,Room>());
        mike.addHotelReservation(new HotelReservation(mikeHotel,"Michael","Myers",mikeHotel.getRooms().get("U1"),500,LocalDate.of(2022,4,15),LocalDate.of(2022,4,20),1));
        users.add(mike);
        DataWriter.saveDatabase();
        assertEquals("Michael", DataLoader.getUsers().get(0).getHotelReservations().get(0).getReservationHolderFirstName());
    }

    @Test
    void testWritingReview() {
        HashMap<String, Integer> pricing = new HashMap<String, Integer>();
        pricing.put("Standard", 350);
        pricing.put("Upgraded", 500);
        Hotel mikeHotel = new Hotel("21 Jump St.",new ArrayList<Review>(),new ArrayList<String>(),"ATL","Atlanta","Hyatt",pricing,new HashMap<String,Room>());
        mikeHotel.addReview(new Review(5,"...","Michael Myers"));
        hotels.add(mikeHotel);
        DataWriter.saveDatabase();
        assertEquals("Michael Myers", DataLoader.getHotels().get(0).getReviews().get(0).getUser());
    }

    @Test
    void testWritingRoom() {
        HashMap<String, Integer> pricing = new HashMap<String, Integer>();
        pricing.put("Standard", 350);
        pricing.put("Upgraded", 500);
        Hotel mikeHotel = new Hotel("21 Jump St.",new ArrayList<Review>(),new ArrayList<String>(),"ATL","Atlanta","Hyatt",pricing,new HashMap<String,Room>());
        hotels.add(mikeHotel);
        DataWriter.saveDatabase();
        assertEquals("U1", DataLoader.getHotels().get(0).getRooms().get("U1").getNumber());
    }

    @Test
    void testWritingAllRooms() {
        HashMap<String, Integer> pricing = new HashMap<String, Integer>();
        pricing.put("Standard", 350);
        pricing.put("Upgraded", 500);
        Hotel mikeHotel = new Hotel("21 Jump St.",new ArrayList<Review>(),new ArrayList<String>(),"ATL","Atlanta","Hyatt",pricing,new HashMap<String,Room>());
        hotels.add(mikeHotel);
        DataWriter.saveDatabase();
        assertEquals(90, DataLoader.getHotels().get(0).getRooms().size());
    }

    @Test
    void testWritingSeat() {
        HashMap<String, Integer> pricing = new HashMap<String, Integer>();
        pricing.put("First", 500);
        pricing.put("Main Cabin", 350);
        pricing.put("Economy", 200);
        Flight mikeFlight = new Flight(LocalDate.of(2022,4,15),"LAX","ATL","8:00 AM","12:00 PM","4 hrs",false,"Delta Airlines",pricing,new HashMap<String,Seating>(),"A21","B46");
        flights.add(mikeFlight);
        DataWriter.saveDatabase();
        assertEquals("A1", DataLoader.getFlights().get(0).getSeating().get("A1").getNumber());
    }

    @Test
    void testWritingAllSeats() {
        HashMap<String, Integer> pricing = new HashMap<String, Integer>();
        pricing.put("First", 500);
        pricing.put("Main Cabin", 350);
        pricing.put("Economy", 200);
        Flight mikeFlight = new Flight(LocalDate.of(2022,4,15),"LAX","ATL","8:00 AM","12:00 PM","4 hrs",false,"Delta Airlines",pricing,new HashMap<String,Seating>(),"A21","B46");
        flights.add(mikeFlight);
        DataWriter.saveDatabase();
        assertEquals(120, DataLoader.getFlights().get(0).getSeating().size());
    }
}
