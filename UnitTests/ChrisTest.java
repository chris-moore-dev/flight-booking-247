/**
 * This class calls the following unit tests:
 * HotelTest, RegisteredUserTest
 * @author Chris Moore
 */
public class ChrisTest {
  public static void main(String[] args) {
    System.out.println("-----Hotel test cases:-----");
    HotelTest hotelTest = new HotelTest();
    hotelTest.test();
    System.out.println("-----RegisteredUser test cases:-----");
    RegisteredUserTest registeredUserTest = new RegisteredUserTest();
    registeredUserTest.test();
  }
}
