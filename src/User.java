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
   * Takes a departing airport, a destination, and the date of departure. Returns an arraylist of flights that meet these parameters.
   * @param departingAirport the airport where the plane leaves from
   * @param destAirport the destination
   * @param departDate the day on which the flight is leaving
   * @return
   */
  public ArrayList<Flight> getFlights(String departingAirport, String destAirport, LocalDate departDate) {
    FlightList flightList = FlightList.getInstance();
    ArrayList<Flight> flights = flightList.getFlights();
    ArrayList<Flight> ret = new ArrayList<Flight>();
    for (int i = 0; i < flights.size(); i++) {
      Flight flight = flights.get(i);
      String depart = flight.getDepartingAirport();
      String dest = flight.getDestAirport();
      LocalDate date = flight.getDate();
      if (depart == departingAirport && dest == destAirport && date == departDate) {
        ret.add(flight);
      }
    }
    return ret;
  }


  /**
   * 
   * @param flights
   */
  public void filterFlightsByPrice(ArrayList<Flight> flights) {

  }

  /**
   * Sorts passed flight array list from least to greatest number of layovers
   * @param flights arraylist of flights
   */
  public void filterFlightsByNumberOfLayovers(ArrayList<Flight> flights) {
    int n = flights.size();
    for(int i = 0; i < n-1; i++) {
      for(int j = 0; j < n-i-1; j++) {
        Flight flightOne = flights.get(j);
        Flight flightTwo = flights.get(j+1);
        int stopsOne = flightOne.getNumStops();
        int stopsTwo = flightTwo.getNumStops();
        if (stopsOne > stopsTwo) {
          flights.add(j, flightTwo);
          flights.add(j+1, flightOne);
        }
      }
    }
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
  public void filterFlightsByArrivalTimeLateEarly(ArrayList<Flight> flights) {

  }

  /**
   * 
   * @param flights
   */
  public void filterFlightsByDepartingTimeEarlyLate(ArrayList<Flight> flights) {

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
  public ArrayList<Hotel> getHotelsByAirport(String closestAirport) {
    
  }

  /**
   * 
   * @param city
   * @return
   */
  public ArrayList<Hotel> getHotelsByCity(String city) {

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
