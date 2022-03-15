/**
 * ObjectToBeBooked
 * @author Evan Scales
 */
import java.util.*;
public abstract class ObjectToBeBooked {
    private UUID id;
    private String company;
    private HashMap<String, IndividualBooking> individualBookings;
    private HashMap<String, Integer> pricing;

    /**
     * Constructor to use when creating a new ObjectToBeBooked
     * Creates a new random UUID
     * @param company The company
     * @param individualBookings The individual bookings
     * @param pricing The pricing
     */
    ObjectToBeBooked(String company, HashMap<String, IndividualBooking> individualBookings,
    HashMap<String, Integer> pricing) {
        setID(null);
        setCompany(company);
        setIndividualBookingsMap(individualBookings);
        setPricingMap(pricing);
    }

    /**
     * Constructor to use when creating an ObjectToBeBooked from database
     * @param id The id
     * @param company The company
     * @param individualBookings The individual bookings
     * @param pricing The pricing
     */
    ObjectToBeBooked(UUID id, String company,
    HashMap<String, IndividualBooking> individualBookings,
    HashMap<String, Integer> pricing) {
        setID(id);
        setCompany(company);
        setIndividualBookingsMap(individualBookings);
        setPricingMap(pricing);
    }

    /**
     * Super Constructor to use when creating a flight with layovers 
     * New flight with layover
     * @param company The company
     * @param pricing The pricing hash map
     */
    ObjectToBeBooked(String company, HashMap<String, Integer> pricing) {
        setID(null);
        setCompany(company);
        setPricingMap(pricing);
        individualBookings = null;
        
    }

    /**
     * Super Constructor to use when creating a flight with layoves
     * Flight with layover loading from database
     * @param id The id
     * @param company The company
     * @param pricing The pricing hash map
     */
    ObjectToBeBooked(UUID id, String company, HashMap<String, Integer> pricing) {
        setID(id);
        setCompany(company);
        setPricingMap(pricing);
        individualBookings = null;
    }

    // Member functions

    /**
     * 
     * @param individualBookingNumber
     */
    public void book(IndividualBooking individualBooking) {

    }

    /**
     * Gets the indivudal booking at the hashamp
     * @param individualBookingNum The number, Seat or room number
     * @return The object of that indivual booking
     */
    public IndividualBooking getIndividualBooking(String individualBookingNum) {
        return individualBookings.get(individualBookingNum);
    }

    /**
     * Gets the pricing of the subsection
     * Price for room type or
     * Price for cabin type
     * @param subsection The subsection, cabin or room type
     * @return The price of that subsection
     */
    public int getPrice(String subsection) {
        return pricing.get(subsection);
    }

    /**
     * 
     */
    protected abstract void print();

    // Getters

    /**
     * Get the ID
     * @return The id
     */
    public UUID getID() {
        return id;
    }

    /**
     * Get the company 
     * @return The company
     */
    public String getCompany() {
        return company;
    }

    /**
     * Get the individual bookings hashmap
     * @return The individual bookings hash map
     */
    public HashMap<String, IndividualBooking> getIndividualBookings() {
        return individualBookings;
    }

    /**
     * Get the pricing hashmap
     * @return The pricing hashmap
     */
    public HashMap<String, Integer> getPricing() {
        return pricing;
    }

    // Setters

    /**
     * Set the ID
     * @param id The id
     */
    public void setID(UUID id) {
        if (id != null)
            this.id = id;
        else
            this.id = UUID.randomUUID();
    }

    /**
     * Set the company
     * @param company The company
     */
    public void setCompany(String company) {
        if (company != null)
            this.company = company;
        else
            this.company = ";"
    }

    /**
     * Set the individual bookings hashmap
     * @param individualBookings The individual bookings hashmap
     */
    public void setIndividualBookingsMap(HashMap<String, IndividualBooking> individualBookings) {
        this.individualBookings = individualBookings;
    }

    /**
     * Set the pricing hashmap
     * @param pricing The pricing hashmap
     */
    public void setPricingMap(HashMap<String, Integer> pricing) {
        this.pricing = pricing;
    }
}