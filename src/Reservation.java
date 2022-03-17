/**
 * Reservation
 * @author Lyn Cork
 */
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
public abstract class Reservation { 
  private UUID id;
  private String reservationHolderFirstName;
  private String reservationHolderLastName;
  private IndividualBooking individualBooking;
  private int price;
  protected DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");



  /**
   * 
   * @param reservationHolderFirstName
   * @param reservationHolderLastName
   * @param individualBooking
   */
  Reservation(String reservationHolderFirstName,
  String reservationHolderLastName, IndividualBooking individualBooking) {
    
  }

  /**
   * 
   * @param reservationHolderFirstName
   * @param reservationHolderLastName
   * @param individualBooking
   * @param id
   */
  Reservation(String reservationHolderFirstName,
  String reservationHolderLastName, IndividualBooking individualBooking,
  UUID id) {
    
  }

  /**
   * 
   */
  public abstract String toString();

  // Getters

/**
 * 
 * @return
 */
  public String getReservationHolderFirstName() {
    return reservationHolderFirstName;
  }
/**
 * 
 * @return
 */
  public String getReservationHolderLastName() {
    return reservationHolderLastName;
  }
/**
 * 
 * @return
 */
  public IndividualBooking getIndividualBooking() {
    return individualBooking;
  }
/**
 * 
 * @return
 */
  public int getPrice() {
    return price;
  }

  /**
   * 
   * @return
   */
  public UUID getID() {
    return id;
  }
  // Setters
/**
 * 
 * @param reservationHolderFirstName
 */
  public void setReservationHolderFirstName(String reservationHolderFirstName) {
    this.reservationHolderFirstName = reservationHolderFirstName;
  }
/**
 * 
 * @param reservationHolderLastName
 */
  public void setReservationHolderLastName(String reservationHolderLastName) {
    this.reservationHolderLastName = reservationHolderLastName;
  }
/**
 * 
 * @param individualBooking
 */
  public void setIndividualBooking(IndividualBooking individualBooking) {
    this.individualBooking = individualBooking;
  }
/**
 * 
 * @param price
 */
  public void setPrice(int price) {
    this.price = price;
  }

  /**
   * 
   * @param id
   */
  public void setID(UUID id) {
    if (id != null)
      this.id = id;
    else
      this.id = UUID.randomUUID();
  }
}