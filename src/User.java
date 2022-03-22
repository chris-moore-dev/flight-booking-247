import java.time.LocalDate;
import java.util.ArrayList;

/**
 * User class
 * @author Chris Moore
 */
public class User {
  /**
   * Default constructor
   */
  User() {
    
  }

  /**
   * 
   * @param departingAirport
   * @param destAirport
   * @param departDate
   * @return
   */
  public ArrayList<Flight> getFlights(String departingAirport, String destAirport, LocalDate departDate) {
    
  }


  /**
   * 
   * @param flights
   */
  public void filterFlightsByPrice(ArrayList<Flight> flights) {

  }

  /**
   * 
   * @param flights
   */
  public void filterFlightsByNumberOfLayovers(ArrayList<Flight> flights) {

  }

  /**
   * 
   * @param flights
   */
  public void filterFlightsByArrivalTimeEarlyLate(ArrayList<Flight> flights) {

  }

  /**
   * 
   * @param flights
   */
  public void  filterFlightsByArrivalTimeLateEarly(ArrayList<Flight> flights) {

  }

  /**
   * 
   * @param flights
   */
  public void  filterFlightsByDepartingTimeEarlyLate(ArrayList<Flight> flights) {

  }

  /**
   * 
   * @param flights
   */
  public void filterFlightsByDepartingTimeLateEarly(ArrayList<Flight> flights) {

  }

  /**
   * 
   * @param flights
   */
  public void filterFlightsByTotalFlightTime(ArrayList<Flight> flights) {

  }

  /**
   * 
   * @param airline
   * @param flights
   */
  public void filterFlightsByAirline(String airline, ArrayList<Flight> flights) {

  }


  /**
   * 
   * @param hotels
   */
  public void filterHotelsByRating(ArrayList<Hotel> hotels) {

  }

  /**
   * 
   * @param closestAirport
   * @return
   */
  public ArrayList<Hotel> getHotels(String closestAirport) {

  }

  /**
   * 
   * @param closestAirport
   * @param name
   * @return
   */
  public ArrayList<Hotel> getHotels(String closestAirport, String name) {

  }

  /**
   * 
   * @param hotels
   */
  public void filterHotelsByClosenessToAirport(ArrayList<Hotel> hotels) {
    
  }

  /**
   * 
   * @param ammenities
   * @param hotels
   */
  public void filterHotelsByAmmenities(ArrayList<String> ammenities, ArrayList<Hotel> hotels) {

  }

  /**
   * 
   * @param hotels
   */
  public void filterHotelsByPrice(ArrayList<Hotel> hotels) {
  }
}
