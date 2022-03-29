import java.util.Scanner;
import java.util.ArrayList;

/**
 * FlightSystemUI
 * This class doesn't include much UI functionality in and of itself,
 * but sets up the baseline menu instance which then refers to FlightSystem
 * and included objects to perform UI tasks from user input.
 * @author Chris Moore, Lyn Cork
 */
public class FlightSystemUI {
  private Scanner scanner = new Scanner(System.in);
  private FlightSystem system = new FlightSystem();
  private RegisteredUser currentUser = new RegisteredUser();

/**
 * Displays logged-out user menu by default.
 * MENU AVAILABLE FOR DEBUGGING PURPOSES ONLY
 */
  public void run() {
    System.out.println("Welcome to the UI Debugger. Please select the menu to test:\n" +
    "1. Guest Menu\n2. Registered User Menu\n3. Administrator Menu");
    int menuSelect = scanner.nextInt();
    switch(menuSelect) {
      case 1: generateTestUser();
      displayMenuUser();
      break;
      case 2: generateTestUser();
      displayMenuRegisteredUser();
      break;
      case 3: generateTestUser();
      currentUser.setAdmin(true);
      displayMenuAdmin();
      break;
    }
  }

  /**
   * Creates an example user for testing purposes
   */
  private void generateTestUser() {
    ArrayList<String> blackListedAirports = new ArrayList<>();
    ArrayList<Ticket> tickets = new ArrayList<>();
    ArrayList<HotelReservation> hotelReservations = new ArrayList<>();
    ArrayList<Friend> friends = new ArrayList<>();
    RegisteredUser testUser = new RegisteredUser("John", "Doe", "johndoe@gmail.com", 41, "123 Fake Street, SC, USA, 29201", "password", "Male", 
    "LAX", true, false, false, blackListedAirports, 
    tickets, hotelReservations, friends);
    currentUser = testUser;
  }

/**
 * Initial display for unregistered (or logged-out) users.
 */
  public void displayMenuUser() {
    while(true){
      System.out.println("Welcome to our Flight and Hotel Booker!\n" + 
      "You are not logged in.\n\n" +
      "************ Main Menu ************\n" +
      "1. Search Flights\n2. Search Hotels\n3. Create Account\n4. Login\n5. Exit\n\n" +
      "What would you like to do?:");
      boolean loop = true;
      int select = scanner.nextInt();
      switch(select) {
        case 1: system.searchForFlights(currentUser);
        break;
        case 2: system.searchForHotels(currentUser);
        break;
        case 3: system.createAccount();
                while(loop) {
                  currentUser = system.login();
                  if (currentUser != null) {
                    loop = false;
                    if(currentUser.getAdmin()) {
                      displayMenuAdmin();
                    }
                    else {
                      displayMenuRegisteredUser();
                    }
                  }
                  else {
                    System.out.println("Login failed, please try again!");
                  }
                }
                break;
        case 4: while(loop) {
                  currentUser = system.login();
                  if (currentUser != null) {
                    loop = false;
                    if(currentUser.getAdmin()) {
                      displayMenuAdmin();
                    }
                    else {
                      displayMenuRegisteredUser();
                    }
                  }
                  else {
                    System.out.println("Login failed, please try again!\n");
                  }
                }
                break;
        case 5: system.logout();
        break;
        default: System.out.println("Invalid input, please try again!\n");
        break;
      }
      continue;
    }
  }

/**
 * Display menu for registered users, once they have logged in.
 */
  private void displayMenuRegisteredUser() {
    while(true) {
      System.out.println("Welcome to our Flight and Hotel Booker!\n" +
      "Hello, " + currentUser.getFirstName() + " " + currentUser.getLastName() + ". You are logged in as a regular user.\n\n" +
      "************ Main Menu ************\n" +
      "1. Search Flights\n2. Search Hotels\n3. Manage Account\n4. Logout\n\n" +
      "What would you like to do?: ");
      int select = scanner.nextInt();
      switch(select) {
        case 1: system.searchForFlights(currentUser);
        break;
        case 2: system.searchForHotels(currentUser);
        break;
        case 3: system.manageAccount(currentUser);
        break;
        case 4: system.logout();
        break;
        default: System.out.println("Invalid input, please try again!\n");
        break;
      }
      continue;
    }
  }

/**
 * Display menu for administrators, once they have logged in.
 */
  private void displayMenuAdmin() {
    while(true) {
      if(currentUser.getAdmin() != true) {
        System.out.println("<ERROR>: You are not signed in as an administrator. Logging out...");
        System.exit(0);
      }
      System.out.println("Welcome to our Flight and Hotel Booker!\n"+
      "Hello, " + currentUser.getFirstName() + " " + currentUser.getLastName() + ". You are logged in as an administrator.\n\n" +
      "************ Main Menu ************\n" +
      "1. Search Flights\n2. Search Hotels\n3. Manage Account\n4. Add Flight\n"  +
      "5. Edit Flight\n6. Remove Flight\n7. Add Hotel\n8. Edit Hotel\n" +
      "9. Remove Hotel\n0. Logout\n\nWhat would you like to do?: ");
      int select = scanner.nextInt();
      switch(select) {
        case 1: system.searchForFlights(currentUser);
        break;
        case 2: system.searchForHotels(currentUser);
        break;
        case 3: system.manageAccount(currentUser);
        break;
        case 4: system.addFlight();
        break;
        case 5: system.editFlight();
        break;
        case 6: system.removeFlight();
        break;
        case 7: system.addHotel();
        break;
        case 8: system.editHotel();
        break;
        case 9: system.removeHotel();
        break;
        case 0: system.logout();
        break;
        default: System.out.println("Invalid input, please try again!\n");
        break;
      }
      continue;
    }
  }
}
