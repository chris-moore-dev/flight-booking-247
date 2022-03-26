import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.UUID;

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
    super(company, pricing);
    setAddress(address);
    setReviews(reviews);
    setClosestAirport(closestAirport);
    setAmenities(amenities);
    setCity(city);
    setRooms(rooms);
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
    super(company, pricing, id);
    setAddress(address);
    setReviews(reviews);
    setClosestAirport(closestAirport);
    setAmenities(amenities);
    setCity(city);
    setRooms(rooms);
  }

  // Member Functions

  /**
   * 
   * @return
   */
  public String printRooms() {
    String ret;
  
    return ret;
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

  /**
   * 
   * @param review
   */
  public void addReview(Review review) {
    reviews.add(review);
  }

  /**
   * 
   * @param review
   */
  public void removeReview(Review review) {
    reviews.remove(review);
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
    if (rooms.isEmpty() || rooms == null)
      this.rooms = makeRooms();
    else
    this.rooms = rooms;
  }


  /**
   * Make random rooms to be added to the rooms hashmap.
   * Call this when first constrcuting a hotel, otherwise room
   * Hashmap will come from database
   * @return The hashmap with the rooms
   */
  private HashMap<String, Room> makeRooms() {
    HashMap<String, Room> ret = new HashMap<>();


    // Make standard rooms
    for (int i = 0; i < 45; i++) {
      Random r = new Random();

      Boolean smokingAllowed = r.nextBoolean();
      int numBeds = 2;
      Boolean booked = false;
      String type = "Standard";
      int price = pricing.get(type);
      String number = "S" + i;

      Room room = new Room(smokingAllowed, null, numBeds, booked, price, type, number);
      ret.put(number, room);
    }

    // Make upgraded rooms
    for (int i = 0; i < 45; i++) {
      Random r = new Random();

      Boolean smokingAllowed = r.nextBoolean();
      int numBeds = 3;
      Boolean booked = false;
      String type = "Upgraded";
      int price = pricing.get(type);
      String number = "U" + i;

      Room room = new Room(smokingAllowed, null, numBeds, booked, price, type, number);
      ret.put(number, room);
    }

    return ret;
  }
}
