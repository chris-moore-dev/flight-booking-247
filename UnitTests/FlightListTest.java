import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import org.junit.jupiter.api.*;

/**
 * A test class for FlightList
 * @author Mario Misencik
 */
class FlightListTest {
    private FlightList flightList = FlightList.getInstance();
    private ArrayList<Flight> flights = flightList.getFlights();

    @BeforeEach
    public void setup() {
        FlightList.getInstance().getFlights().clear();
        HashMap<String, Integer> pricing = new HashMap<String, Integer>();
        pricing.put("First", 400);
        pricing.put("Main Cabin", 300);
        pricing.put("Economy", 200);
        flights.add(new Flight(LocalDate.of(2022,4,20), "JFK", "ATL",
            "12:00 PM", "3:00 PM", "3 hours", false, "JetBlue", pricing,
            new HashMap<String, Seating>(), "C12", "A17"));
        DataWriter.saveFlights();
    }

    @AfterEach
    public void tearDown() {
        FlightList.getInstance().getFlights().clear();
        DataWriter.saveFlights();
    }

    @Test
    void testGetFlights() {
        assertEquals(1, flightList.getFlights().size());
    }

    @Test
    void testGetFlight() {
        assertEquals("JetBlue", flightList.getFlight(flights.get(0).getID()).getCompany());
    }

    @Test
    void testGetFlightNullID() {
        assertNull(flightList.getFlight(null));
    }

    @Test
    void testGetFlightWrongID() {
        assertNull(flightList.getFlight(UUID.randomUUID()));
    }
}