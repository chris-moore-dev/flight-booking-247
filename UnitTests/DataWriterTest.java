import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;

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

    @BeforeEach
    public void setup() {
        userList.getInstance().getUsers().clear();
        flightList.getInstance().getFlights().clear();
        hotelList.getInstance().getHotels().clear();
        DataWriter.saveDatabase();
    }

    @AfterEach
    public void tearDown() {
        userList.getInstance().getUsers().clear();
        flightList.getInstance().getFlights().clear();
        hotelList.getInstance().getHotels().clear();
        DataWriter.saveDatabase();
    }

    @Test
    void TestWritingNoUser() {
        users = DataLoader.getUsers();
        assertEquals(0, users.size());
    }

    @Test
    void testWritingUser() {
        users.add(new RegisteredUser("Michael","Myers","mmyers@gmail.com",65,"123 Killer St.","H@1l0w33n","Male","LAX",false,false,false,null,null,null,null));
        DataWriter.saveUsers();
        assertEquals("Michael", DataLoader.getUsers().get(0).getFirstName());
    }

    @Test
    void testWritingNullUser() {
        users.add(new RegisteredUser(null,null,null,0,null,null,null,null,false,false,false,null,null,null,null));
        DataWriter.saveUsers();
        assertEquals(null, DataLoader.getUsers().get(0).getFirstName());
    }

    @Test
    void testWritingEmptyUser() {
        users.add(new RegisteredUser("","","",0,"","","","",false,false,false,null,null,null,null));
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
        flights.add(new Flight(LocalDate.of(2022,4,15),"LAX","ATL","8:00 AM","12:00 PM","4 hrs",false,"Delta Airlines",null,null,"A21","B46"));
        DataWriter.saveFlights();
        assertEquals("LAX", DataLoader.getFlights().get(0).getDepartingAirport());
    }

    @Test
    void testWritingNullFlight() {
        flights.add(new Flight(null,null,null,null,null,null,false,null,null,null,null,null));
        DataWriter.saveFlights();
        assertEquals(null, DataLoader.getFlights().get(0).getDate());
    }

    @Test
    void testWritingEmptyFlight() {
        flights.add(new Flight(null,"","","","","",false,"",null,null,"",""));
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
        hotels.add(new Hotel("21 Jump St.",null,null,"ATL","Atlanta","Hyatt",null,null));
        DataWriter.saveHotels();
        assertEquals("21 Jump St.", DataLoader.getHotels().get(0).getAddress());
    }

    @Test
    void testWritingNullHotel() {
        hotels.add(new Hotel(null,null,null,null,null,null,null,null));
        DataWriter.saveHotels();
        assertEquals(null, DataLoader.getHotels().get(0).getAddress());
    }

    @Test
    void testWritingEmptyHotel() {
        hotels.add(new Hotel("",null,null,"","","",null,null));
        DataWriter.saveHotels();
        assertEquals("", DataLoader.getHotels().get(0).getAddress());
    }

    @Test
    void testWritingFriend() {
        RegisteredUser mike = new RegisteredUser("Michael","Myers","mmyers@gmail.com",65,"123 Killer St.","H@1l0w33n","Male","LAX",false,false,false,null,null,null,null);
        mike.addFriend(new Friend("Freddy","Krueger",50,false,"Male","krueger@gmail.com","666 Elm St."));
        users.add(mike);
        DataWriter.saveDatabase();
        assertEquals("Freddy", DataLoader.getUsers().get(0).getFriends().get(1).getFirstName());
    }

    @Test
    void testWritingNullFriend() {
        RegisteredUser mike = new RegisteredUser("Michael","Myers","mmyers@gmail.com",65,"123 Killer St.","H@1l0w33n","Male","LAX",false,false,false,null,null,null,null);
        mike.addFriend(new Friend(null,null,0,false,null,null,null));
        users.add(mike);
        DataWriter.saveDatabase();
        assertEquals(null, DataLoader.getUsers().get(0).getFriends().get(1).getFirstName());
    }

    @Test
    void testWritingEmptyFriend() {
        RegisteredUser mike = new RegisteredUser("Michael","Myers","mmyers@gmail.com",65,"123 Killer St.","H@1l0w33n","Male","LAX",false,false,false,null,null,null,null);
        mike.addFriend(new Friend("","",0,false,"","",""));
        users.add(mike);
        DataWriter.saveDatabase();
        assertEquals("", DataLoader.getUsers().get(0).getFriends().get(1).getFirstName());
    }
}
