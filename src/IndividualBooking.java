/**
 * IndividualBooking
 * @author Evan Scales
 */
import java.util.*;
public abstract class IndividualBooking {
    private UUID id;
    private boolean booked;
    private int price;

    /**
     * 
     * @param booked
     * @param price
     */
    IndividualBooking(boolean booked, int price) {

    }

    /**
     * 
     * @param id
     * @param booked
     * @param price
     */
    IndividualBooking(UUID id, boolean booked, int price) {

    }

    // Member Functions

    // Getters

    /**
     * 
     * @return
     */
    public UUID getID() {

    }

    /**
     * 
     * @return
     */
    public boolean getBooked() {

    }

    /**
     * 
     * @return
     */
    public int getPrice() {

    }

    // Setters

    /**
     * 
     * @param id
     */
    public void setID(UUID id) {

    }

    /**
     * 
     * @param booked
     */
    public void setBooked(boolean booked) {

    }

    /**
     * 
     * @param price
     */
    public void setPrice(int price) {

    }
}
