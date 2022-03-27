/**
 * Flight
 * @author Chris Moore, Evan Scales
 */
import java.util.HashMap;
import java.util.UUID;
import java.time.LocalDate;
import java.util.ArrayList;
public class Flight extends ObjectToBeBooked {
  private LocalDate date;
  private String departingAirport;
  private String destAirport;
  private String takeOffTime;
  private String landingTime;
  private String totalFlightTime;
  private boolean layover;
  private ArrayList<Flight> flights;
  private int numStops;
  private double discountPercent;
  private HashMap<String, Seating> seats;
  private String departingGate;
  private String destGate;


  /**
   * Constructor to use when first making a flight
   * Use for normal flights
   * @param date The date of the flight
   * @param departingAirport The departing airport
   * @param destAirport The dest airport
   * @param takeOffTime The take off time
   * @param landingTime The landing time
   * @param totalFlightTime The total flight time
   * @param layover If the flight has a layover, always false
   * @param company The company
   * @param pricing The pricing hashmap
   * @param seats The seats hashmap
   * @param departingGate The departing gatew
   * @param destGate The arriving gate
   */
  Flight(LocalDate date, String departingAirport, String destAirport,
  String takeOffTime, String landingTime, String totalFlightTime,
  boolean layover, String company, HashMap<String, Integer> pricing,
  HashMap<String, Seating> seats, String departingGate, String destGate) {
    super(company, pricing);
    setIsLayover(layover);
    setDate(date);
    setDepartingAirport(departingAirport);
    setDestAirport(destAirport);
    setTakeOffTime(takeOffTime);
    setLandingTime(landingTime);
    setTotalFlightTime(totalFlightTime);
    setSeats(seats);
    setDapartingGate(departingGate);
    setDestGate(destGate);
  }

  /**
   * Constructor to use when loading flights from database
   * Use for normal Flights
   * @param date The date oif the flight
   * @param departingAirport The departing airport
   * @param destAirport The dest airport
   * @param takeOffTime The take off time
   * @param landingTime The landing time
   * @param totalFlightTime The total time
   * @param layover If the flight has a layover, always false
   * @param company The company
   * @param pricing The pricing hashmap
   * @param seats The seats hashmap
   * @param id The id
   * @param departingGate The departing gate
   * @param destGate The arriving gate
   */
  Flight(LocalDate date, String departingAirport, String destAirport,
  String takeOffTime, String landingTime, String totalFlightTime,
  boolean layover, String company, HashMap<String, Integer> pricing,
  HashMap<String, Seating> seats, UUID id, String departingGate, String destGate) {
    super(company, pricing, id);
    setIsLayover(layover);
    setDate(date);
    setDepartingAirport(departingAirport);
    setDestAirport(destAirport);
    setTakeOffTime(takeOffTime);
    setLandingTime(landingTime);
    setTotalFlightTime(totalFlightTime);
    setSeats(seats);
    setDapartingGate(departingGate);
    setDestGate(destGate);
  }

  /**
   * 
   * @param date
   * @param departingAirport
   * @param destAirport
   * @param takeOffTime
   * @param landingTime
   * @param totalFlightTime
   * @param layover
   * @param flights
   * @param numStops
   * @param discountPercent
   * @param company
   */
  Flight(LocalDate date, String departingAirport, String destAirport, String takeOffTime,
  String landingTime, String totalFlightTime, Boolean layover, ArrayList<Flight> flights,
  int numStops, double discountPercent, String company) {
    super(company, null);
    HashMap<String, Integer> pricing = discountLayoverPrice(flights, discountPercent);
    setPricingMap(pricing);
    setDate(date);
    setDepartingAirport(departingAirport);
    setDestAirport(destAirport);
    setTakeOffTime(takeOffTime);
    setLandingTime(landingTime);
    setTotalFlightTime(totalFlightTime);
    setIsLayover(layover);
    setFlights(flights);
    setNumStops(numStops);
    setDiscountPercent(discountPercent);
  }

