import java.util.ArrayList;

/**
 * The list of users
 * @author Mario Misencik
 */
public class UserList {
    private static UserList userList;
    private ArrayList<User> users;

    /**
     * The list of users
     */
    private UserList() {
        
    }

    /**
     * Returns the user list
     * @return The user list
     */
    public static UserList getInstance() {
        return userList;
    }

    /**
     * Retrives the user based on the email and password entered
     * @param email The user's email address
     * @param password The user's password
     * @return The user
     */
    public User getUser(String email, String password) {
        return new User();
    }

}