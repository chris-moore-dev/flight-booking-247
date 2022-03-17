/**
 * Seating class
 * @author Chris Moore
 */
public class Seating extends IndividualBooking {
  private boolean medicalSeat;

  Seating(boolean medicalSeat) {
    //super()
  }

  // GETTERS

  public boolean getIsMedicalSeat(Seating seating) {
    return this.medicalSeat;
  }

  // SETTERS

  public void setIsMedicalSeat(boolean medicalSeat) {
    this.medicalSeat = medicalSeat;
  }
}