  /**
   * 
   * @param date
   * @param departingAirport
   * @param destAirport
   * @param takeOffTime
   * @param landingTime
   * @param totalFlightTime
   * @param layover
   * @param flights
   * @param numStops
   * @param discountPercent
   * @param id
   * @param company
   */
  Flight(LocalDate date, String departingAirport, String destAirport, String takeOffTime,
  String landingTime, String totalFlightTime, Boolean layover, ArrayList<Flight> flights,
  int numStops, double discountPercent, UUID id, String company) {
    super(company, null, id);
    HashMap<String, Integer> pricing = discountLayoverPrice(flights, discountPercent);
    setPricingMap(pricing);
    setDate(date);
    setDepartingAirport(departingAirport);
    setDestAirport(destAirport);
    setTakeOffTime(takeOffTime);
    setLandingTime(landingTime);
    setTotalFlightTime(totalFlightTime);
    setIsLayover(layover);
    setFlights(flights);
    setNumStops(numStops);
    setDiscountPercent(discountPercent);
  }

  // Member functions

  /**
   * Sets the new pricing hashmap for flights with layovers
   * To find the pricing of a flight with layover add up each corresponding cabin price
   * for each connecting flight. Then discount that by 20% to get the new pricing map
   * @param flights The connecitng flights
   * @param discountPercent The discount number (0.8)
   * @return The new pricing map
   */
  private HashMap<String, Integer> discountLayoverPrice(ArrayList<Flight> flights, double discountPercent) {
    HashMap<String, Integer> ret = new HashMap<>();

    for (Flight flight : flights) {
      HashMap<String, Integer> pricingMap = flight.getPricing();
      for (String key : pricingMap.keySet()) {
        int value = pricingMap.get(key);
        if (ret.containsKey(key)) {
          ret.put(key, ret.get(key) + value);
        } else {
          ret.put(key, value);
        }
      }
    }

    for (String key : ret.keySet()) {
      int value = (int) Math.round(ret.get(key) * discountPercent);
      ret.put(key, value);
    }

    return ret;
  }

  /**
   * 
   * @param seatNum
   */
  public void book(String seatNum) {

  }

  /**
   * 
   * @param seatNum
   */
  public void unBook(String seatNum) {

  }

  /**
   * 
   */
  public String printSeats() {

  }

  /**
   * 
   */
  @Override
  public String toString() {
    return "Example";
  }


  // GETTERS

  /**
   * 
   * @return
   */
  public LocalDate getDate() {
    return this.date;
  }

  /**
   * 
   * @return
   */
  public String getDepartingAirport() {
    return this.departingAirport;
  }

  /**
   * 
   * @return
   */
  public String getDestAirport() {
    return this.destAirport;
  }

  /**
   *
   * @return
   */
  public String getTakeOffTime() {
    return this.takeOffTime;
  }

  /**
   * 
   * @return
   */
  public String getLandingTime() {
    return this.landingTime;
  }

  /**
   * 
   * @return
   */
  public String getTotalFlightTime() {
    return this.totalFlightTime;
  }

  /**
   * 
   * @return
   */
  public boolean getIsLayover() {
    return this.layover;
  }

  /**
   * 
   * @return
   */
  public ArrayList<Flight> getFlights() {
    return this.flights;
  }

  /**
   * 
   * @return
   */
  public int getNumStops() {
    return this.numStops;
  }

  /**
   * 
   * @return
   */
  public double getDiscountPercent() {
    return this.discountPercent;
  }

  /**
   * 
   * @return
   */
  public HashMap<String, Seating> getSeating() {
    return this.seats;
  }

  /**
   * 
   * @return
   */
  public String getDepartingGate() {
    return this.departingGate;
  }

  /**
   * 
   * @return
   */
  public String getDestGate() {
    return this.destGate;
  }

  // SETTERS

  /**
   * 
   * @param date
   */
  public void setDate(LocalDate date) {
      this.date = date;
  }

  /**
   * 
   * @param departingAirport
   */
  public void setDepartingAirport(String departingAirport) {
    this.departingAirport = departingAirport;
  }

  /**
   * 
   * @param destAirport
   */
  public void setDestAirport(String destAirport) {
    this.destAirport = destAirport;
  }

  /**
   * 
   * @param takeOffTime
   */
  public void setTakeOffTime(String takeOffTime) {
    this.takeOffTime = takeOffTime;
  }

  /**
   * 
   * @param landingTime
   */
  public void setLandingTime(String landingTime) {
    this.landingTime = landingTime;
  }

  /**
   * 
   * @param totalFlightTime
   */
  public void setTotalFlightTime(String totalFlightTime) {
    this.totalFlightTime = totalFlightTime;
  }

