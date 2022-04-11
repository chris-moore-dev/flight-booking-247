import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * This class contains the test cases for the class Hotel
 * @author Chris Moore
 */
public class HotelTest {
  Hotel hotel;
  Room room;

  // Empty ArrayLists & HashMaps for testing purposes
  ArrayList<Review> reviews = new ArrayList<>();
  ArrayList<String> amenities = new ArrayList<>();
  HashMap<String, Integer> pricing = new HashMap<>();
  HashMap<String, Room> rooms = new HashMap<>();

  @BeforeEach 
  public void setup() {
    // Add empty room to circumvent null room bug
    room = new Room(false, null, 0, false, 0, "", "");
    // Create default empty hotel
    rooms.put("", room);
    hotel = new Hotel("", reviews, amenities, "", "", "", pricing, rooms);
  }

  @AfterEach
  public void tearDown() {

  }

  @Test
  public void testCreateEmptyHotel() {
    hotel = new Hotel("", null, null, "", "", "", null, null);
    assertEquals("", hotel.getAddress());
  }

  @Test
  public void testCreateHotel() {
    hotel = new Hotel("123 Fake Street", reviews, amenities, "JFK", "NYC", "Hyatt Inc.", pricing, rooms);
    assertEquals("123 Fake Street", hotel.getAddress());
  }

  @Test
  public void testBook() {
    ArrayList<LocalDate> dates = new ArrayList<>();
    dates.add(LocalDate.now());
    hotel.book("", dates);
    assertEquals(dates, room.getBookedDays());
  }

  @Test
  public void testBookNullDate() {
    ArrayList<LocalDate> dates = new ArrayList<>();
    dates.add(null);
    hotel.book("", dates);
    assertEquals(dates, room.getBookedDays());
  }

  @Test
  public void testUnBook() {
    ArrayList<LocalDate> dates = new ArrayList<>();
    dates.add(LocalDate.now());
    hotel.book("", dates);
    hotel.unBook("", dates);
    ArrayList<LocalDate> noDates = new ArrayList<>();
    assertEquals(noDates, room.getBookedDays());
  }

  @Test
  public void testGetMatchingRoom() {
    rooms.clear();
    room = new Room(false, null, 0, false, 0, "coolRoom", "");
    rooms.put("", room);
    hotel = new Hotel("123 Fake Street", reviews, amenities, "JFK", "NYC", "Hyatt Inc.", pricing, rooms);
    Room testRoom = hotel.getMatchingRoom(LocalDate.now(), LocalDate.now(), "coolRoom");
    assertEquals(room, testRoom);
  }

  @ Test
  public void testGetConsecutiveDates() {
  LocalDate date1 = LocalDate.parse("2022-04-09");
  LocalDate date2 = LocalDate.parse("2022-04-10");
  LocalDate date3 = LocalDate.parse("2022-04-11");
  ArrayList<LocalDate> dates = new ArrayList<>();
  dates.add(date1); 
  dates.add(date2); 
  dates.add(date3);
  ArrayList<LocalDate> testDates = hotel.getConsecutiveDates(date1, date3);
  assertEquals(dates, testDates);
  }
}

