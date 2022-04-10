import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import org.junit.jupiter.api.*;
/**
 * User List Test File
 * @author Evan Scales
 */
public class UserListTest {
    private UserList userList = UserList.getInstance();
    private FlightList flightList = FlightList.getInstance();
    private HotelList hotelList = HotelList.getInstance();

    private ArrayList<RegisteredUser> users = userList.getUsers();
    private ArrayList<Flight> flights = flightList.getFlights();
    private ArrayList<Hotel> hotels = hotelList.getHotels();

    @BeforeEach
    public void setup() {
        UserList.getInstance().getUsers().clear();
        FlightList.getInstance().getFlights().clear();
        HotelList.getInstance().getHotels().clear();
        users.add(new RegisteredUser("Evan", "Scales", "evan@email.com", 20,
        "123 Fake St", "bean", "Male", "CLT", false, true, false, null,
        null, null, null));
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
    public void testGetUsers() {
        assertEquals(1, userList.getUsers().size());
    }

    @Test
    public void testGetUserUUID() {
        assertEquals("Evan", userList.getUser(users.get(0).getUUID()).getFirstName());
    }

    @Test
    public void testGetUserNULLUUID() {
        assertNull(userList.getUser(null));
    }

    @Test
    public void testGetUserLogin() {
        assertEquals("Evan", userList.getUser("evan@email.com", "bean").getFirstName());
    }

    @Test
    public void testGetUserWrongLogin() {
        assertNull(userList.getUser("evan@email.com", "password"));
    }






}
