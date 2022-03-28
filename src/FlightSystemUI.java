import java.util.Scanner;

/**
 * FlightSystemUI
 * This class doesn't include much UI functionality in and of itself,
 * but sets up the baseline menu instance which then refers to FlightSystem
 * and included objects to perform UI tasks from user input.
 * @author Chris Moore, Lyn Cork
 */
public class FlightSystemUI {
  private Scanner scanner = new Scanner(System.in);
  private FlightSystem system;
  private RegisteredUser currentUser;

/**
 * Displays logged-out user menu by default.
 */
  public void run() {
    {
      displayMenuUser();
    }
  }

/**
 * Initial display for unregistered (or logged-out) users.
 */
  private void displayMenuUser() {
    System.out.println("Welcome to our Flight and Hotel Booker!\n" + 
    "You are not logged in.\n" +
    "************ Main Menu ************\n" +
    "1. Search Flights\n2. Search Hotels\n3. Create Account\n4. Login\n" +
    "What would you like to do?:");
    boolean loop = true;
    int select = scanner.nextInt();
    switch(select) {
      case 1: system.searchForFlights();
      break;
      case 2: system.searchForHotels();
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
                  System.out.println("Login failed, please try again!");
                }
              }
              break;
      default: System.out.println("Invalid input, please try again!");
      break;
    }
  }

/**
 * Display menu for registered users, once they have logged in.
 */
  private void displayMenuRegisteredUser() {
    int select = scanner.nextInt();
    System.out.println("Welcome to our Flight and Hotel Booker!\n" +
    "You are logged in as a regular user.\n" +
    "************ Main Menu ************\n" +
    "1. Search Flights\n2. Search Hotels\n3. Manage Account\n4. Logout\n" +
    "What would you like to do?: ");
    switch(select) {
      case 1: system.searchForFlights(currentUser);
      break;
      case 2: system.searchForHotels(currentUser);
      break;
      case 3: system.manageAccount(currentUser);
      break;
      case 4: system.logout();
      break;
      default: System.out.println("Invalid input, please try again!");
      break;
    }
  }

/**
 * Display menu for administrators, once they have logged in.
 */
  private void displayMenuAdmin() {
    
    int select = scanner.nextInt();
    System.out.println("Welcome to our Flight and Hotel Booker!\n"+
    "You are logged in as an administrator.\n" +
    "************ Main Menu ************\n" +
    "1. Search Flights\n2. Search Hotels\n3. Manage Account\n4. Add Flight\n"  +
    "5. Edit Flight\n6.Remove Flight\n7.Add Hotel\n8.Edit Hotel\n" +
    "9. Remove Hotel\n0. Logout\nWhat would you like to do?: ");
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
      default: System.out.println("Invalid input, please try again!");
      break;
    }
  }
}
