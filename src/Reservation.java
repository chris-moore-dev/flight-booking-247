/**
 * Reservation
 * @author Lyn Cork
 */
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
public abstract class Reservation { 
  protected UUID id;
  protected String reservationHolderFirstName;
  protected String reservationHolderLastName;
  protected int price;
  protected DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");



  /**
   * 
   * @param reservationHolderFirstName
   * @param price
   * @param reservationHolderLastName
   */
  Reservation(String reservationHolderFirstName,
  String reservationHolderLastName, int price) {
    
  }

  /**
   * 
   * @param reservationHolderFirstName
   * @param reservationHolderLastName
   * @param individualBooking
   * @param price
   * @param id
   */
  Reservation(String reservationHolderFirstName,
  String reservationHolderLastName, int price, UUID id) {
    
  }

  /**
   * 
   */
  @Override
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