import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.*;

/**
 * A test class for HotelList
 * @author Mario Misencik
 */
class HotelListTest {
    private HotelList hotelList = HotelList.getInstance();
    private ArrayList<Hotel> hotels = hotelList.getHotels();

    @BeforeEach
    public void setup() {
        HotelList.getInstance().getHotels().clear();
        HashMap<String, Integer> pricing = new HashMap<String, Integer>();
        pricing.put("Standard", 350);
        pricing.put("Upgraded", 500);
        hotels.add(new Hotel("1 Broadway Blvd.",
            new ArrayList<Review>(),
            new ArrayList<String>(),
            "JFK", "New York City", "Hilton", 
            pricing, new HashMap<String, Room>()));
        DataWriter.saveHotels();
    }

    @AfterEach
    public void tearDown() {
        HotelList.getInstance().getHotels().clear();
        DataWriter.saveHotels();
    }

    @Test
    void testGetHotels() {
        assertEquals(1, hotelList.getHotels().size());
    }

    @Test
    void testGetHotel() {
        assertEquals("1 Broadway Blvd.", hotelList.getHotel(hotels.get(0).getID()).getAddress());
    }
}