import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import java.util.Date;

/**
 * Room class
 * @author Evan Scales
 */
public class Room extends IndividualBooking {
  private boolean smokingAllowed;
  private ArrayList<LocalDate> bookedDays;
  private int numBeds;

  /**
   * Constructor to use when creating room for the first time
   * @param smokingAllowed Smoking allwoed status
   * @param bookedDays The booked days
   * @param numBeds The number of beds
   * @param booked The booked status
   * @param price The price
   * @param type The room type
   * @param number The room number
   */
  Room(boolean smokingAllowed, ArrayList<LocalDate> bookedDays, int numBeds,
  boolean booked, int price, String type, String number) {
    super(booked, price, type, number);
    setIsSmokingAllowed(smokingAllowed);
    setBookedDays(bookedDays);
    setNumBeds(numBeds);
  }

  /**
   * Constructor to use when loading rooms from database
   * @param smokingAllowed Smoking allowed status
   * @param bookedDays The booked days
   * @param numBeds The number of beds
   * @param id The id
   * @param booked the booked status
   * @param price The price
   * @param type The room type
   * @param number The room number
   */
  Room(boolean smokingAllowed, ArrayList<LocalDate> bookedDays, int numBeds,
  UUID id, boolean booked, int price, String type, String number) {
    super(id, booked, price, type, number);
    setIsSmokingAllowed(smokingAllowed);
    setBookedDays(bookedDays);
    setNumBeds(numBeds);
  }
  
  /**
   * toString for Room, makes a string representation of the room object
   * @return String representation of room object
   */
  public String toString() {
    String ret;
    String status;
    String smoking;
    if (getBooked() == true) {
      status = "Booked";
    } else {
      status = "Open";
    }
    if (smokingAllowed == true) {
      smoking = "Smoking is allowed.";
    } else {
      smoking = "Smoking is not allowed.";
    }
    ret = "\nRoom " + getNumber() + "\nStatus: " + status + "\nType: " + getType() + "\nBeds: " + numBeds + "\n" + smoking +
          "\nPrice: " + getPrice();
    return ret;
  }

  /**
   * Adds the booked days to the booked days list
   * @param dates The booked days
   */
  public void book(ArrayList<LocalDate> dates) {
    for (LocalDate localDate : dates) {
      this.bookedDays.add(localDate);
    }
  }

  /**
   * Removes the dates from booked days
   * @param dates The dates
   */
  public void unBook(ArrayList<LocalDate> dates) {
    for (LocalDate localDate : dates) {
        this.bookedDays.remove(localDate);
    }
  }

  // GETTERS

  /**
   * Get the smoking allowed status
   * @return If smoking is allowed
   */
  public boolean getIsSmokingAllowed() {
    return this.smokingAllowed;
  }

  /**
   * Get the booked days
   * @return The booked days array list
   */
  public ArrayList<LocalDate> getBookedDays() {
    return this.bookedDays;
  }

  /**
   * Get the number of beds
   * @return The number of beds
   */
  public int getNumBeds() {
    return this.numBeds;
  }

  // SETTERS

  /**
   * Set the smoking allowed status
   * @param smokingAllowed The smoking allowed status
   */
  public void setIsSmokingAllowed(boolean smokingAllowed) {
    this.smokingAllowed = smokingAllowed;
  }

  /**
   * Set the booked days
   * @param bookedDays The booked days array list
   */
  public void setBookedDays(ArrayList<LocalDate> bookedDays) {
    if (bookedDays != null)
      this.bookedDays = bookedDays;
    else
      this.bookedDays = new ArrayList<>();
  }

  /**
   * Set the number of beds
   * @param numBeds The number of beds
   */
  public void setNumBeds(int numBeds) {
    this.numBeds = numBeds;
  }
}
