import java.util.UUID;

/**
 * Seating class
 * @author Chris Moore
 */
public class Seating extends IndividualBooking {
  private boolean medicalSeat;

  /**
   * 
   * @param medicalSeat
   * @param booked
   * @param price
   * @param type
   * @param number
   */
  Seating(boolean medicalSeat, boolean booked, int price,
  String type, String number) {
    super(booked, price, type, number);
    setIsMedicalSeat(medicalSeat);
  }

  /**
   * 
   * @param medicalSeat
   * @param id
   * @param booked
   * @param price
   * @param type
   * @param number
   */
  Seating(boolean medicalSeat, UUID id, boolean booked, int price,
  String type, String number) {
    super(id, booked, price, type, number);
    setIsMedicalSeat(medicalSeat);
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
