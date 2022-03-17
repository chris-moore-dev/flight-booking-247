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

  /**
   * Default constructor
   * @param address
   * @param reviews
   * @param amenities
   * @param closestAirport
   * @param city
   */
  Hotel(String address, ArrayList<Review> reviews, ArrayList<String> amenities, String closestAirport, String city) {
    //super()
  }

  /**
   * 
   */
  public void printIndividualBookings() {

  }

  /**
   * 
   */
  public void printPrices() {
    
  }

  // GETTERS

  /**
   * 
   * @param hotel
   * @return
   */
  public String getAddress(Hotel hotel) {
    return this.address;
  }

  /**
   * 
   * @param hotel
   * @return
   */
  public ArrayList<Review> getReviews(Hotel hotel) {
    return this.reviews;
  }

  /**
   * 
   * @param hotel
   * @return
   */
  public ArrayList<String> getAmenities(Hotel hotel) {
    return this.amenities;
  }

  /**
   * 
   * @param hotel
   * @return
   */
  public String getClosestAirport(Hotel hotel) {
    return this.closestAirport;
  }

  /**
   * 
   * @param hotel
   * @return
   */
  public String getCity(Hotel hotel) {
    return this.city;
  }

  // SETTERS

  /**
   * 
   * @param hotel
   * @return
   */
  public String setAddress(Hotel hotel) {
    return this.address;
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
}
