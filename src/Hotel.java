import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

/**
 * Hotel class
 * @author Chris Moore, Lyn Cork
 */
public class Hotel extends ObjectToBeBooked {
  private String address;
  private ArrayList<Review> reviews;
  private ArrayList<String> amenities;
  private String closestAirport;
  private String city;
  private HashMap<String, Room> rooms;

  /**
   * Constructor
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
   * Constructor
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
   * Use to print when choosing room type.
   * Will print the room type and its price
   * @param roomType The room type
   * @return String holding all 
   */
  public String printRoomPrice(String roomType) {
    String ret = roomType + "\t" + "Price per night: $" + getPrice(roomType);
    return ret;
  }

  /**
   * Converts Hotel object into printable string
   * @return
   */
  @Override
  public String toString() {
    String ret = "\n";
    String amenityList = "";
    Integer averagePrice = 0;
    for (Map.Entry<String, Integer> entry : pricing.entrySet()) {
      averagePrice += entry.getValue();
    }
    averagePrice = averagePrice/pricing.size();

    for (String amenity : amenities) {
      amenityList += amenity+", ";
    }
    ret = company + "Average Price per Night: $" + averagePrice + "\nAddress: " + address + "\nAmenities: " + amenityList;
    return ret;
  }

  /**
   * Sets booked room to booked
   * @param roomNum
   */
  public void book(String roomNum) {
    Room room = rooms.get(roomNum);
    room.setBooked(true);
    rooms.put(roomNum, room);
  }

  /**
   * Sets unbooked room to unbooked
   * @param roomNum
   */
  public void unBook(String roomNum) {
    Room room = rooms.get(roomNum);
    room.setBooked(false);
    rooms.put(roomNum, room);
  }

  /**
   * Adds a review to Hotel
   * @param review
   */
  public void addReview(Review review) {
    reviews.add(review);
  }

  /**
   * Remvoes a review from the Hotel
   * @param review
   */
  public void removeReview(Review review) {
    reviews.remove(review);
  }

  // GETTERS

  /**
   * Gets the address
   * @return address
   */
  public String getAddress() {
    return this.address;
  }

  /**
   * gets the list of reviews
   * @return list of reviews
   */
  public ArrayList<Review> getReviews() {
    return this.reviews;
  }

  /**
   * gets the list of amenities
   * @return list of amenities
   */
  public ArrayList<String> getAmenities() {
    return this.amenities;
  }

  /**
   * gets the closest airport
   * @return closest airport
   */
  public String getClosestAirport() {
    return this.closestAirport;
  }

  /**
   * gets the city
   * @return city
   */
  public String getCity() {
    return this.city;
  }

  /**
   * gets the list of rooms
   * @return list of rooms
   */
  public HashMap<String, Room> getRooms() {
    return this.rooms;
  }

  // SETTERS

  /**
   * sets the address
   * @param address address
   */
  public void setAddress(String address) {
    this.address = address;
  }

  /**
   * sets the reviews to a list of reviews
   * @param reviews a list of reviews
   */
  public void setReviews(ArrayList<Review> reviews) {
    this.reviews = reviews;
  }

  /**
   * sets the amenities to a list of amenities
   * @param amenities a list of amenities
   */
  public void setAmenities(ArrayList<String> amenities) {
    this.amenities = amenities;
  }

  /**
   * sets the closest airport to the airport passed
   * @param airport airport
   */
  public void setClosestAirport(String airport) {
    this.closestAirport = airport;
  }

  /**
   * sets the city to the city passed
   * @param city city
   */
  public void setCity(String city) {
    this.city = city;
  }

  /**
   * Sets rooms to a list of rooms passed
   * @param rooms list of rooms
   */
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
