/**
 * Reservation
 * @author Lyn Cork
 */
public abstract class Reservation { 
  private ObjectToBeBooked object;
  private String reservationHolderFirstName;
  private String reservationHolderLastName;
  private IndividualBooking individualBooking;
  private int price;
/**
 * 
 * @param object
 * @param purchaser
 * @param reservationHolderFirstName
 * @param reservationHolderLastName
 * @param individualBooking
 */
  public Reservation(ObjectToBeBooked object, RegisteredUser purchaser, String reservationHolderFirstName, String reservationHolderLastName, IndividualBooking individualBooking) {
    
  }
/**
 * 
 */
  public abstract void printReservation();
  // Getters
/**
 * 
 * @param object
 * @return
 */
  public ObjectToBeBooked getObject() {
    return object;
  }
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
  // Setters
/**
 * 
 * @param object
 */
  public void setObject(ObjectToBeBooked object) {
    this.object = object;
  }
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
}