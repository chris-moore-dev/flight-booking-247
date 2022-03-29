/**
 * Flight
 * @author Chris Moore, Evan Scales, Lyn Cork
 */
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.Map.Entry;
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
  private Map<String, Seating> seats;
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
  Map<String, Seating> seats, String departingGate, String destGate) {
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
  Map<String, Seating> seats, UUID id, String departingGate, String destGate) {
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
   * Constructor
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
   * Constructor
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
   * Sets the seat coresponding to the passed seat number to booked
   * @param seatNum the seat number
   */
  public void book(String seatNum) {
    Seating seat = seats.get(seatNum);
    seat.setBooked(true);
  }

  /**
   * Sets the seat corresponding to the peassed seat number to unbooked
   * @param seatNum the seat number
   */
  public void unBook(String seatNum) {
    Seating seat = seats.get(seatNum);
    seat.setBooked(false);
  }

  /**
   * Creates a String that is a map of available, unavailable, and medical seating
   * @return String representation of seats
   */
  public String printSeats() {
    Set<Entry<String, Seating>> temp;
    String ret = "";
    ret =  "            First             |               Main Cabin             |       Economy";
    ret += "\n 1  2  3  4  5  6  7  8  9  10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30";
    ret += "\nA ";
    int i = 0;
    if (getIsLayover() == false) {
      temp = seats.entrySet();
    } else {
      temp = flights.get(0).getSeating().entrySet();
    }
    for (Map.Entry<String, Seating> entry : temp) {
      i++;
      Seating seat = entry.getValue();
      boolean booked = seat.getBooked();
      boolean medical = seat.getIsMedicalSeat();
      if (i <= 30) {
        if (booked == true) {
          ret += "X  ";
        }
        else if (booked == false && medical == false) {
          ret += "O  ";
        }
        else if (medical == true) {
          ret += "M  ";
        }
      }
      else if (i == 31) {
        ret += "\nB ";
        if (booked == true) {
          ret += "X  ";
        }
        else if (booked == false && medical == false) {
          ret += "O  ";
        }
        else if (medical == true) {
          ret += "M  ";
        }
      }
      else if (i > 31 && i <= 60) {
        if (booked == true) {
          ret += "X  ";
        }
        else if (booked == false && medical == false) {
          ret += "O  ";
        }
        else if (medical == true) {
          ret += "M  ";
        }
      }
      else if (i == 61) {
        ret += "\n\nC ";
        if (booked == true) {
          ret += "X  ";
        }
        else if (booked == false && medical == false) {
          ret += "O  ";
        }
        else if (medical == true) {
          ret += "M  ";
        }
      }
      else if (i > 61 && i <= 90) {
        if (booked == true) {
          ret += "X  ";
        }
        else if (booked == false && medical == false) {
          ret += "O  ";
        }
        else if (medical == true) {
          ret += "M  ";
        }
      }
      else if (i == 91) {
        ret += "\nD ";
        if (booked == true) {
          ret += "X  ";
        }
        else if (booked == false && medical == false) {
          ret += "O  ";
        }
        else if (medical == true) {
          ret += "M  ";
        }
      }
      else if (i > 91 && i <= 120) {
        if (booked == true) {
          ret += "X  ";
        }
        else if (booked == false && medical == false) {
          ret += "O  ";
        }
        else if (medical == true) {
          ret += "M  ";
        }
      }
      else if (i > 120) {
        break;
      }
    }
    return ret;
  }

  /**
   * creates a string representation of the flight
   * @return String representation of flight
   */
  @Override
  public String toString() {
    String ret = "";
    ret = departingAirport + "     ->     " + destAirport + "                        Economy   Main Cabin   First";
    ret += "\n" + takeOffTime + "     " + landingTime + "   " + totalFlightTime;
    if (numStops <= 0) {
      ret += "   Nonstop   ";
    }
    else if (numStops == 1) {
      ret += "   " + numStops + " stop    ";
    } else {
      ret += "   " + numStops + " stops   ";
    }

    ret += "$" + getPrice("Economy") + "         $" + getPrice("Main Cabin")
        + "       $" + getPrice("First");
    if (getIsLayover() == false) {
    ret += "\n" + getAvailableSeats() + " Seats Available";
    }
    if (numStops > 0 && getIsLayover() == true) {
      for (int j = 0; j < flights.size(); j++) {
        int nextAvailableSeats = 0;
        Flight nextFlight = flights.get(j);
        ret += "\n" + nextFlight.getDepartingAirport() + "     ->     " + nextFlight.getDestAirport();
        nextAvailableSeats = nextFlight.getAvailableSeats();
        ret += "\n" + nextAvailableSeats + " Seats Available";
      }
    }
    ret += "\n" + company + "\n";
    return ret;
  }

  private int getAvailableSeats() {
    int i = 0;
    int availableSeats = 0;
    for (Map.Entry<String, Seating> entry : seats.entrySet()) {
      i++;
      Seating seat = entry.getValue();
      boolean booked = seat.getBooked(); 
      if (i <= 120) {
        if (booked == false) {
          availableSeats += 1;
        }
      } else {
        break;
      }
    }
    return availableSeats;
  }


  // GETTERS

  /**
   * gets date
   * @return data
   */
  public LocalDate getDate() {
    return this.date;
  }

  /**
   * get departing airport
   * @return departing airport 
   */
  public String getDepartingAirport() {
    return this.departingAirport;
  }

  /**
   * get destination airport
   * @return destination airport
   */
  public String getDestAirport() {
    return this.destAirport;
  }

  /**
   * gets takeoff time
   * @return takeoff time
   */
  public String getTakeOffTime() {
    return this.takeOffTime;
  }

  /**
   * gets landing time
   * @return landing time
   */
  public String getLandingTime() {
    return this.landingTime;
  }

  /**
   * gets total flight time
   * @return total flight time
   */
  public String getTotalFlightTime() {
    return this.totalFlightTime;
  }

  /**
   * gets if flight has layover
   * @return true or false
   */
  public boolean getIsLayover() {
    return this.layover;
  }

  /**
   * gets arraylist of flights
   * @return arraylist of flights
   */
  public ArrayList<Flight> getFlights() {
    return this.flights;
  }

  /**
   * gets the number of stops made
   * @return number of stops
   */
  public int getNumStops() {
    return this.numStops;
  }

  /**
   * gets the discount percentage 
   * @return discount percentage
   */
  public double getDiscountPercent() {
    return this.discountPercent;
  }

  /**
   * gets the hashmap of seats
   * @return the hashmap of seats
   */
  public Map<String, Seating> getSeating() {
    return this.seats;
  }

  /**
   * gets the departing gate
   * @return the departing gate
   */
  public String getDepartingGate() {
    return this.departingGate;
  }

  /**
   * gets the destination gate
   * @return the destination gate
   */
  public String getDestGate() {
    return this.destGate;
  }

  // SETTERS

  /**
   * sets the date
   * @param date date
   */
  public void setDate(LocalDate date) {
      this.date = date;
  }

  /**
   * sets the departing airport
   * @param departingAirport departing airport
   */
  public void setDepartingAirport(String departingAirport) {
    this.departingAirport = departingAirport;
  }

  /**
   * sets the destination airport
   * @param destAirport destination airport
   */
  public void setDestAirport(String destAirport) {
    this.destAirport = destAirport;
  }

  /**
   * sets the takeoff time
   * @param takeOffTime takeoff time
   */
  public void setTakeOffTime(String takeOffTime) {
    this.takeOffTime = takeOffTime;
  }

  /**
   * sets the landing time
   * @param landingTime landing time
   */
  public void setLandingTime(String landingTime) {
    this.landingTime = landingTime;
  }

  /**
   * sets the total flight time
   * @param totalFlightTime total flight time
   */
  public void setTotalFlightTime(String totalFlightTime) {
    this.totalFlightTime = totalFlightTime;
  }

  /**
   *sets if flight has layover 
   * @param layover true/false
   */
  public void setIsLayover(boolean layover) {
    this.layover = layover;
  }

  /**
   * sets arraylist of flights
   * @param flights arraylist of flights
   */
  public void setFlights(ArrayList<Flight> flights) {
    if (flights != null)
      this.flights = flights;
    else
      this.flights = new ArrayList<>();
  }

  /**
   * sets the number of stops made
   * @param numStops number of stops
   */
  public void setNumStops(int numStops) {
    this.numStops = numStops;
  }

  /**
   * sets the discount percent
   * @param discountPercent discount percent
   */
  public void setDiscountPercent(double discountPercent) {
    this.discountPercent = discountPercent;
  }

  /**
   * sets the hashmap of seats
   * @param seats the hashmap of seats
   */
  public void setSeats(Map<String, Seating> seats) {
    if (seats == null)
      this.seats = null;
    else if(seats.isEmpty())
      this.seats = makeSeats();
    else
      this.seats = seats;
  }

  /**
   * sets the departing gate
   * @param departingGate departing gate
   */
  public void setDapartingGate(String departingGate) {
    this.departingGate = departingGate;
  }

  /**
   * sets the destination gate
   * @param destGate destination gate
   */
  public void setDestGate(String destGate) {
    this.destGate = destGate;
  }
  /**
   * makes a hashmap of seats for the plane
   * @return the hashmap of plane seats
   */
  private Map<String, Seating> makeSeats() {
    Map<String, Seating> ret = new LinkedHashMap<>();

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