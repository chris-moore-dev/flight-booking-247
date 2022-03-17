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

  /**
   * 
   * @param object
   * @param reservationHolderFirstName
   * @param reservationHolderLastName
   * @param individualBooking
   * @param boardingGroup
   * @param boardingTime
   * @param gate
   * @param name
   * @param numOfCheckedBags
   */
  Ticket(ObjectToBeBooked object, String reservationHolderFirstName,
  String reservationHolderLastName, IndividualBooking individualBooking,
  String boardingGroup, String boardingTime, String gate,
  String name, int numOfCheckedBags) {
    super(object, reservationHolderFirstName, reservationHolderLastName, individualBooking);
  }

  /**
   * 
   * @param object
   * @param reservationHolderFirstName
   * @param reservationHolderLastName
   * @param individualBooking
   * @param boardingGroup
   * @param boardingTime
   * @param gate
   * @param name
   * @param numOfCheckedBags
   * @param id
   */
  Ticket(ObjectToBeBooked object, String reservationHolderFirstName,
  String reservationHolderLastName, IndividualBooking individualBooking,
  String boardingGroup, String boardingTime, String gate,
  String name, int numOfCheckedBags, UUID id) {
    super(object, reservationHolderFirstName, reservationHolderLastName, individualBooking, id);
  }


/**
 * 
 */
  @Override
  public void printReservation() {
    
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
}
