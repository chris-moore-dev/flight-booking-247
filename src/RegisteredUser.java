/**
 * RegisteredUser
 * @author Evan Scales
 */
import java.util.*;
public class RegisteredUser extends User {
    private UUID userID;
    private String firstName;
    private String lastName;
    private String email;
    private int age;
    private String address;
    private String password;
    private String gender;
    private String preferredAirport;
    private boolean frequentFlyer;
    private boolean admin;
    private boolean medicalCondition;
    private ArrayList<String> blackListedAirports;
    private ArrayList<Ticket> tickets;
    private ArrayList<HotelReservation> hotelReservations;
    private ArrayList<Friend> friends;

    /**
     * 
     * @param firstName
     * @param lastName
     * @param email
     * @param age
     * @param address
     * @param password
     * @param gender
     * @param preferredAirport
     * @param frequentFlyer
     * @param admin
     * @param medicalCondition
     * @param blackListedAirports
     * @param tickets
     * @param hotelReservations
     * @param friends
     */
    RegisteredUser(String firstName, String lastName, String email,
    int age, String address, String password, String gender, 
    String preferredAirport, boolean frequentFlyer, boolean admin,
    boolean medicalCondition, ArrayList<String> blackListedAirports, 
    ArrayList<Ticket> tickets, ArrayList<HotelReservation> hotelReservations,
    ArrayList<Friend> friends) {

    }

    /**
     * 
     * @param userID
     * @param firstName
     * @param lastName
     * @param email
     * @param age
     * @param address
     * @param password
     * @param gender
     * @param preferredAirport
     * @param frequentFlyer
     * @param admin
     * @param medicalCondition
     * @param blackListedAirports
     * @param tickets
     * @param hotelReservations
     * @param friends
     */
    RegisteredUser(UUID userID, String firstName, String lastName, String email,
    int age, String address, String password, String gender, 
    String preferredAirport, boolean frequentFlyer, boolean admin,
    boolean medicalCondition, ArrayList<String> blackListedAirports, 
    ArrayList<Ticket> tickets, ArrayList<HotelReservation> hotelReservations,
    ArrayList<Friend> friends) {
        
    } 

    // Member functions

    /**
     * 
     * @param flights
     * @param seating
     * @param ticketHolders
     */
    public void bookFlights(ArrayList<Flight> flights, ArrayList<Seating> seating,
    ArrayList<Friend> ticketHolders) {

    }

    /**
     * 
     * @param hotel
     * @param room
     * @param numGuests
     * @param checkInDate
     * @param checkOutDate
     */
    public void bookHotel(Hotel hotel, Room room, int numGuests,
    Date checkInDate, Date checkOutDate) {

    }

    /**
     * 
     * @param blackListedAirport
     */
    public void addBlackListedAirport(String blackListedAirport) {

    }

    /**
     * 
     * @param ticket
     */
    public void addTicket(Ticket ticket) {

    }

    /**
     * 
     * @param hotelReservation
     */
    public void addHotelReservation(HotelReservation hotelReservation) {

    }

    /**
     * 
     * @param friend
     */
    public void addFriend(Friend friend) {

    }

    /**
     * 
     * @param blackListedAirport
     */
    public void removeBlackListedAirport(String blackListedAirport) {
        
    }

    /**
     * 
     * @param ticket
     */
    public void removeTicket(Ticket ticket) {

    }

    /**
     * 
     * @param hotelReservation
     */
    public void removeHotelReservation(HotelReservation hotelReservation) {

    }

    /**
     * 
     * @param friend
     */
    public void removeFriend(Friend friend) {

    }
    
    // Getters

    /**
     * 
     * @return
     */
    public UUID getUUID() {
        return userID;
    }
    
    /**
     * 
     * @return
     */
    public String getFirstname() {

    }

    /**
     * 
     * @return
     */
    public String getLastName() {

    }

    /**
     * 
     * @return
     */
    public String getEmail() {

    }

    /**
     * 
     * @return
     */
    public int getAge() {

    }

    /**
     * 
     * @return
     */
    public String getAddress() {

    }

    /**
     * 
     * @return
     */
    public String getPassword() {

    }

    /**
     * 
     * @return
     */
    public String getGender() {

    }

    /**
     * 
     * @return
     */
    public String getPreferredAirport() {

    }

    /**
     * 
     * @return
     */
    public boolean getFrequentFlyer() {

    }

    /**
     * 
     * @return
     */
    public boolean getAdmin() {

    }

    /**
     * 
     * @return
     */
    public boolean getMedicalCondition() {

    }

    /**
     * 
     * @return
     */
    public ArrayList<String> getBlackListedAirports() {

    }

    /**
     * 
     * @return
     */
    public ArrayList<Ticket> getTickets() {

    }

    /**
     * 
     * @return
     */
    public ArrayList<HotelReservation> getHotelReservations() {

    }

    /**
     * 
     * @return
     */
    public ArrayList<Friend> getFriends() {

    }

    // Setters

    /**
     * 
     * @param userID
     */
    public void setUserID(UUID userID) {

    }

    /**
     * 
     * @param firstName
     */
    public void setFirstName(String firstName) {

    }

    /**
     * 
     * @param lastName
     */
    public void setLastName(String lastName) {

    }

    /**
     * 
     * @param email
     */
    public void setEmail(String email) {

    }

    /**
     * 
     * @param age
     */
    public void setAge(int age) {

    }

    /**
     * 
     * @param address
     */
    public void setAddress(String address) {

    }

    /**
     * 
     * @param password
     */
    public void setPassword(String password) {

    }

    /**
     * 
     * @param gender
     */
    public void setGender(String gender) {

    }

    /**
     * 
     * @param preferredAirport
     */
    public void setPreferredAirport(String preferredAirport) {

    }

    /**
     * 
     * @param frequentFlyer
     */
    public void setFrequentFlyer(boolean frequentFlyer) {

    }

    /**
     * 
     * @param admin
     */
    public void setAdmin(boolean admin) {

    }

    /**
     * 
     * @param medicalCondition
     */
    public void setMedicalCondition(boolean medicalCondition) {

    }

    /**
     * 
     * @param blackListedAirports
     */
    public void setBlackListedAirports(ArrayList<String> blackListedAirports) {

    }

    /**
     * 
     * @param tickets
     */
    public void setTickets(ArrayList<Ticket> tickets) {

    }

    /**
     * 
     * @param hotelReservations
     */
    public void setHotelReservations(ArrayList<HotelReservation> hotelReservations) {

    }

    /**
     * 
     * @param friends
     */
    public void setFriends(ArrayList<Friend> friends) {

    }
}