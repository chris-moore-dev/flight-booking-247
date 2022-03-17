import java.util.ArrayList;
import java.util.HashMap;
import java.util.Date;

/**
 * Room class
 * @author
 */
public class Room extends IndividualBooking {
  private boolean smokingAllowed;
  private ArrayList<String> bookedDays;
  private int numBeds;

  /**
   * Default constructor
   * @param smokingAllowed
   * @param availability
   */
  Room(boolean smokingAllowed, HashMap<Date, boolean> availability) {
    // super()
  }

  // GETTERS

  /**
   * 
   * @param room
   * @return
   */
  public boolean getIsSmokingAllowed(Room room) {
    return this.smokingAllowed;
  }

  /**
   * 
   * @param room
   * @return
   */
  public ArrayList<String> getBookedDays(Room room) {
    return this.bookedDays;
  }

  /**
   * 
   * @param room
   * @return
   */
  public int getNumBeds(Room room) {
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
  public void setBookedDays(ArrayList<String> bookedDays) {
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
