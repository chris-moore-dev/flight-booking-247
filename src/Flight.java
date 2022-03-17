/**
 * Flight
 * @author Chris Moore
 */
import java.util.*;
public class Flight extends ObjectToBeBooked {
  private Date date;
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
   * 
   * @param date
   * @param departingAirport
   * @param destAirport
   * @param takeOffTime
   * @param landingTime
   * @param totalFlightTime
   * @param company
   * @param seating
   * @param pricing
   */
  Flight(Date date, String departingAirport, String destAirport,
  String takeOffTime, String landingTime, String totalFlightTime, 
  String company, HashMap<String, Seating> seating,
  HashMap<String, Integer> pricing) {
    // super(company, seating, pricing); 
    
  }

  /**
   * 
   * @param date
   * @param departingAirport
   * @param destAirport
   * @param takeOffTime
   * @param landingTime
   * @param totalFlightTime
   * @param company
   * @param seating
   * @param pricing
   * @param id
   */
  Flight(Date date, String departingAirport, String destAirport,
  String takeOffTime, String landingTime, String totalFlightTime, 
  String company, HashMap<String, Seating> seating,
  HashMap<String, Integer> pricing, UUID id) {
    // super(id, company, seating, pricing);
    
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
   * @param pricing
   */
  Flight(Date date, String departingAirport, String destAirport,
  String takeOffTime, String landingTime, String totalFlightTime,
  boolean layover, ArrayList<Flight> flights, int numStops,
  double discountPercent, String company, HashMap<String, Integer> pricing) {
    super(company, pricing);
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
   * @param pricing
   */
  Flight(Date date, String departingAirport, String destAirport,
  String takeOffTime, String landingTime, String totalFlightTime,
  boolean layover, ArrayList<Flight> flights, int numStops,
  double discountPercent, UUID id, String company, HashMap<String, Integer> pricing) {
    super(id, company, pricing);
  }



  /**
   * 
   */
  public void printSeats() {

  }

  /**
   * 
   */
  @Override
  public String toString() {
    return "Example";
  }

  /**
   * 
   * @return
   */
  public Date getDate() {
    return this.date;
  }

  // GETTERS

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

  // SETTERS

  /**
   * 
   * @param date
   */
  public void setDate(Date date) {
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