
/**
 * ObjectToBeBooked
 * @author Evan Scales
 */
import java.util.*;

public abstract class ObjectToBeBooked {
    protected UUID id;
    protected String company;
    protected HashMap<String, Integer> pricing;

    /**
     * Construtor to use when creating a new ObjectToBeBooked
     * 
     * @param company The company
     * @param pricing The pricing
     */
    ObjectToBeBooked(String company, HashMap<String, Integer> pricing) {
        setID(null);
        setCompany(company);
        setPricingMap(pricing);
    }

    /**
     * Constructor to use when loading object from database
     * 
     * @param company    The company
     * @param pricingMap The pricing map
     * @param id         The id
     */
    ObjectToBeBooked(String company, HashMap<String, Integer> pricing,
            UUID id) {
        setID(id);
        setCompany(company);
        setPricingMap(pricing);
    }

    // Member functions

    /**
     * Gets the pricing of the subsection
     * Price for room type or
     * Price for cabin type
     * 
     * @param subsection The subsection, cabin or room type
     * @return The price of that subsection
     */
    public int getPrice(String subsection) {
        // Make subsection first letter uppercase and rest lowercase
        subsection = subsection.substring(0, 1).toUpperCase() + subsection.substring(1).toLowerCase();
        return pricing.get(subsection);
    }

    /**
     * Overrided toString method
     */
    @Override
    public abstract String toString();

    // Getters

    /**
     * Get the ID
     * 
     * @return The id
     */
    public UUID getID() {
        return id;
    }

    /**
     * Get the company
     * 
     * @return The company
     */
    public String getCompany() {
        return company;
    }

    /**
     * Get the pricing hashmap
     * 
     * @return The pricing hashmap
     */
    public HashMap<String, Integer> getPricing() {
        return pricing;
    }

    // Setters

    /**
     * Set the ID
     * 
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
     * 
     * @param company The company
     */
    public void setCompany(String company) {
        if (company != null)
            this.company = company;
        else
            this.company = "";
    }

    /**
     * Set the pricing hashmap
     * 
     * @param pricing The pricing hashmap
     */
    public void setPricingMap(HashMap<String, Integer> pricing) {
        if (pricing != null)
            this.pricing = pricing;
        else
            this.pricing = new HashMap<String, Integer>();
    }
}