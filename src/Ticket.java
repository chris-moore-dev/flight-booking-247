/**
 * Ticket
 * @author Lyn Cork
 */
import java.util.*;
public class Ticket extends Reservation {
  private String boardingGroup;
  private String boardingTime;
  private String gate;
  private String name;
  private int numOfCheckedBags;
  private Flight flight;
  private Seating seat;

  /**
   * Ticket constructor
   * @param boardingGroup boarding group
   * @param boardingTime boarding time
   * @param gate gate
   * @param name name
   * @param numOfCheckedBags number of checked bags
   * @param flight flight object
   * @param seat seat object
   * @param firstName first name of ticket holder
   * @param lastName last name of ticket holder
   * @param price price of ticket
   */
  Ticket(String boardingGroup, String boardingTime, String gate,
  String name, int numOfCheckedBags, Flight flight, Seating seat, 
  String firstName, String lastName, int price) {
    super(firstName, lastName, price);
    this.boardingGroup = boardingGroup;
    this.boardingTime = boardingTime;
    this.gate = gate;
    this.name = name;
    this.numOfCheckedBags = numOfCheckedBags;
    this.flight = flight;
    this.seat = seat;
  }

  /**
   * Ticket constructor with UUID
   * @param boardingGroup boarding group
   * @param boardingTime boarding time
   * @param gate gate
   * @param name name 
   * @param numOfCheckedBags number of checked bags
   * @param flight flight object
   * @param seat seat object 
   * @param firstName ticket holder's first name
   * @param lastName ticket holder's last name
   * @param price price
   * @param id UUID
   */
  Ticket(String boardingGroup, String boardingTime, String gate,
  String name, int numOfCheckedBags, Flight flight, Seating seat, 
  String firstName, String lastName, int price, UUID id) {
    super(firstName, lastName, price, id);
    this.boardingGroup = boardingGroup;
    this.boardingTime = boardingTime;
    this.gate = gate;
    this.name = name;
    this.numOfCheckedBags = numOfCheckedBags;
    this.flight = flight;
    this.seat = seat;
  }

/**
 * 
 */
  @Override
  public String toString() {
    String ret = "\n";
    ret += name + ": \n" + "gate: " + gate + "\nBoarding Group: " +
           boardingGroup + "\nBoarding Time: " + boardingTime + "\nBags: " +
           numOfCheckedBags + "\nSeat: " + seat.getNumber();
    return ret;
  }
  // Getters
/**
 * Gets boarding group
 * @return boarding group
 */
  public String getBoardingGroup() {
    return boardingGroup;
  }
/**
 * Gets boarding time
 * @return boarding time
 */
  public String getBoardingTime() {
    return boardingTime;
  }
/**
 * Gets gate
 * @return gate
 */
  public String getGate() {
    return gate;
  }
/**
 * Gets name
 * @return name
 */
  public String getName() {
    return name;
  }
/**
 * Gets number of checked bags
 * @return number of checked bags
 */
  public int getNumOfCheckedBags() {
    return numOfCheckedBags;
  }
  /**
   * Gets flight object
   * @return flight object
   */
  public Flight getFlight() {
    return this.flight;
  }
  /**
   * Gets seating object
   * @return seating object
   */
  public Seating getSeat() {
    return this.seat;
  }
  // Setters
/**
 * Sets boarding group
 * @param boardingGroup boarding group
 */
  public void setBoardingGroup(String boardingGroup) {
    this.boardingGroup = boardingGroup;
  }
/**
 * Sets boarding time
 * @param boardingTime boarding time
 */
  public void setBoardingTime(String boardingTime) {
    this.boardingTime = boardingTime;
  }
/**
 * Sets gate
 * @param gate gate
 */
  public void setGate(String gate) {
    this.gate = gate;
  }
/**
 * Sets name
 * @param name name
 */
  public void setName(String name) {
    this.name = name;
  }
/**
 * Sets number of checked bags
 * @param numOfCheckedBags number of checked bags
 */
  public void setNumOfCheckedBags(int numOfCheckedBags) {
    this.numOfCheckedBags = numOfCheckedBags;
  }
/**
 * Sets flight object
 * @param flight flight object
 */
  public void setFlight(Flight flight) {
    this.flight = flight;
  }
  /**
   * Sets seat object
   * @param seat seat object
   */
  public void setSeat(Seating seat) {
    this.seat = seat;
  }
}
