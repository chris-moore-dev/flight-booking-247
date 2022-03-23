import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

/**
 * test
 */
public class test {

    public static void main(String[] args) {
        UserList userList = UserList.getInstance();

        ArrayList<RegisteredUser> users = userList.getUsers();

        
        testUserList(users.get(0));
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

        // Loading user with blackListed airports
        ArrayList<String> blackListedAirports = user.getBlackListedAirports();
        for (String blackListedAirport : blackListedAirports) {
            System.out.println(blackListedAirport);
        }

        // Loading user with friends
        ArrayList<Friend> friends = user.getFriends();
        for (Friend friend : friends) {
            System.out.println(friend.getFirstName());
        }
    }
    
}