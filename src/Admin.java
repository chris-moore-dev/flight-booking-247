import java.util.ArrayList;
import java.util.HashMap;

/**
 * Admin class
 * @author Chris Moore
 */
public class Admin extends RegisteredUser {
  /**
   * Default constructor
   */
  Admin() {
    // super()
  }

  /**
   * 
   * @param date
   * @param departingAirport
   * @param destAirport
   * @param cabins
   * @param seats
   * @param takeOffTime
   * @param landingTime
   * @param totalFlightTime
   * @param airline
   * @param numSeats
   * @param flightID
   */
  public void addFlight(String date, String departingAirport, String destAirport, ArrayList<Cabin> cabins, HashMap<Integer, Seating> seats, String takeOffTime, String landingTime, String totalFlightTime, String airline, int numSeats, int flightID) {

  }

  /**
   * 
   * @param name
   * @param address
   * @param reviews
   * @param checkInAge
   * @param ammenities
   * @param numRooms
   * @param rooms
   * @param closestAirportDistance
   * @param hotelID
   * @param cloesestAirport
   */
  public void addHotel(String name, String address, ArrayList<Review> reviews, int checkInAge, ArrayList<String> ammenities, int numRooms, HashMap<Integer, Room> rooms, int closestAirportDistance, int hotelID, String cloesestAirport) {

  }

  /**
   * 
   * @param hotelID
   */
  public void removeHotel(int hotelID) {

  }

  /**
   * 
   * @param flightID
   */
  public void removeFlight(int flightID) {

  }

  // Editors for hotels/flights (?)
}