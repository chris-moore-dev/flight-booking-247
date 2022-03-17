import java.util.ArrayList;
import java.util.HashMap;
import java.util.Date;

public class Room extends IndividualBooking {
  private boolean smokingAllowed;
  private ArrayList<String> bookedDays;
  private int numBeds;

  Room(Boolean smokingAllowed, HashMap<Date, Boolean> availability) {
    // super()
  }

  // GETTERS

  public boolean getIsSmokingAllowed(Room room) {
    return this.smokingAllowed;
  }

  public ArrayList<String> getBookedDays(Room room) {
    return this.bookedDays;
  }

  public int getNumBeds(Room room) {
    return this.numBeds;
  }

  // SETTERS

  public void setIsSmokingAllowed(boolean smokingAllowed) {
    this.smokingAllowed = smokingAllowed;
  }

  public void setBookedDays(ArrayList<String> bookedDays) {
    this.bookedDays = bookedDays;
  }

  public void setNumBeds(int numBeds) {
    this.numBeds = numBeds;
  }
}
