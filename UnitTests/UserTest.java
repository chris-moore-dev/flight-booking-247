import java.util.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.junit.jupiter.api.*;

/**
 * Class to test User functions
 * Not all functions tested, as none of the extra filters were used in build submitted for class
 * @author Lyn Cork
 */
public class UserTest {
  User user = new User();
  private DateTimeFormatter format = DateTimeFormatter.ofPattern("MM/dd/yyyy");
  private FlightList flightList = FlightList.getInstance();
  private HotelList hotelList = HotelList.getInstance();
  private ArrayList<Flight> flights = flightList.getFlights();
  private ArrayList<Hotel> hotels = hotelList.getHotels();

  
  @Test
  public void testGetFlights() {
    String sDate = "04/01/2022";
    LocalDate date = LocalDate.parse(sDate, format);
    String departingAirport = "CAE";
    String destAirport = "SEA";
    String takeOffTime = "5:17 AM";
    String landingTime = "12:48 PM";
    String totalFlightTime = "10h 31m";
    boolean layover = true;
    String company = "American Airlines";
    HashMap<String, Integer> pricing = new HashMap<>();
    pricing.put("First", 200);
    pricing.put("Main Cabin", 150);
    pricing.put("Economy", 125);
    String departingGate = "17";
    String destGate = "420";
    Map<String, Seating> seats = new HashMap<>();
    flights.add(new Flight(date, departingAirport, destAirport,
    takeOffTime, landingTime, totalFlightTime, layover, company, pricing,
    seats, departingGate, destGate));
    DataWriter.saveDatabase();
    String userDate = "04/01/2022";
    LocalDate departDate = LocalDate.parse(userDate, format);
    String userDepartAirport = "CAE";
    String userDestAirport = "SEA";
    ArrayList<Flight> list = user.getFlights(userDepartAirport, userDestAirport, departDate);
    Flight flight = list.get(0);
    String searchDepart = flight.getDepartingAirport();
    assertEquals(searchDepart, userDepartAirport);
  }

  @Test
  public void testGetFlightsLowerCase() {
    String sDate = "04/01/2022";
    LocalDate date = LocalDate.parse(sDate, format);
    String departingAirport = "CAE";
    String destAirport = "SEA";
    String takeOffTime = "5:17 AM";
    String landingTime = "12:48 PM";
    String totalFlightTime = "10h 31m";
    boolean layover = true;
    String company = "American Airlines";
    HashMap<String, Integer> pricing = new HashMap<>();
    pricing.put("First", 200);
    pricing.put("Main Cabin", 150);
    pricing.put("Economy", 125);
    String departingGate = "17";
    String destGate = "420";
    Map<String, Seating> seats = new HashMap<>();
    flights.add(new Flight(date, departingAirport, destAirport,
    takeOffTime, landingTime, totalFlightTime, layover, company, pricing,
    seats, departingGate, destGate));
    DataWriter.saveDatabase();
    String userDate = "04/01/2022";
    LocalDate departDate = LocalDate.parse(userDate, format);
    String userDepartAirport = "cae";
    String userDestAirport = "sea";
    ArrayList<Flight> list = user.getFlights(userDepartAirport, userDestAirport, departDate);
    Flight flight = list.get(0);
    String searchDepart = flight.getDepartingAirport();
    assertEquals(searchDepart, departingAirport);
  }

  @Test
  public void testGetFlightsNullDate() {
    String sDate = "04/01/2022";
    LocalDate date = LocalDate.parse(sDate, format);
    String departingAirport = "CAE";
    String destAirport = "SEA";
    String takeOffTime = "5:17 AM";
    String landingTime = "12:48 PM";
    String totalFlightTime = "10h 31m";
    boolean layover = true;
    String company = "American Airlines";
    HashMap<String, Integer> pricing = new HashMap<>();
    pricing.put("First", 200);
    pricing.put("Main Cabin", 150);
    pricing.put("Economy", 125);
    String departingGate = "17";
    String destGate = "420";
    Map<String, Seating> seats = new HashMap<>();
    flights.add(new Flight(date, departingAirport, destAirport,
    takeOffTime, landingTime, totalFlightTime, layover, company, pricing,
    seats, departingGate, destGate));
    DataWriter.saveDatabase();
    String userDepartAirport = "CAE";
    String userDestAirport = "SEA";
    ArrayList<Flight> list = user.getFlights(userDepartAirport, userDestAirport, null);
    Flight flight = list.get(0);
    String searchDepart = flight.getDepartingAirport();
    assertEquals(searchDepart, userDepartAirport);
  }

  @Test
  public void testGetFlightsNullDepart() {
    String sDate = "04/01/2022";
    LocalDate date = LocalDate.parse(sDate, format);
    String departingAirport = "CAE";
    String destAirport = "SEA";
    String takeOffTime = "5:17 AM";
    String landingTime = "12:48 PM";
    String totalFlightTime = "10h 31m";
    boolean layover = true;
    String company = "American Airlines";
    HashMap<String, Integer> pricing = new HashMap<>();
    pricing.put("First", 200);
    pricing.put("Main Cabin", 150);
    pricing.put("Economy", 125);
    String departingGate = "17";
    String destGate = "420";
    Map<String, Seating> seats = new HashMap<>();
    flights.add(new Flight(date, departingAirport, destAirport,
    takeOffTime, landingTime, totalFlightTime, layover, company, pricing,
    seats, departingGate, destGate));
    DataWriter.saveDatabase();
    String userDate = "04/01/2022";
    LocalDate departDate = LocalDate.parse(userDate, format);
    String userDestAirport = "SEA";
    ArrayList<Flight> list = user.getFlights(null, userDestAirport, departDate);
    Flight flight = list.get(0);
    String searchDest = flight.getDestAirport();
    assertEquals(searchDest, userDestAirport);
  }

