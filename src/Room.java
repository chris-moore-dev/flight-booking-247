import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import java.util.Date;

/**
 * Room class
 * @author
 */
public class Room extends IndividualBooking {
  private boolean smokingAllowed;
  private ArrayList<LocalDate> bookedDays;
  private int numBeds;

  /**
   * 
   * @param smokingAllowed
   * @param bookedDays
   * @param numBeds
   * @param booked
   * @param price
   * @param type
   * @param number
   */
  Room(boolean smokingAllowed, ArrayList<LocalDate> bookedDays, int numBeds,
  boolean booked, int price, String type, String number) {
    super(booked, price, type, number);
  }

  /**
   * 
   * @param smokingAllowed
   * @param bookedDays
   * @param numBeds
   * @param id
   * @param booked
   * @param price
   * @param type
   * @param number
   */
  Room(boolean smokingAllowed, ArrayList<LocalDate> bookedDays, int numBeds,
  UUID id, boolean booked, int price, String type, String number) {
    super(id, booked, price, type, number);
  }

  // GETTERS

  /**
   * 
   * @return
   */
  public boolean getIsSmokingAllowed() {
    return this.smokingAllowed;
  }

  /**
   * 
   * @return
   */
  public ArrayList<LocalDate> getBookedDays() {
    return this.bookedDays;
  }

  /**
   * 
   * @return
   */
  public int getNumBeds() {
    return this.numBeds;
  }

  // SETTERS

  /**
   * 
   * @param smokingAllowed
   */
  public void setIsSmokingAllowed(boolean smokingAllowed) {
    this.smokingAllowed = smokingAllowed;
  }

  /**
   * 
   * @param bookedDays
   */
  public void setBookedDays(ArrayList<LocalDate> bookedDays) {
    this.bookedDays = bookedDays;
  }

  /**
   * 
   * @param numBeds
   */
  public void setNumBeds(int numBeds) {
    this.numBeds = numBeds;
  }
}
