import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * This class contains the test cases for the class RegisteredUser
 * @author Chris Moore
 */
public class RegisteredUserTest {
  RegisteredUser user;
  Flight flight;
  Seating seat;
  Friend friend;
  Hotel hotel;
  Room room;

  // Empty ArrayLists & HashMaps for testing purposes
  ArrayList<String> blackListedAirports = new ArrayList<>();
  ArrayList<Ticket> tickets = new ArrayList<>();
  ArrayList<HotelReservation> hotelReservations = new ArrayList<>();
  ArrayList<Friend> friends = new ArrayList<>();
  HashMap<String, Integer> pricing  = new HashMap<>();
  ArrayList<Flight> flights = new ArrayList<>();
  ArrayList<Seating> seating = new ArrayList<>();
  ArrayList<Friend> ticketHolders = new ArrayList<>();
  ArrayList<Boolean> shouldDiscount = new ArrayList<>();
  HashMap<String, Room> rooms = new HashMap<>();
  Map<String, Seating> seats = new HashMap<>();
    
  @BeforeEach 
  public void setup() {
    // Create empty user for testing purposes
    user = new RegisteredUser("", "", "", 0, "", "", "", "", false, false, false, blackListedAirports, tickets, hotelReservations, friends);
  }

  @AfterEach
  public void tearDown() {

  }

  @Test
  public void testCreateRegisteredUser() {
    user = new RegisteredUser("John", "von Doe", "johnvondoe@gmail.com", 43, "123 Fake Street", "password123", "male", "LAX", false, false, false, blackListedAirports, tickets, hotelReservations, friends);
    assertEquals("John", user.getFirstName());
  }

  @Test
  public void testCreateEmptyRegisteredUser() {
    // Empty user is already created in setup()
    assertEquals("", user.getFirstName());
  }

  @Test
  public void testBookFlight() {
    user = new RegisteredUser("John", "von Doe", "johnvondoe@gmail.com", 43, "123 Fake Street", "password123", "male", "LAX", false, false, false, blackListedAirports, tickets, hotelReservations, friends);
    pricing.put("", 0);
    seat = new Seating(false, null, false, 0, "First", "1");
    seating.add(seat);
    seats.put("1", seat);
    flight = new Flight(LocalDate.now(), "LAX", "JFK", "12:00", "8:00", "8:00", true, "Southwest Airlines", pricing, seats, "4A", "8B");
    flights.add(flight);
    friend = new Friend("Jane", "von Doe", 41, false, "female", "janevondoe@gmail.com", "123 Fake Street");
    ticketHolders.add(friend);
    shouldDiscount.add(false);
    user.bookFlights(flights, seating, ticketHolders, shouldDiscount);
    ArrayList<Ticket> tickets = user.getTickets();
    assertEquals(flight, tickets.get(0).getFlight());
  }

  @Test
  public void testBookEmptyFlight() {
    user = new RegisteredUser("John", "von Doe", "johnvondoe@gmail.com", 43, "123 Fake Street", "password123", "male", "LAX", false, false, false, blackListedAirports, tickets, hotelReservations, friends);
    pricing.put("", 0);
    seat = new Seating(false, null, false, 0, "First", "1");
    seating.add(seat);
    seats.put("1", seat);
    flight = new Flight(null, "", "", "", "", "", false, "", null, null, "", "");
    flights.add(flight);
    friend = new Friend("Jane", "von Doe", 41, false, "female", "janevondoe@gmail.com", "123 Fake Street");
    ticketHolders.add(friend);
    shouldDiscount.add(false);
    user.bookFlights(flights, seating, ticketHolders, shouldDiscount);
    ArrayList<Ticket> tickets = user.getTickets();
    assertEquals(flight, tickets.get(0).getFlight());
  }

  @Test
  public void testUnBookFlight() {
    user = new RegisteredUser("John", "von Doe", "johnvondoe@gmail.com", 43, "123 Fake Street", "password123", "male", "LAX", false, false, false, blackListedAirports, tickets, hotelReservations, friends);
    pricing.put("", 0);
    seat = new Seating(false, null, false, 0, "First", "1");
    seating.add(seat);
    seats.put("1", seat);
    flight = new Flight(LocalDate.now(), "LAX", "JFK", "12:00", "8:00", "8:00", true, "Southwest Airlines", pricing, seats, "4A", "8B");
    flights.add(flight);
    friend = new Friend("Jane", "von Doe", 41, false, "female", "janevondoe@gmail.com", "123 Fake Street");
    ticketHolders.add(friend);
    shouldDiscount.add(false);
    user.bookFlights(flights, seating, ticketHolders, shouldDiscount);
    ArrayList<Ticket> tickets = user.getTickets();
    user.unBookFlight(tickets.get(0));
    ArrayList<Ticket> noTickets = new ArrayList();
    assertEquals(noTickets, tickets);
  }

  @Test
  public void testBookHotel() {
    user = new RegisteredUser("John", "von Doe", "johnvondoe@gmail.com", 43, "123 Fake Street", "password123", "male", "LAX", false, false, false, blackListedAirports, tickets, hotelReservations, friends);
    room = new Room(false, null, 0, false, 0, "", "");
    rooms.put("", room);
    hotel = new Hotel("", null, null, "", "", "", null, rooms);
    user.bookHotel(hotel, room, 0, LocalDate.now(), LocalDate.parse("2022-04-11"));
    ArrayList<HotelReservation> reservations = user.getHotelReservations();
    assertEquals(hotel, reservations.get(0).getHotel());
  }

  @Test
  public void testBookEmptyHotel() {
    user = new RegisteredUser("John", "von Doe", "johnvondoe@gmail.com", 43, "123 Fake Street", "password123", "male", "LAX", false, false, false, blackListedAirports, tickets, hotelReservations, friends);
    room = new Room(false, null, 0, false, 0, "", "");
    rooms.put("", room);
    hotel = new Hotel("", null, null, "", "", "", null, rooms);
    user.bookHotel(hotel, room, 0, null, null);
    ArrayList<HotelReservation> reservations = user.getHotelReservations();
    assertEquals(hotel, reservations.get(0).getHotel());
  }


  @Test
  public void testUnBookHotel() {
    user = new RegisteredUser("John", "von Doe", "johnvondoe@gmail.com", 43, "123 Fake Street", "password123", "male", "LAX", false, false, false, blackListedAirports, tickets, hotelReservations, friends);
    room = new Room(false, null, 0, false, 0, "", "");
    rooms.put("", room);
    hotel = new Hotel("", null, null, "", "", "", null, rooms);
    user.bookHotel(hotel, room, 0, LocalDate.now(), LocalDate.parse("2022-04-11"));
    ArrayList<HotelReservation> reservations = user.getHotelReservations();
    user.unBookHotel(reservations.get(0));
    ArrayList<HotelReservation> noReservations = new ArrayList<>();
    assertEquals(noReservations, reservations);
  }

  @Test
  public void testGetConsecutiveDates() {
  LocalDate date1 = LocalDate.parse("2022-04-09");
  LocalDate date2 = LocalDate.parse("2022-04-10");
  LocalDate date3 = LocalDate.parse("2022-04-11");
  ArrayList<LocalDate> dates = new ArrayList<>();
  dates.add(date1); 
  dates.add(date2); 
  dates.add(date3);
  ArrayList<LocalDate> testDates = user.getConsecutiveDates(date1, date3);
  assertEquals(dates, testDates);
  }
}