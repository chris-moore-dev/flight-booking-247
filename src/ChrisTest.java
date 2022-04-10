/**
 * This class calls the following unit tests:
 * FlightTest, HotelTest, RegisteredUserTest, TicketTest, and RoomTest
 * @author Chris Moore
 */
public class ChrisTest {
  public static void main(String[] args) {
    FlightTest flightTest = new FlightTest();
    flightTest.test();
    HotelTest hotelTest = new HotelTest();
    hotelTest.test();
    RegisteredUserTest registeredUserTest = new RegisteredUserTest();
    registeredUserTest.test();
    TicketTest ticketTest = new TicketTest();
    ticketTest.test();
    RoomTest roomTest = new RoomTest();
    roomTest.test();
  }
}
