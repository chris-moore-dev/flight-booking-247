import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map.Entry;

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
      if (depart.equalsIgnoreCase(departingAirport) && dest.equalsIgnoreCase(destAirport) && date.equals(departDate)) {
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
          flights.set(j, flightTwo);
          flights.set(j+1, flightOne);
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
          flights.set(j, flightTwo);
          flights.set(j+1, flightOne);
        }
      }
    }
  }

  /**
   * Takes an ArrayList of flights and sorts it from earliest landing time to latest landing time
   * @param flights the passed ArrayList of flights
   */
  public void filterFlightsByArrivalTimeEarlyLate(ArrayList<Flight> flights) {
    int n = flights.size();
    for(int i = 0; i < n-1; i++) {
      for(int j = 0; j < n-i-1; j++) {
        Flight flightOne = flights.get(j);
        Flight flightTwo = flights.get(j+1);
        String timeStrOne = flightOne.getLandingTime();
        String timeStrTwo = flightTwo.getLandingTime();
        if (timeStrOne.contains("AM") && timeStrOne.contains("PM")) {
          continue;
        }
        else if (timeStrOne.contains("PM") && timeStrTwo.contains("AM")) {
          flights.set(j, flightTwo);
          flights.set(j+1, flightOne);
        } else {
          timeStrOne = timeStrOne.replaceAll("[^0-9]", "");
          timeStrTwo = timeStrTwo.replaceAll("[^0-9]", "");
          int timeOne = Integer.parseInt(timeStrOne);
          int timeTwo = Integer.parseInt(timeStrTwo);
          if (timeOne > timeTwo) {
            flights.set(j, flightTwo);
            flights.set(j+1, flightOne);
          }
        }
      }
    }
  }

  /**
   * Takes an ArrayList of Flights and sorts it from latest landing time to earliest
   * @param flights the passed ArrayList of flights
   */
  public void filterFlightsByArrivalTimeLateEarly(ArrayList<Flight> flights) {
    int n = flights.size();
    for(int i = 0; i < n-1; i++) {
      for(int j = 0; j < n-i-1; j++) {
        Flight flightOne = flights.get(j);
        Flight flightTwo = flights.get(j+1);
        String timeStrOne = flightOne.getLandingTime();
        String timeStrTwo = flightTwo.getLandingTime();
        if (timeStrOne.contains("PM") && timeStrOne.contains("AM")) {
          continue;
        }
        else if (timeStrOne.contains("AM") && timeStrTwo.contains("PM")) {
          flights.set(j, flightTwo);
          flights.set(j+1, flightOne);
        } else {
          timeStrOne = timeStrOne.replaceAll("[^0-9]", "");
          timeStrTwo = timeStrTwo.replaceAll("[^0-9]", "");
          int timeOne = Integer.parseInt(timeStrOne);
          int timeTwo = Integer.parseInt(timeStrTwo);
          if (timeOne < timeTwo) {
            flights.set(j, flightTwo);
            flights.set(j+1, flightOne);
          }
        }
      }
    }
  }

  /**
   * Takes an ArrayList of flights and sorts it from earliest departure time to latest departure time
   * @param flights passed ArrayList of flights
   */
  public void filterFlightsByDepartingTimeEarlyLate(ArrayList<Flight> flights) {
    int n = flights.size();
    for(int i = 0; i < n-1; i++) {
      for(int j = 0; j < n-i-1; j++) {
        Flight flightOne = flights.get(j);
        Flight flightTwo = flights.get(j+1);
        String timeStrOne = flightOne.getTakeOffTime();
        String timeStrTwo = flightTwo.getTakeOffTime();
        if (timeStrOne.contains("AM") && timeStrOne.contains("PM")) {
          continue;
        }
        else if (timeStrOne.contains("PM") && timeStrTwo.contains("AM")) {
          flights.set(j, flightTwo);
          flights.set(j+1, flightOne);
        } else {
          timeStrOne = timeStrOne.replaceAll("[^0-9]", "");
          timeStrTwo = timeStrTwo.replaceAll("[^0-9]", "");
          int timeOne = Integer.parseInt(timeStrOne);
          int timeTwo = Integer.parseInt(timeStrTwo);
          if (timeOne > timeTwo) {
            flights.set(j, flightTwo);
            flights.set(j+1, flightOne);
          }
        }
      }
    }
  }

  /**
   * Takes an ArrayList of flights and sorts it from latest departure time to earliest
   * @param flights the passed ArrayList of flights
   */
  public void filterFlightsByDepartingTimeLateEarly(ArrayList<Flight> flights) {
    int n = flights.size();
    for(int i = 0; i < n-1; i++) {
      for(int j = 0; j < n-i-1; j++) {
        Flight flightOne = flights.get(j);
        Flight flightTwo = flights.get(j+1);
        String timeStrOne = flightOne.getTakeOffTime();
        String timeStrTwo = flightTwo.getTakeOffTime();
        if (timeStrOne.contains("PM") && timeStrOne.contains("AM")) {
          continue;
        }
        else if (timeStrOne.contains("AM") && timeStrTwo.contains("PM")) {
          flights.set(j, flightTwo);
          flights.set(j+1, flightOne);
        } else {
          timeStrOne = timeStrOne.replaceAll("[^0-9]", "");
          timeStrTwo = timeStrTwo.replaceAll("[^0-9]", "");
          int timeOne = Integer.parseInt(timeStrOne);
          int timeTwo = Integer.parseInt(timeStrTwo);
          if (timeOne < timeTwo) {
            flights.set(j, flightTwo);
            flights.set(j+1, flightOne);
          }
        }
      }
    }
  }

  /**
   * Takes an ArrayList of flights and sorts it from least to greatest total flight time
   * @param flights passed Arraylist of flights
   */
  public void filterFlightsByTotalFlightTime(ArrayList<Flight> flights) {
    int n = flights.size();
    for(int i = 0; i < n-1; i++) {
      for(int j = 0; j < n-i-1; j++) {
        Flight flightOne = flights.get(j);
        Flight flightTwo = flights.get(j+1);
        String timeStrOne = flightOne.getTotalFlightTime();
        timeStrOne = timeStrOne.replaceAll("[^0-9]", "");
        String timeStrTwo = flightTwo.getTotalFlightTime();
        timeStrTwo = timeStrTwo.replaceAll("[^0-9]", "");
        int timeOne = Integer.parseInt(timeStrOne);
        int timeTwo = Integer.parseInt(timeStrTwo);
        if (timeOne > timeTwo) {
          flights.set(j, flightTwo);
          flights.set(j+1, flightOne);
        }
      }
    }
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
          hotels.set(j, hotelTwo);
          hotels.set(j+1, hotelOne);
        }
      }
    }
  }

  /**
   * Returns an ArrayList of hotels that match a passed closest airport
   * @param closestAirport the passed airport
   * @return ArrayList of hotels
   */
  public ArrayList<Hotel> getHotelsByAirport(String closestAirport) {
    HotelList hotelList = HotelList.getInstance();
    ArrayList<Hotel> hotels = hotelList.getHotels();
    ArrayList<Hotel> ret = new ArrayList<Hotel>();
    for (int i = 0; i < hotels.size(); i++) {
      Hotel hotel = hotels.get(i);
      String airport = hotel.getClosestAirport();
      if (airport == closestAirport) {
        ret.add(hotel);
      }
    }
    return ret;
  }

  /**
   * Returns an ArrayList of hotels that match a passed city
   * @param city the passed city
   * @return ArrayList of hotels
   */
  public ArrayList<Hotel> getHotelsByCity(String city) {
    HotelList hotelList = HotelList.getInstance();
    ArrayList<Hotel> hotels = hotelList.getHotels();
    ArrayList<Hotel> ret = new ArrayList<Hotel>();
    for (int i = 0; i < hotels.size(); i++) {
      Hotel hotel = hotels.get(i);
      String searchCity = hotel.getCity();
      if (searchCity == city) {
        ret.add(hotel);
      }
    }
    return ret;
  }

  /**
   * Returns an ArrayList of hotels that match a passed airport and name
   * @param closestAirport the passed airport
   * @param name name of the hotel
   * @return ArrayList of hotels
   */
  public ArrayList<Hotel> getHotels(String closestAirport, String name) {
    HotelList hotelList = HotelList.getInstance();
    ArrayList<Hotel> hotels = hotelList.getHotels();
    ArrayList<Hotel> ret = new ArrayList<Hotel>();
    for (int i = 0; i < hotels.size(); i++) {
      Hotel hotel = hotels.get(i);
      String airport = hotel.getClosestAirport();
      String searchName = hotel.getCompany();
      if (airport == closestAirport && name == searchName) {
        ret.add(hotel);
      }
    }
    return ret;
  }

  /**
   * Takes an ArrayList of hotels and an airport, and filters ArrayList to only hotels with that closest airport
   * @param hotels passed ArrayList of hotels
   * @param closestAirport passed airport
   */
  public void filterHotelsByClosenessToAirport(ArrayList<Hotel> hotels, String closestAirport) {
    ArrayList<Hotel> temp = new ArrayList<Hotel>();
    for (int i = 0; i < hotels.size(); i++) {
      Hotel hotel = hotels.get(i);
      String airport = hotel.getClosestAirport();
      if (airport == closestAirport) {
        temp.add(hotel);
      }
    }
    hotels = temp;
  }

  /**
   * Takes an ArrayList of hotels and an ArrayList of amenities, and filters ArrayList to only hotels with those amenities
   * @param amenities passed ArrayList of amenitites
   * @param hotels passed ArrayList of hotels
   */
  public void filterHotelsByAmmenities(ArrayList<String> amenities, ArrayList<Hotel> hotels) {
    ArrayList<Hotel> temp = new ArrayList<Hotel>();
    for (int i = 0; i < hotels.size(); i++) {
      Hotel hotel = hotels.get(i);
      ArrayList<String> amenity = hotel.getAmenities();
      if (amenity.containsAll(amenities)) {
        temp.add(hotel);
      }
    }
    hotels = temp;
  }

  /**
   * Sorts passed hotel ArrayList from least to greatest average price
   * @param hotels arraylist of hotels
   */
  public void filterHotelsByPrice(ArrayList<Hotel> hotels) {
    int n = hotels.size();
    int averageOne = 0;
    int averageTwo = 0;
    for(int i = 0; i < n-1; i++) {
      for(int j = 0; j < n-i-1; j++) {
        Hotel hotelOne = hotels.get(j);
        for (Entry<String, Integer> entry : hotelOne.getPricing().entrySet()) {
          averageOne += entry.getValue();
        }
        Hotel hotelTwo = hotels.get(j+1);
        for (Entry<String, Integer> entry : hotelTwo.getPricing().entrySet()) {
          averageTwo += entry.getValue();
        }
        if (averageOne > averageTwo) {
          hotels.set(j, hotelTwo);
          hotels.set(j+1, hotelOne);
        }
      }
    }
  }
}
