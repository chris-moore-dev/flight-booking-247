/**
 * RegisteredUser
 * @author Evan Scales
 */
import java.time.LocalDate;
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
     * default constructor
     */
    RegisteredUser(){
    }
    /**
     * Constructor to use when first createing a registered user
     * Will create a new random UUID for the user
     * @param firstName The first name
     * @param lastName The last name
     * @param email The email
     * @param age The age
     * @param address The address
     * @param password The password
     * @param gender The gender
     * @param preferredAirport The preferred airport
     * @param frequentFlyer The frequent flyer status
     * @param admin The admin status
     * @param medicalCondition The medical condition status
     * @param blackListedAirports The black listed airports
     * @param tickets The tickets
     * @param hotelReservations The hotel reservations
     * @param friends The friends
     */
    RegisteredUser(String firstName, String lastName, String email,
    int age, String address, String password, String gender, 
    String preferredAirport, boolean frequentFlyer, boolean admin,
    boolean medicalCondition, ArrayList<String> blackListedAirports, 
    ArrayList<Ticket> tickets, ArrayList<HotelReservation> hotelReservations,
    ArrayList<Friend> friends) {
        setUserID(null);
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setAge(age);
        setAddress(address);
        setPassword(password);
        setGender(gender);
        setPreferredAirport(preferredAirport);
        setFrequentFlyer(frequentFlyer);
        setAdmin(admin);
        setMedicalCondition(medicalCondition);
        setBlackListedAirports(blackListedAirports);
        setTickets(tickets);
        setHotelReservations(hotelReservations);
        setFriends(friends);

        /**
         * All users have themselves as their first friend to make
         * booking tickets easier by being able to fill in passenger info using the 
         * users friend list, which the user is a part of
         */
        friends.add(new Friend(firstName, lastName, age, medicalCondition, gender, email, address));
    }

    /**
     * Constructor to use when loading from json data base
     * @param userID The users ID
     * @param firstName The first name
     * @param lastName The last name
     * @param email The email
     * @param age The age
     * @param address The address
     * @param password The password
     * @param gender The gender
     * @param preferredAirport The preferred airport
     * @param frequentFlyer The frequent flyer status
     * @param admin The admin status
     * @param medicalCondition The medical condition status
     * @param blackListedAirports The blacklisted airports
     * @param tickets The tickets
     * @param hotelReservations The hotel reservaitons
     * @param friends The friends
     */
    RegisteredUser(UUID userID, String firstName, String lastName, String email,
    int age, String address, String password, String gender, 
    String preferredAirport, boolean frequentFlyer, boolean admin,
    boolean medicalCondition, ArrayList<String> blackListedAirports, 
    ArrayList<Ticket> tickets, ArrayList<HotelReservation> hotelReservations,
    ArrayList<Friend> friends) {
        setUserID(userID);
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setAge(age);
        setAddress(address);
        setPassword(password);
        setGender(gender);
        setPreferredAirport(preferredAirport);
        setFrequentFlyer(frequentFlyer);
        setAdmin(admin);
        setMedicalCondition(medicalCondition);
        setBlackListedAirports(blackListedAirports);
        setTickets(tickets);
        setHotelReservations(hotelReservations);
        setFriends(friends);
    } 

    // Member functions

    /**
     * Creates tickets for the ticket holders for the flights provided 
     * Will add the tickets to the users tickets list
     * Books the seats for the flights
     * @param flights The flights to be booked 
     * @param seating The seating 
     * @param ticketHolders The ticket holders
     */
    public void bookFlights(ArrayList<Flight> flights, ArrayList<Seating> seating,
    ArrayList<Friend> ticketHolders) {
        int arraySize = flights.size();
        for (int i = 0; i < arraySize; i++) {
            Flight flight = flights.get(i);
            Seating seat = seating.get(i);
            Friend friend = ticketHolders.get(i);
            String seatNumber = seating.get(i).getNumber();

            flight.book(seatNumber);
            addTicket(makeTicket(flight, friend, seat));

            // TODO Make these changes reflect in the database
        }
    }

    /**
     * Make a ticket to be added to the users account
     * @param flight The flight to be booked on
     * @param friend The person the seats for
     * @param seat The seat
     * @return The ticket to be added to the users account
     */
    private Ticket makeTicket(Flight flight, Friend friend, Seating seat) {
        String boardingGroup;
        if (friend.getMedicalCondition() || seat.getType().equalsIgnoreCase("First")) {
            boardingGroup = "1A";
        } else {
            boardingGroup = "6";
        }
        String[] splitArray = flight.getTakeOffTime().split(":");
        String boardingTime = "7:35";
        // Do Make getting boarding time work
        String gate = flight.getDepartingGate();
        int numOfCheckedBags = 0;
        String fName = friend.getFirstName();
        String lName = friend.getLastName();
        String name = fName + " " + lName;
        int price = seat.getPrice();
        Ticket ticket = new Ticket(boardingGroup, boardingTime, gate,
        name, numOfCheckedBags, flight, seat, fName, lName, price);
        return ticket;
    }

    /**
     * Creates hotel reservations for the user
     * Will add reservations to users hotel reservations list
     * Books the room for the hotel
     * @param hotel The hotel 
     * @param roomNumber The room to be booked
     * @param numGuests The number of guests
     * @param checkInDate The check in date
     * @param checkOutDate The check out date
     */
    public void bookHotel(Hotel hotel, Room room, int numGuests,
    LocalDate checkInDate, LocalDate checkOutDate) {
        String roomNumber = room.getNumber();
        hotel.book(roomNumber);
        addHotelReservation(new HotelReservation(hotel, this.firstName,
        this.lastName, room, room.getPrice(), checkInDate, checkOutDate,
        numGuests));
        // TODO Make these changes reflect in the database
    }

    /**
     * Unbook a hotel room
     * Unbooks the room from the hotel
     * @param reservation
     */
    public void unBookHotel(HotelReservation reservation) {
        Hotel hotel = reservation.getHotel();
        String roomNumber = reservation.getRoom().getNumber();
        hotel.unBook(roomNumber);
        removeHotelReservation(reservation);
        // TODO Make changes reflect in database
    }

    /**
     * Unbooks a flight
     * Unbooks the seat from the flight
     * @param ticket The ticket to unbook
     */
    public void unBookFlight(Ticket ticket) {
        Flight flight = ticket.getFlight();
        String seatNum = ticket.getSeat().getNumber();
        flight.unBook(seatNum);
        removeTicket(ticket);
        // TODO Make changes reflect in database
    }

    /**
     * Add a black listed airport to blackListedAirports
     * @param blackListedAirport The airport to be added
     */
    public void addBlackListedAirport(String blackListedAirport) {
        blackListedAirports.add(blackListedAirport);
    }

    /**
     * Add ticket to users tickets
     * @param ticket The ticket to be added
     */
    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    /**
     * Add hotel reservation to users hotel reservations
     * @param hotelReservation The hotel reservation to be added
     */
    public void addHotelReservation(HotelReservation hotelReservation) {
        hotelReservations.add(hotelReservation);
    }

    /**
     * Add friend to users friends
     * @param friend The friend to add
     */
    public void addFriend(Friend friend) {
        friends.add(friend);
    }

    /**
     * Remove a black listed airport to blackListedAirports
     * @param blackListedAirport The airport to be removed
     */
    public void removeBlackListedAirport(String blackListedAirport) {
        blackListedAirports.remove(blackListedAirport);
    }

    /**
     * Remove ticket from tickets
     * @param ticket The ticket to be removed
     */
    public void removeTicket(Ticket ticket) {
        tickets.remove(ticket);
    }

    /**
     * Remove hotel reservation from hotel reservations
     * @param hotelReservation The reservation to be removed
     */
    public void removeHotelReservation(HotelReservation hotelReservation) {
        hotelReservations.remove(hotelReservation);
    }

    /**
     * Remove friend from the friends
     * @param friend Friend to be removed
     */
    public void removeFriend(Friend friend) {
        friends.remove(friend);
    }
    
    // Getters

    /**
     * Get the UUID
     * @return userID
     */
    public UUID getUUID() {
        return userID;
    }
    
    /**
     * Get the first name
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Get the last name
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Get the email
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Get the age
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * Get the address
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Get the password
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Get the gender
     * @return gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * Get the preferred airport
     * @return preferredAirport
     */
    public String getPreferredAirport() {
        return preferredAirport;
    }

    /**
     * Get the frequent flyer status
     * @return frequentFlyer
     */
    public boolean getFrequentFlyer() {
        return frequentFlyer;
    }

    /**
     * Get the admin status
     * @return admin
     */ 
    public boolean getAdmin() {
        return admin;
    }

    /**
     * Get the medical condition status
     * @return medicalCondition
     */
    public boolean getMedicalCondition() {
        return medicalCondition;
    }

    /**
     * Get the black listed airports
     * @return blackListedAirports
     */
    public ArrayList<String> getBlackListedAirports() {
        return blackListedAirports;
    }

    /**
     * Get the tickets
     * @return tickets
     */
    public ArrayList<Ticket> getTickets() {
        return tickets;
    }

    /**
     * Get the hotel reservations
     * @return hotelReservations
     */
    public ArrayList<HotelReservation> getHotelReservations() {
        return hotelReservations;
    }

    /**
     * Get the friends
     * @return friends
     */
    public ArrayList<Friend> getFriends() {
        return friends;
    }

    // Setters

    /**
     * Set the UUID
     * @param userID UUID to be set
     */
    public void setUserID(UUID userID) {
        if (userID != null)
            this.userID = userID;
        else
            this.userID = UUID.randomUUID();
    }

    /**
     * Set the first name 
     * @param firstName The first name
     */
    public void setFirstName(String firstName) {
        if (firstName != null)
            this.firstName = firstName;
        else
            this.firstName = "";
    }

    /**
     * Set the last name
     * @param lastName The last name 
     */
    public void setLastName(String lastName) {
        if (lastName != null)
            this.lastName = lastName;
        else
            this.lastName = "";
    }

    /**
     * Set the email
     * @param email The email
     */
    public void setEmail(String email) {
        if (email != null)
            this.email = email;
        else
            this.email = "";
    }

    /**
     * Set the age 
     * @param age The age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Set the address
     * @param address The address
     */
    public void setAddress(String address) {
        if (address != null)
            this.address = address;
        else
            this.address = "";
    }

    /**
     * Set the password
     * @param password The password
     */
    public void setPassword(String password) {
        if (password != null)
            this.password = password;
        else
            this.password = "";
    }

    /**
     * Set the gender
     * @param gender The gender
     */
    public void setGender(String gender) {
        if (gender != null)
            this.gender = gender;
        else
            this.gender = "";
    }

    /**
     * Set the preferred airport
     * @param preferredAirport The preferred airport
     */
    public void setPreferredAirport(String preferredAirport) {
        if (preferredAirport != null)
            this.preferredAirport = preferredAirport;
        else
            this.preferredAirport = "";
    }

    /**
     * Set the frequent flyer status
     * @param frequentFlyer Frequent flyer status
     */
    public void setFrequentFlyer(boolean frequentFlyer) {
        this.frequentFlyer = frequentFlyer;
    }

    /**
     * Set the admin status
     * @param admin The admin status
     */
    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    /**
     * Set the medical condition status
     * @param medicalCondition The medical condition status
     */
    public void setMedicalCondition(boolean medicalCondition) {
        this.medicalCondition = medicalCondition;
    }

    /**
     * Set the black listed airports
     * @param blackListedAirports The black listed airports
     */
    public void setBlackListedAirports(ArrayList<String> blackListedAirports) {
        if (blackListedAirports != null)
            this.blackListedAirports = blackListedAirports;
        else
            this.blackListedAirports = new ArrayList<String>();
    }

    /**
     * Set the tickets
     * @param tickets The tickets
     */
    public void setTickets(ArrayList<Ticket> tickets) {
        if (tickets != null)
            this.tickets = tickets;
        else
            this.tickets = new ArrayList<Ticket>();
    }

    /**
     * Set the hotel reservations 
     * @param hotelReservations The hotel reservations
     */
    public void setHotelReservations(ArrayList<HotelReservation> hotelReservations) {
        if (hotelReservations != null)
            this.hotelReservations = hotelReservations;
        else
            this.hotelReservations = new ArrayList<HotelReservation>();
    }

    /**
     * Set the friends
     * @param friends The friends
     */
    public void setFriends(ArrayList<Friend> friends) {
        if (friends != null)
            this.friends = friends;
        else
            this.friends = new ArrayList<Friend>();
    }
}