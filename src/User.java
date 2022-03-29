import java.time.LocalDate;
import java.util.ArrayList;

/**
 * User class
 * @author Chris Moore, Lyn Cork
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
   * Arranges passed flight list from least to greatest price
   * @param flights flight list
   */
  public void filterFlightsByPrice(ArrayList<Flight> flights) {
    int n = flights.size();
    for(int i = 0; i < n-1; i++) {
      for(int j = 0; j < n-i-1; j++) {
        Flight flightOne = flights.get(j);
        Flight flightTwo = flights.get(j+1);
        int priceOne = flightOne.getPrice("Economy");
        int priceTwo = flightTwo.getPrice("Economy");
        if (priceOne > priceTwo) {
          flights.add(j, flightTwo);
          flights.add(j+1, flightOne);
        }
      }
    }
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
   * Filters flight list to only flights by passed airline
   * @param airline desired airline
   * @param flights flight list
   */
  public void filterFlightsByAirline(String airline, ArrayList<Flight> flights) {
    ArrayList<Flight> temp = new ArrayList<Flight>();
    for (int i = 0; i < flights.size(); i++) {
      Flight flight = flights.get(i);
      String company = flight.getCompany();
      if (company == airline) {
        temp.add(flight);
      }
    }
    flights = temp;
  }


  /**
   * Arranges hotel list from least to greatest average rating
   * @param hotels hotel list
   */
  public void filterHotelsByRating(ArrayList<Hotel> hotels) {
    int n = hotels.size();
    int totalOne = 0;
    int totalTwo = 0;
    for(int i = 0; i < n-1; i++) {
      for(int j = 0; j < n-i-1; j++) {
        Hotel hotelOne = hotels.get(j);
        Hotel hotelTwo = hotels.get(j+1);
        ArrayList<Review> reviewsOne = hotelOne.getReviews();
        for(i = 0; i < reviewsOne.size(); i++) {
          Review temp = reviewsOne.get(i);
          totalOne += temp.getRating() ;
        }
        int averageOne = totalOne/reviewsOne.size();
        ArrayList<Review> reviewsTwo = hotelTwo.getReviews();
        for(i = 0; i < reviewsTwo.size(); i++) {
          Review temp = reviewsTwo.get(i);
          totalTwo += temp.getRating() ;
        }
        int averageTwo = totalTwo/reviewsTwo.size();
        if (averageOne > averageTwo) {
          hotels.add(j, hotelTwo);
          hotels.add(j+1, hotelOne);
        }
      }
    }
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
