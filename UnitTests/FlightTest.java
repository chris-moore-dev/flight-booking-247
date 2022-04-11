import java.util.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.junit.jupiter.api.*;

/**
 * Class to test Flight functions
 * @author Lyn Cork
 */
public class FlightTest {
  private DateTimeFormatter format = DateTimeFormatter.ofPattern("MM/dd/yyyy");
  private FlightList flightList = FlightList.getInstance();
  private ArrayList<Flight> flights = flightList.getFlights();
  private ArrayList<Flight> secondaryFlights = new ArrayList<Flight>();
  
  @Test
  public void testDiscountLayoverPrice() {
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
    Flight secondFlight = new Flight(date, departingAirport, destAirport,
    takeOffTime, landingTime, totalFlightTime, layover, company, pricing,
    seats, departingGate, destGate);
    secondaryFlights.add(secondFlight);
    flights.add(new Flight(date, departingAirport, destAirport,
    takeOffTime, landingTime, totalFlightTime, layover, secondaryFlights, 1, 0.8, company));
    DataWriter.saveDatabase();
    Flight flight = flights.get(0);
    ArrayList<Flight>flightArray = flight.getFlights();
    HashMap<String, Integer> priceMap = flight.discountLayoverPrice(flightArray, flight.getDiscountPercent());
    int price = priceMap.get("First");
    int expected = (int) Math.round(200 * 0.8);
    assertEquals(expected, price);
  }

  @Test
  public void testDiscountLayoverPriceZero() {
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
    Flight secondFlight = new Flight(date, departingAirport, destAirport,
    takeOffTime, landingTime, totalFlightTime, layover, company, pricing,
    seats, departingGate, destGate);
    secondaryFlights.add(secondFlight);
    flights.add(new Flight(date, departingAirport, destAirport,
    takeOffTime, landingTime, totalFlightTime, layover, secondaryFlights, 1, 0, company));
    DataWriter.saveDatabase();
    Flight flight = flights.get(0);
    ArrayList<Flight>flightArray = flight.getFlights();
    HashMap<String, Integer> priceMap = flight.discountLayoverPrice(flightArray, flight.getDiscountPercent());
    int price = priceMap.get("First");
    int expected = (int) Math.round(200 * 0);
    assertEquals(expected, price);
  }

  @Test
  public void testBook() {
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
    Flight flight = flights.get(0);
    seats = flight.makeSeats();
    flight.setSeats(seats);
    flight.book("A30");
    Seating seat = seats.get("A30");
    boolean booked = seat.getBooked();
    assertEquals(true, booked);
  }

  @Test
  public void testUnbook() {
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
    Flight flight = flights.get(0);
    seats = flight.makeSeats();
    flight.setSeats(seats);
    flight.book("A30");
    flight.unBook("A30");
    Seating seat = seats.get("A30");
    boolean booked = seat.getBooked();
    assertEquals(false, booked);
  }
}
