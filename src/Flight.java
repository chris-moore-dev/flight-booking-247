import java.util.ArrayList;
import java.util.HashMap;

/**
 * Flight
 * @author Chris Moore
 */
public class Flight extends ObjectToBeBooked {
  private String date;
  private String departingAirport;
  private String destAirport;
  private String takeOffTime;
  private String landingTime;
  private String totalFlightTime;
  private boolean layover;
  private ArrayList<Flight> flights;
  private int numStops;
  private double discountPercent;


  /**
   * Default constructor for Flight object
   */
  Flight(String date, String departingAirport, String destAirport, String takeOffTime,
  String landingTime, String totalFlightTime) {
    //TODO fix super constructor error
  }


  /**
   * 
   * @param flight
   */
  public void printSeats(Flight flight) {

  }

  /**
   * 
   * @param flight
   */
  public void print(Flight flight) {
    System.out.println("Example");
  }

  /**
   * 
   * @param flight
   * @return
   */
  public String getDate(Flight flight) {
    return this.date;
  }

  // GETTERS

  /**
   * 
   * @param flight
   * @return
   */
  public String getDepartingAirport(Flight flight) {
    return this.departingAirport;
  }

  /**
   * 
   * @param flight
   * @return
   */
  public String getDestAirport(Flight flight) {
    return this.destAirport;
  }

  /**
   * 
   * @param flight
   * @return
   */
  public String getTakeOffTime(Flight flight) {
    return this.takeOffTime;
  }

  /**
   * 
   * @param flight
   * @return
   */
  public String getLandingTime(Flight flight) {
    return this.landingTime;
  }

  /**
   * 
   * @param flight
   * @return
   */
  public String getTotalFlightTime(Flight flight) {
    return this.totalFlightTime;
  }

  /**
   * 
   * @param flight
   * @return
   */
  public boolean getIsLayover(Flight flight) {
    return this.layover;
  }

  /**
   * 
   * @param flight
   * @return
   */
  public ArrayList<Flight> getFlights(Flight flight) {
    return this.flights;
  }

  /**
   * 
   * @param flight
   * @return
   */
  public int getNumStops(Flight flight) {
    return this.numStops;
  }

  /**
   * 
   * @param flight
   * @return
   */
  public double getDiscountPercent(Flight flight) {
    return this.discountPercent;
  }

  // SETTERS

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
    this.flights = flights;
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
}