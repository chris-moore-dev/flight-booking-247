/**
 * HotelReservation
 * @author Evan Scales
 */
import java.util.*;
public class HotelReservation extends Reservation {
    private Date checkInDate;
    private Date checkOutDate;
    private int numGuests;

    /**
     * 
     * @param hotelID
     * @param roomID
     * @param price
     * @param firstName
     * @param lastName
     * @param checkInDate
     * @param checkOutDate
     * @param numGuests
     */
    HotelReservation(UUID hotelID, UUID roomID, int price, 
    String firstName, String lastName, Date checkInDate, 
    Date checkOutDate, int numGuests) {

    }

    /**
     * 
     * @param reservationID
     * @param hotelID
     * @param roomID
     * @param price
     * @param firstName
     * @param lastName
     * @param checkInDate
     * @param checkOutDate
     * @param numGuests
     */
    HotelReservation(UUID reservationID, UUID hotelID, UUID roomID,
    int price, String firstName, String lastName, Date checkInDate, 
    Date checkOutDate, int numGuests) {

    }

    // Member functions

    /**
     * 
     */
    public void printReservation() {

    }

    // Getters

    /**
     * 
     * @return
     */
    public Date getCheckInDate() {

    }

    /**
     * 
     * @return
     */
    public Date getChecOutDate() {

    }

    /**
     * 
     * @return
     */
    public int getNumGuests() {

    }

    // Setters

    /**
     * 
     * @param checkInDate
     */
    public void setCheckInDate(Date checkInDate) {

    }

    /**
     * 
     * @param checkOutDate
     */
    public void setCheckOutDate(Date checkOutDate) {

    }

    /**
     * 
     * @param numGuests
     */
    public void setNumGuests(int numGuests) {

    }
}
