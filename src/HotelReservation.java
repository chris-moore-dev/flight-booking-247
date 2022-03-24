/**
 * HotelReservation
 * @author Evan Scales
 */
import java.time.LocalDate;
import java.util.*;
public class HotelReservation extends Reservation {
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private int numGuests;
    private Hotel hotel;
    private Room room;

    /**
     * Constructor to use when first creating a hotel reservation
     * @param hotel The hotel
     * @param firstName The first name of the reservation holder
     * @param lastName The last name of the reservation holder
     * @param room The room on the reservation
     * @param price The price of the hotel reservation
     * @param checkInDate The check in date
     * @param checkOutDate The check out date
     * @param numGuests The number of guests
     */
    HotelReservation(Hotel hotel, String firstName, String lastName,
    Room room, int price, LocalDate checkInDate, LocalDate checkOutDate,
    int numGuests) {
        super(firstName, lastName, price);
        setHotel(hotel);
        setRoom(room);
        setCheckInDate(checkInDate);
        setCheckOutDate(checkOutDate);
        setNumGuests(numGuests);
    }

    /**
     * Constructor to use when loading hotel reservation from database
     * @param hotel The hotel
     * @param firstName The first name of the reservation holder
     * @param lastName The last name of the reservation holder
     * @param room The room on the reservation
     * @param price The price of the hotel reservation
     * @param checkInDate The check in date
     * @param checkOutDate The check out date
     * @param numGuests The number of guests
     * @param id The id
     */
    HotelReservation(Hotel hotel, String firstName, String lastName,
    Room room, int price, LocalDate checkInDate, LocalDate checkOutDate,
    int numGuests, UUID id) {
        super(firstName, lastName, price, id);
        setHotel(hotel);
        setRoom(room);
        setCheckInDate(checkInDate);
        setCheckOutDate(checkOutDate);
        setNumGuests(numGuests);
    }

    // Member functions

    /**
     * Used to print the hotel reservation
     */
    @Override
    public String toString() {
        String ret = "";

        ret += "\n- - - - - ";
        ret += hotel.getCompany();
        ret += " Hotel Reservation - - - - -\n\n";
        ret += "Total Price: $" + getPrice() + "\n";
        ret += "Room Type: " + room.getType() + "\n"; 
        ret += "Check-In Date: " + dateFormat.format(checkInDate) + "\n";
        ret += "Check-Out Date: " + dateFormat.format(checkOutDate) + "\n";
        ret += "Address: " + hotel.getAddress() + "\n\n";

        return ret;
    }

    // Getters

    /**
     * Get the hotel
     * @return The hotel
     */
    public Hotel getHotel() {
        return hotel;
    }

    /**
     * Get the check in date
     * @return The check in date
     */
    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    /**
     * Get the checkout date
     * @return The checkout date
     */
    public LocalDate getChecOutDate() {
        return checkOutDate;
    }

    /**
     * Get the num guests
     * @return The num guests
     */
    public int getNumGuests() {
        return numGuests;
    }

    /**
     * 
     * @return
     */
    public Room getRoom() {
        return this.room;
    }

    // Setters

    /**
     * Set the check in date
     * @param checkInDate The check in date
     */
    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    /**
     * Set the check out date
     * @param checkOutDate The check out date
     */
    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    /**
     * Set the num guests
     * @param numGuests The num guests
     */
    public void setNumGuests(int numGuests) {
        this.numGuests = numGuests;
    }

    /**
     * Set the hotel
     * @param hotel The hotel
     */
    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    /**
     * 
     * @param room
     */
    public void setRoom(Room room) {
        this.room = room;
    }
}
