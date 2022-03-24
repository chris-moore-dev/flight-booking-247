/**
 * DataConstants
 * @author Evan Scales
 */
public abstract class DataConstants {
    // Mac keep file name path as "json/object.json"
    // Windows do "flight-booking/json/object.json"

    // Flights
    protected static final String FLIGHTS_FILE_NAME = "flight-booking/json/flights.json";
    protected static final String FLIGHTS_ID = "flightID";
    protected static final String FLIGHTS_COMPANY = "company";
    protected static final String FLIGHTS_DATE = "date";
    protected static final String FLIGHTS_DEPARTING_AIRPORT = "departingAirport";
    protected static final String FLIGHTS_DEST_AIRPORT = "destAirport";
    protected static final String FLIGHTS_TAKE_OFF_TIME = "takeOffTime";
    protected static final String FLIGHTS_LANDING_TIME = "landingTime";
    protected static final String FLIGHTS_TOTAL_TIME = "totalFlightTime";
    protected static final String FLIGHTS_LAYOVER = "layover";
    protected static final String FLIGHTS_DEPARTING_GATE = "departingGate";
    protected static final String FLIGHTS_DEST_GATE = "destGate";
    protected static final String FLIGHTS_FLIGHT_LIST = "flights";
    protected static final String FLIGHTS_NUM_STOPS = "numStops";
    protected static final String FLIGHTS_PRICING_LIST = "pricing";
    protected static final String FLIGHTS_INDIVIDUALBOOKINGS_LIST = "individualBookings";


    // Friends
    protected static final String FRIENDS_FILE_NAME = "flight-booking/json/friends.json";
    protected static final String FRIENDS_ID = "friendID";
    protected static final String FRIENDS_FIRST_NAME = "firstName";
    protected static final String FRIENDS_LAST_NAME = "lastName";
    protected static final String FRIENDS_AGE = "age";
    protected static final String FRIENDS_MEDICAL_CONDITION = "medicalCondition";
    protected static final String FRIENDS_GENDER = "gender";
    protected static final String FRIENDS_EMAIL = "email";
    protected static final String FRIENDS_ADDRESS = "address";


    // Hotels
    protected static final String HOTELS_FILE_NAME = "flight-booking/json/hotels.json";
    protected static final String HOTELS_ID = "hotelID";
    protected static final String HOTELS_COMPANY = "company";
    protected static final String HOTELS_CLOSEST_AIRPORT = "closestAirport";
    protected static final String HOTELS_ADDRESS = "address";
    protected static final String HOTELS_AMMENITIES_LIST = "ammenities";
    protected static final String HOTELS_PRICING_LIST = "pricing";
    protected static final String HOTELS_INDIVIDUALBOOKINGS_LIST = "individualBookings";
    protected static final String HOTELS_REVIEWS_LIST = "reviews";
    protected static final String HOTELS_CITY = "city";

    // Reservations
    protected static final String RESERVATIONS_FILE_NAME = "flight-booking/json/reservations.json";
    protected static final String RESERVATIONS_ID = "reservationID";
    protected static final String RESERVATIONS_HOTEL_ID = "hotelID";
    protected static final String RESERVATIONS_ROOM_ID = "roomID";
    protected static final String RESERVATIONS_PRICE = "price";
    protected static final String RESERVATIONS_FIRST_NAME = "firstName";
    protected static final String RESERVATIONS_LAST_NAME = "lastName";
    protected static final String RESERVATIONS_CHECK_IN_DATE = "checkInDate";
    protected static final String RESERVATIONS_CHECK_OUT_DATE = "checkOutDate";
    protected static final String RESERVATIONS_NUM_GUESTS = " numGuests";

    // Reviews
    protected static final String REVIEWS_FILE_NAME = "flight-booking/json/reviews.json";
    protected static final String REVIEWS_ID = "reviewID";
    protected static final String REVIEWS_USER_ID = "userID";
    protected static final String REVIEWS_COMMENT = "comment";
    protected static final String REVIEWS_RATING = "rating";


    // Rooms
    protected static final String ROOMS_FILE_NAME = "flight-booking/json/rooms.json";
    protected static final String ROOMS_ID = "roomID";
    protected static final String ROOMS_ROOM_NUMBER = "roomNumber";
    protected static final String ROOMS_BOOKED = "booked";
    protected static final String ROOMS_SMOKING = "smoking";
    protected static final String ROOMS_PRICE = "price";
    protected static final String ROOMS_ROOM_TYPE = "roomType";
    protected static final String ROOMS_NUM_BEDS = "numBeds";
    protected static final String ROOMS_BOOKED_DAYS_LIST = "bookedDays";

    // Seatings
    protected static final String SEATINGS_FILE_NAME = "flight-booking/json/seatings.json";
    protected static final String SEATINGS_ID = "seatID";
    protected static final String SEATINGS_SEAT_NUMBER = "seatNumber";
    protected static final String SEATINGS_BOOKED = "booked";
    protected static final String SEATINGS_MEDICAL_SEAT = "medicalSeat";
    protected static final String SEATINGS_PRICE = "price";
    protected static final String SEATINGS_CABIN = "cabin";

    // Tickets
    protected static final String TICKETS_FILE_NAME = "flight-booking/json/tickets.json";
    protected static final String TICKETS_ID = "ticketID";
    protected static final String TICKETS_FLIGHT_ID = "flightID";
    protected static final String TICKETS_SEAT_ID = "seatID";
    protected static final String TICKETS_PRICE = "price";
    protected static final String TICKETS_FIRST_NAME = "firstName";
    protected static final String TICKETS_LAST_NAME = "lastName";
    protected static final String TICKETS_BOARDING_GROUP = "boardingGroup";
    protected static final String TICKETS_BOARDTING_TME = "boardingTime";
    protected static final String TICKETS_CHECKED_BAGS = "checkedBags";
    protected static final String TICKETS_GATE = "gate";

    // Users
    protected static final String USERS_FILE_NAME = "flight-booking/json/users.json";
    protected static final String USERS_ID = "userID";
    protected static final String USERS_FIRST_NAME = "firstName";
    protected static final String USERS_LAST_NAME = "lastName";
    protected static final String USERS_EMAIL = "email";
    protected static final String USERS_AGE = "age";
    protected static final String USERS_ADDRESS = "address";
    protected static final String USERS_PASSWORD = "password";
    protected static final String USERS_GENDER = "gender";
    protected static final String USERS_PREFFERRED_AIRPORT = "preferredAirport";
    protected static final String USERS_FREQUENT_FLYER = "frequentFlyer";
    protected static final String USERS_ADMIN_STATUS = "admin";
    protected static final String USERS_MEDICAL_CONDITION = "medicalCondition";
    protected static final String USERS_BLACKLISTED_AIRPORTS = "blackListedAirports";
    protected static final String USERS_TICKETS_LIST = "tickets";
    protected static final String USERS_HOTEL_RESERVATIONS_LIST = "hotelReservations";
    protected static final String USERS_FRIENDS_LIST = "friends";

}
