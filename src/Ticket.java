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
   * @param boardingGroup
   * @param boardingTime
   * @param gate
   * @param name
   * @param numOfCheckedBags
   * @param flight
   * @param seat
   * @param firstName
   * @param lastName
   * @param price
   */
  Ticket(String boardingGroup, String boardingTime, String gate,
  String name, int numOfCheckedBags, Flight flight, Seating seat, 
  String firstName, String lastName, int price) {
    this.boardingGroup = boardingGroup;
    this.boardingTime = boardingTime;
    this.gate = gate;
    this.name = name;
    this.numOfCheckedBags = numOfCheckedBags;
    this.flight = flight;
    this.seat = seat;
    this.firstName = firstName;
    this.lastName = lastName;
    this.price = price;
  }

  /**
   * Ticket constructor with UUID
   * @param boardingGroup
   * @param boardingTime
   * @param gate
   * @param name
   * @param numOfCheckedBags
   * @param flight
   * @param seat
   * @param firstName
   * @param lastName
   * @param price
   * @param id
   */
  Ticket(String boardingGroup, String boardingTime, String gate,
  String name, int numOfCheckedBags, Flight flight, Seating seat, 
  String firstName, String lastName, int price, UUID id) {
    this.boardingGroup = boardingGroup;
    this.boardingTime = boardingTime;
    this.gate = gate;
    this.name = name;
    this.numOfCheckedBags = numOfCheckedBags;
    this.flight = flight;
    this.seat = seat;
    this.firstName = firstName;
    this.lastName = lastName;
    this.price = price;
    this.id = id;
  }



/**
 * 
 */
  @Override
  public String toString() {
    
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
   * Sets UUID
   * @param id UUID
   */
  public void setId(UUID id) {
    this.id = id;
  }
}
