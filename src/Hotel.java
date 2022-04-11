import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;

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
    String ret = "";
    String amenityList = "";
    Integer averagePrice = 0;
    int total = 0;
    int averageRating = 0;
    for (Map.Entry<String, Integer> entry : pricing.entrySet()) {
      averagePrice += entry.getValue();
    }
    averagePrice = averagePrice/pricing.size();
    for(int i = 0; i < reviews.size(); i++) {
      Review temp = reviews.get(i);
      total += temp.getRating();
    }
    // averageRating = total/reviews.size();
    /**
     * FAKING RATING FOR UNTIL WE GET SOME MORE REVIEWS ADDED
     */
    Random r = new Random();
    averageRating = r.nextInt(3) + 3;
    int stop = amenities.size();
    for (String amenity : amenities) {
      if (stop != 1)
        amenityList += amenity+", ";
      else
      amenityList += amenity;

      stop--;
    }
    ret = company + "\nAverage Price per Night: $" + averagePrice + "\nRating: " + averageRating + "/5" + "\nAmenities: " + amenityList;
    return ret;
  }

  public Room getMatchingRoom(LocalDate checkInDate, LocalDate checkOutDate, String roomType) {
    ArrayList<LocalDate> bookDays = getConsecutiveDates(checkInDate, checkOutDate);
    for (Room room : rooms.values()) {
      if (!(room.getType().equalsIgnoreCase(roomType))) continue;

      ArrayList<LocalDate> bookedDates = room.getBookedDays();
      for (LocalDate date : bookDays) {
        if (bookedDates.contains(date)) continue;

      }

      return room;
    }
    return null;
  }

  /**
     * Given 2 dates, find all the dates between those days
     * @param date1
     * @param date2
     * @return
     */
    public ArrayList<LocalDate> getConsecutiveDates(LocalDate date1,
    LocalDate date2) {
      List<LocalDate> listOfDates = date1.datesUntil(date2)
		  .collect(Collectors.toList());

      LocalDate[] pre = new LocalDate[listOfDates.size()];
      pre = listOfDates.toArray(pre);

      ArrayList<LocalDate> ret = new ArrayList<>();

      for (LocalDate addDate : pre) {
          ret.add(addDate);
      }

      return ret;
    }

  /**
   * Sets booked room to booked
   * @param roomNum
   * @param dates The dates to book
   */
  public void book(String roomNum, ArrayList<LocalDate> dates) {
    Room room = rooms.get(roomNum);
    room.book(dates);
  }

  /**
   * Sets unbooked room to unbooked
   * @param roomNum
   * @param dates The dates to unbook
   */
  public void unBook(String roomNum, ArrayList<LocalDate> dates) {
    Room room = rooms.get(roomNum);
    room.unBook(dates);
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