  @Test
  public void testGetFlightsNullDest() {
    String sDate = "04/01/2022";
    LocalDate date = LocalDate.parse(sDate, format);
    String departingAirport = "CAE";
    String destAirport = "SEA";
    String takeOffTime = "5:17 AM";
    String landingTime = "12:48 PM";
    String totalFlightTime = "10h 31m";
    boolean layover = true;
    String company = "American Airlines";
    HashMap<String, Integer> pricing = new HashMap<>();
    pricing.put("First", 200);
    pricing.put("Main Cabin", 150);
    pricing.put("Economy", 125);
    String departingGate = "17";
    String destGate = "420";
    Map<String, Seating> seats = new HashMap<>();
    flights.add(new Flight(date, departingAirport, destAirport,
    takeOffTime, landingTime, totalFlightTime, layover, company, pricing,
    seats, departingGate, destGate));
    DataWriter.saveDatabase();
    String userDate = "04/01/2022";
    LocalDate departDate = LocalDate.parse(userDate, format);
    String userDepartAirport = "CAE";
    ArrayList<Flight> list = user.getFlights(userDepartAirport, null, departDate);
    Flight flight = list.get(0);
    String searchDepart = flight.getDepartingAirport();
    assertEquals(searchDepart, userDepartAirport);
  }

  @Test
  public void testGetHotelsByCity() {
    String address = "293 Crazy St, Seattle, WA 98101";
    ArrayList<Review> reviews = new ArrayList<>();
    ArrayList<String> amenities = new ArrayList<>();
    amenities.add("Cat Lounge");
    amenities.add("WiFi");
    amenities.add("Pool");
    amenities.add("Office");
    amenities.add("Free Breakfast");
    String closestAirport = "SEA";
    String city = "Seattle";
    String company = "Cat House";
    HashMap<String, Integer> pricing = new HashMap<>();
    pricing.put("Standard", 150);
    pricing.put("Upgraded", 200);
    HashMap<String, Room> rooms = new HashMap<>();
    hotels.add(new Hotel(address, reviews, amenities, closestAirport,
    city, company, pricing, rooms));
    DataWriter.saveDatabase();
    String userCity = "Seattle";
    ArrayList<Hotel> hotels = user.getHotelsByCity(userCity);
    Hotel hotel = hotels.get(0);
    String searchCity = hotel.getCity();
    assertEquals(searchCity, userCity);
  }

  @Test
  public void testGetHotelsByCityLowerCase() {
    String address = "293 Crazy St, Seattle, WA 98101";
    ArrayList<Review> reviews = new ArrayList<>();
    ArrayList<String> amenities = new ArrayList<>();
    amenities.add("Cat Lounge");
    amenities.add("WiFi");
    amenities.add("Pool");
    amenities.add("Office");
    amenities.add("Free Breakfast");
    String closestAirport = "SEA";
    String city = "Seattle";
    String company = "Cat House";
    HashMap<String, Integer> pricing = new HashMap<>();
    pricing.put("Standard", 150);
    pricing.put("Upgraded", 200);
    HashMap<String, Room> rooms = new HashMap<>();
    hotels.add(new Hotel(address, reviews, amenities, closestAirport,
    city, company, pricing, rooms));
    DataWriter.saveDatabase();
    String userCity = "seattle";
    ArrayList<Hotel> hotels = user.getHotelsByCity(userCity);
    Hotel hotel = hotels.get(0);
    String searchCity = hotel.getCity();
    assertEquals(searchCity, city);
  }


  @Test
  public void testGetHotelsByCityUpperCase() {
    String address = "293 Crazy St, Seattle, WA 98101";
    ArrayList<Review> reviews = new ArrayList<>();
    ArrayList<String> amenities = new ArrayList<>();
    amenities.add("Cat Lounge");
    amenities.add("WiFi");
    amenities.add("Pool");
    amenities.add("Office");
    amenities.add("Free Breakfast");
    String closestAirport = "SEA";
    String city = "Seattle";
    String company = "Cat House";
    HashMap<String, Integer> pricing = new HashMap<>();
    pricing.put("Standard", 150);
    pricing.put("Upgraded", 200);
    HashMap<String, Room> rooms = new HashMap<>();
    hotels.add(new Hotel(address, reviews, amenities, closestAirport,
    city, company, pricing, rooms));
    DataWriter.saveDatabase();
    String userCity = "SEATTLE";
    ArrayList<Hotel> hotels = user.getHotelsByCity(userCity);
    Hotel hotel = hotels.get(0);
    String searchCity = hotel.getCity();
    assertEquals(searchCity, city);
  }

  @Test
  public void testGetHotelsByCityExtraSpace() {
    String address = "293 Crazy St, Seattle, WA 98101";
    ArrayList<Review> reviews = new ArrayList<>();
    ArrayList<String> amenities = new ArrayList<>();
    amenities.add("Cat Lounge");
    amenities.add("WiFi");
    amenities.add("Pool");
    amenities.add("Office");
    amenities.add("Free Breakfast");
    String closestAirport = "SEA";
    String city = "Seattle";
    String company = "Cat House";
    HashMap<String, Integer> pricing = new HashMap<>();
    pricing.put("Standard", 150);
    pricing.put("Upgraded", 200);
    HashMap<String, Room> rooms = new HashMap<>();
    hotels.add(new Hotel(address, reviews, amenities, closestAirport,
    city, company, pricing, rooms));
    DataWriter.saveDatabase();
    String userCity = "Seattle ";
    ArrayList<Hotel> hotels = user.getHotelsByCity(userCity);
    Hotel hotel = hotels.get(0);
    String searchCity = hotel.getCity();
    assertEquals(searchCity, city);
  }
}
