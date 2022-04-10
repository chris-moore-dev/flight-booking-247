import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.*;


public class DataLoaderTest {
    private UserList userList = UserList.getInstance();
    private FlightList flightList = FlightList.getInstance();
    private HotelList hotelList = HotelList.getInstance();

    private ArrayList<RegisteredUser> users = userList.getUsers();
    private ArrayList<Flight> flights = flightList.getFlights();
    private ArrayList<Hotel> hotels = hotelList.getHotels();
    

    @BeforeEach
    public void setup() {

    }

    @AfterEach
    public void tearDown() {

    }
}
