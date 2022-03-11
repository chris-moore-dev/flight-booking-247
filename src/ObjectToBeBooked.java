/**
 * ObjectToBeBooked
 * @author Evan Scales
 */
import java.util.*;
public abstract class ObjectToBeBooked {
    private UUID id;
    private String company;
    private HashMap<String, IndividualBooking> individualBookings;
    protected HashMap<String, Integer> pricing;

    /**
     * 
     * @param company
     * @param individualBookings
     * @param pricing
     */
    ObjectToBeBooked(String company, HashMap<String, IndividualBooking> individualBookings,
    HashMap<String, Integer> pricing) {

    }

    /**
     * 
     * @param id
     * @param company
     * @param individualBookings
     * @param pricing
     */
    ObjectToBeBooked(UUID id, String company,
    HashMap<String, IndividualBooking> individualBookings,
    HashMap<String, Integer> pricing) {

    }

    // Member functions

    /**
     * 
     * @param individualBookingNumber
     */
    public void book(String individualBookingNumber) {

    }

    /**
     * 
     */
    protected abstract void print();

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
    public String getCompany() {

    }

    /**
     * 
     * @return
     */
    public HashMap<String, IndividualBooking> getIndividualBookings() {

    }

    /**
     * 
     * @return
     */
    public HashMap<String, Integer> getPricing() {

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
     * @param company
     */
    public void setCompany(String company) {

    }

    /**
     * 
     * @param individualBookings
     */
    public void setIndividualBookings(HashMap<String, IndividualBooking> individualBookings) {

    }

    /**
     * 
     * @param pricing
     */
    public void setPricing(HashMap<String, Integer> pricing) {

    }
}