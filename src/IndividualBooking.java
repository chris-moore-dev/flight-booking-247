/**
 * IndividualBooking
 * @author Evan Scales
 */
import java.util.*;
public abstract class IndividualBooking {
    private UUID id;
    private boolean booked;
    private int price;
    private String type;
    private String number;

    /**
     * Constructor to use when making a new individual booking
     * @param booked The booked setting
     * @param price The price
     * @param type Cabin or room type
     * @param number The room or seat number
     */
    IndividualBooking(boolean booked, int price, String type, String number) {
        setID(null);
        setBooked(booked);
        setPrice(price);
        setType(type);
        setNumber(number);
    }

    /**
     * Constructor to use when loading the indivudal booking from data base
     * @param id The id
     * @param booked The booked setting 
     * @param price The price
     * @param type Cabin or room type
     * @param number The room or seat number
     */
    IndividualBooking(UUID id, boolean booked, int price, String type, String number) {
        setID(id);
        setBooked(booked);
        setPrice(price);
        setType(type);
        setNumber(number);
    }

    // Member Functions

    // Getters

    /**
     * Get the uuid
     * @return The uuid
     */
    public UUID getID() {
        return id;
    }

    /**
     * Get the booked status
     * @return The booked status
     */
    public boolean getBooked() {
        return booked;
    }

    /**
     * Get the price 
     * @return The price
     */
    public int getPrice() {
        return price;
    }

    /**
     * Get the type
     * @return The type
     */
    public String getType() {
        return type;
    }

    /**
     * Get the room or seat number
     * @return The number
     */
    public String getNumber() {
        return number;
    }

    // Setters

    /**
     * Set the id
     * @param id The id
     */
    public void setID(UUID id) {
        if (id != null)
            this.id = id;
        else
            this.id = UUID.randomUUID();
    }

    /**
     * Set the booked status
     * @param booked The booked status
     */
    public void setBooked(boolean booked) {
        this.booked = booked;
    }

    /**
     * Set the price
     * @param price The price
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * Set the type
     * @param type The type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Set the room or seat number
     * @param number The number
     */
    public void setNumber(String number) {
        this.number = number;
    }
}
