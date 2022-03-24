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
    setBoardingGroup(boardingGroup);
    setBoardingTime(boardingTime);
    setGate(gate);
    setName(name);
    setNumOfCheckedBags(numOfCheckedBags);
    setFlight(flight);
    setSeat(seat);
    setFirstName(firstName);
    setLastName(lastName);
    this.price = price;
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
    setBoardingGroup(boardingGroup);
    setBoardingTime(boardingTime);
    setGate(gate);
    setName(name);
    setNumOfCheckedBags(numOfCheckedBags);
    setFlight(flight);
    setSeat(seat);
    setFirstName(firstName);
    setLastName(lastName);
    this.price = price;
    setId(id);
  }

/**
 * 
 */
  @Override
  public String toString() {
    String ret = "\n";
    ret += name + ": \n" + "gate: " + gate + "\nBoarding Group: " +
           boardingGroup + "\nBoarding Time: " + boardingTime + "\nBags: " +
           String.valueOf(numOfCheckedBags) + "\nSeat: " + String.valueOf(seat.getNumber);
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
  public UUID getId() {
    return this.id;
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
  /**
   * Sets first name of ticket holder
   * @param firstName ticket holder's first name
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }
  /**
   * Sets last name of ticket holder
   * @param lastName ticket holder's last name
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
  /**
   * Sets UUID
   * @param id UUID
   */
  public void setId(UUID id) {
    this.id = id;
  }
}
