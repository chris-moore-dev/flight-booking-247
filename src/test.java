import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

/**
 * test
 */
public class test {

    public static void main(String[] args) {
        FlightList flightList = FlightList.getInstance();
        HotelList hotelList = HotelList.getInstance();
        UserList userList = UserList.getInstance();

        ArrayList<Flight> flights = flightList.getFlights();
        ArrayList<Hotel> hotels = hotelList.getHotels();
        ArrayList<RegisteredUser> users = userList.getUsers();

        // String toSplit = "Standard:45";
        // String[] split = toSplit.split(":");
        // System.out.println(split[0]);
        // System.out.println(split[1]);
        testUserList(users.get(0));
        System.out.println(UUID.randomUUID());
    }

    /**
     * Testing UserList
     * Loading user by its self: PASS
     * Loading user with blackListed airports: PASS
     * Loading users with friends: PASS
     * Loading users tickets:
     * Loading users with reservations: 
     * @pram user The users being tested
     */
    public static void testUserList(RegisteredUser user) {
        // Loading users by itself
        System.out.println(user.getFirstname());

        System.out.println(user.getAdmin());

        // Loading user with blackListed airports
        ArrayList<String> blackListedAirports = user.getBlackListedAirports();
        for (String blackListedAirport : blackListedAirports) {
            System.out.println(blackListedAirport);
        }

        // Loading user with friends
        ArrayList<Friend> friends = user.getFriends();
        for (Friend friend : friends) {
            System.out.println(friend);
        }
    }

    
    
}