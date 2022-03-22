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
        hotels = DataLoader.getHotels();
    }

    /**
     * Returns the hotel list
     * @return The hotel list
     */
    public static HotelList getInstance() {
        if (hotelList == null) {
            hotelList = new HotelList();
        }
        return hotelList;
    }

    /**
     * Returns the hotel list in the form of an ArrayList of hotels
     * @return The hotel list
     */
    public ArrayList<Hotel> getHotels() {
        return hotels;
    }

}
