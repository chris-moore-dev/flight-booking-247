import java.util.UUID;

/**
 * Seating class
 * @author Chris Moore, Evan Scales
 */
public class Seating extends IndividualBooking {
  private boolean medicalSeat;

  /**
   * Constructor to use when first creating seat
   * @param medicalSeat Is it a mediccal seat
   * @param booked Is it booked
   * @param price The price
   * @param type The seat type
   * @param number The seat number
   */
  Seating(boolean medicalSeat, boolean booked, int price,
  String type, String number) {
    super(booked, price, type, number);
    setIsMedicalSeat(medicalSeat);
  }

  /**
   * Constructor to use when loading seat from database
   * @param medicalSeatIs it a mediccal seat
   * @param id The id
   * @param booked Is it booked
   * @param price The price
   * @param type The seat type
   * @param number The seat number
   */
  Seating(boolean medicalSeat, UUID id, boolean booked, int price,
  String type, String number) {
    super(id, booked, price, type, number);
    setIsMedicalSeat(medicalSeat);
  }

  // GETTERS

  /**
   * Get the medical seat status
   * @return The medical seat status
   */
  public boolean getIsMedicalSeat() {
    return this.medicalSeat;
  }

  // SETTERS

  /**
   * Set the medical seat status
   * @param medicalSeat The medical seat status
   */
  public void setIsMedicalSeat(boolean medicalSeat) {
    this.medicalSeat = medicalSeat;
  }
}
