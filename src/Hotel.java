import java.util.ArrayList;
import java.util.HashMap;

/**
 * Hotel class
 * @author Chris Moore
 */
public class Hotel extends ObjectToBeBooked {
  private String address;
  private ArrayList<Review> reviews;
  private ArrayList<String> amenities;
  private String closestAirport;
  private String city;
  private HashMap<String, Room> rooms;

  /**
   * 
   * @param address
   * @param reviews
   * @param amenities
   * @param closestAirport
   * @param city
   * @param company
   * @param pricing
   * @param rooms
   */
  Hotel(String address, ArrayList<Review> reviews, ArrayList<String> amenities,
  String closestAirport, String city, String company, HashMap<String, Integer> pricing,
  HashMap<String, Room> rooms) {
    //super()
  }

  /**
   * 
   * @param address
   * @param reviews
   * @param amenities
   * @param closestAirport
   * @param city
   * @param company
   * @param pricing
   * @param rooms
   * @param id
   */
  Hotel(String address, ArrayList<Review> reviews, ArrayList<String> amenities,
  String closestAirport, String city, String company, HashMap<String, Integer> pricing,
  HashMap<String, Room> rooms, UUID id) {
    // super()
  }

  // Member Functions

  /**
   * 
   * @return
   */
  public String printRooms() {

  }

  /**
   * 
   * @return
   */
  @Override
  public String toString() {

  }

  /**
   * 
   * @param roomNum
   */
  public void book(String roomNum) {

  }

  /**
   * 
   * @param roomNum
   */
  public void unBook(String roomNum) {

  }

  // GETTERS

  /**
   * 
   * @return
   */
  public String getAddress() {
    return this.address;
  }

  /**
   *
   * @return
   */
  public ArrayList<Review> getReviews() {
    return this.reviews;
  }

  /**
   * 
   * @return
   */
  public ArrayList<String> getAmenities() {
    return this.amenities;
  }

  /**
   * 
   * @return
   */
  public String getClosestAirport() {
    return this.closestAirport;
  }

  /**
   * 
   * @return
   */
  public String getCity() {
    return this.city;
  }

  /**
   * 
   * @return
   */
  public HashMap<String, Room> getRooms() {
    return this.rooms;
  }

  // SETTERS

  /**
   * 
   * @param address
   */
  public void setAddress(String address) {
    this.address = address;
  }

  /**
   * 
   * @param reviews
   */
  public void setReviews(ArrayList<Review> reviews) {
    this.reviews = reviews;
  }

  /**
   * 
   * @param amenities
   */
  public void setAmenities(ArrayList<String> amenities) {
    this.amenities = amenities;
  }

  /**
   * 
   * @param airport
   */
  public void setClosestAirport(String airport) {
    this.closestAirport = airport;
  }

  /**
   * 
   * @param city
   */
  public void setCity(String city) {
    this.city = city;
  }

  public void setRooms(HashMap<String, Room> rooms) {
    this.rooms = rooms;
  }
}
