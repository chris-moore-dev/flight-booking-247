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
   * 
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

  }

  /**
   * 
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

  }



/**
 * 
 */
  @Override
  public String toString() {
    
  }
  // Getters
/**
 * 
 * @return
 */
  public String getBoardingGroup() {
    return boardingGroup;
  }
/**
 * 
 * @return
 */
  public String getBoardingTime() {
    return boardingTime;
  }
/**
 * 
 * @return
 */
  public String getGate() {
    return gate;
  }
/**
 * 
 * @return
 */
  public String getName() {
    return name;
  }
/**
 * 
 * @return
 */
  public int getNumOfCheckedBags() {
    return numOfCheckedBags;
  }
  /**
   * 
   * @return
   */
  public Flight getFlight() {
    return this.flight;
  }
  /**
   * 
   * @return
   */
  public Seating getSeat() {
    return this.seat;
  }
  // Setters
/**
 * 
 * @param boardingGroup
 */
  public void setBoardingGroup(String boardingGroup) {
    this.boardingGroup = boardingGroup;
  }
/**
 * 
 * @param boardingTime
 */
  public void setBoardingTime(String boardingTime) {
    this.boardingTime = boardingTime;
  }
/**
 * 
 * @param gate
 */
  public void setGate(String gate) {
    this.gate = gate;
  }
/**
 * 
 * @param name
 */
  public void setName(String name) {
    this.name = name;
  }
/**
 * 
 * @param numOfCheckedBags
 */
  public void setNumOfCheckedBags(int numOfCheckedBags) {
    this.numOfCheckedBags = numOfCheckedBags;
  }
  public void setFlight(Flight flight) {
    this.flight = flight;
  }
  /**
   * 
   * @param seat
   */
  public void setSeat(Seating seat) {
    this.seat = seat;
  }
}
