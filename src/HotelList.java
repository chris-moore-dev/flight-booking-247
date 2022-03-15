import java.util.ArrayList;

/**
 * The list of hotels
 * @author Mario Misencik
 */
public class HotelList {
    private static HotelList hotelList;
    private ArrayList<Hotel> hotels;

    /**
     * The list of hotels
     */
    private HotelList() {

    }

    /**
     * Returns the hotel list
     * @return The hotel list
     */
    public static HotelList getInstance() {
        return hotelList;
    }

    /**
     * Returns hotels based on the user's inputs
     * @return Hotels
     */
    public ArrayList<Hotel> getHotels() {
        return hotels;
    }

}