  /**
   * 
   * @param layover
   */
  public void setIsLayover(boolean layover) {
    this.layover = layover;
  }

  /**
   * 
   * @param flights
   */
  public void setFlights(ArrayList<Flight> flights) {
    if (flights != null)
      this.flights = flights;
    else
      this.flights = new ArrayList<>();
  }

  /**
   * 
   * @param numStops
   */
  public void setNumStops(int numStops) {
    this.numStops = numStops;
  }

  /**
   * 
   * @param discountPercent
   */
  public void setDiscountPercent(double discountPercent) {
    this.discountPercent = discountPercent;
  }

  /**
   * 
   * @param seats
   */
  public void setSeats(HashMap<String, Seating> seats) {
    if (seats == null)
      this.seats = null;
    else if(seats.isEmpty())
      this.seats = makeSeats();
    else
      this.seats = seats;
  }

  /**
   * 
   * @param departingGate
   */
  public void setDapartingGate(String departingGate) {
    this.departingGate = departingGate;
  }

  /**
   * 
   * @param destGate
   */
  public void setDestGate(String destGate) {
    this.destGate = destGate;
  }

  private HashMap<String, Seating> makeSeats() {
    HashMap<String, Seating> ret = new HashMap<>();

    /**
     * Make 10 rows of First class seating
     * Make 13 Rows of Main Cabin Seating
     * Make 7 rows of Economy cabin seating 
     * First 2 columns are medical seats
     */

    // Make A row seating
    for (int i = 1; i < 31; i++) {
      String seatNum = "";

      Boolean medicalSeat;
      Boolean booked = false;
      int price;
      String type;
      seatNum = "A" + i;

      // First class seats
      if (i <= 10) {
        if (i <= 2) {
          medicalSeat = true;
        } else {
          medicalSeat = false;
        }

        type = "First";

      } else if (i >= 24) { // Economy seating
        medicalSeat = false;
        type = "Economy";
      } else { // Main cabin
        medicalSeat = false;
        type = "Main Cabin";
      }

      price = pricing.get(type);
      Seating seat = new Seating(medicalSeat, booked, price, type, seatNum);
      ret.put(seatNum, seat);

    }

    // Make B row seating
    for (int i = 1; i < 31; i++) {
      String seatNum = "";

      Boolean medicalSeat;
      Boolean booked = false;
      int price;
      String type;
      seatNum = "B" + i;

      // First class seats
      if (i <= 10) {
        if (i <= 2) {
          medicalSeat = true;
        } else {
          medicalSeat = false;
        }

        type = "First";

      } else if (i >= 24) { // Economy seating
        medicalSeat = false;
        type = "Economy";
      } else { // Main cabin
        medicalSeat = false;
        type = "Main Cabin";
      }

      price = pricing.get(type);
      Seating seat = new Seating(medicalSeat, booked, price, type, seatNum);
      ret.put(seatNum, seat);
    }

    // Make C row seating
    for (int i = 1; i < 31; i++) {
      String seatNum = "";

      Boolean medicalSeat;
      Boolean booked = false;
      int price;
      String type;
      seatNum = "C" + i;

      // First class seats
      if (i <= 10) {
        if (i <= 2) {
          medicalSeat = true;
        } else {
          medicalSeat = false;
        }

        type = "First";

      } else if (i >= 24) { // Economy seating
        medicalSeat = false;
        type = "Economy";
      } else { // Main cabin
        medicalSeat = false;
        type = "Main Cabin";
      }

      price = pricing.get(type);
      Seating seat = new Seating(medicalSeat, booked, price, type, seatNum);
      ret.put(seatNum, seat);
    }

    // Make D row seating
    for (int i = 1; i < 31; i++) {
      String seatNum = "";

      Boolean medicalSeat;
      Boolean booked = false;
      int price;
      String type;
      seatNum = "D" + i;

      // First class seats
      if (i <= 10) {
        if (i <= 2) {
          medicalSeat = true;
        } else {
          medicalSeat = false;
        }

        type = "First";

      } else if (i >= 24) { // Economy seating
        medicalSeat = false;
        type = "Economy";
      } else { // Main cabin
        medicalSeat = false;
        type = "Main Cabin";
      }

      price = pricing.get(type);
      Seating seat = new Seating(medicalSeat, booked, price, type, seatNum);
      ret.put(seatNum, seat);
    }

    return ret;
  }
}