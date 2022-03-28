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
  private static RegisteredUser currentUser;

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
      case 2: system.searchForHotels();
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
      default: System.out.println("Invalid input, please try again!");
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
      case 1: system.searchForFlights();
      case 2: system.searchForHotels();
      case 3: system.manageAccount();
      case 4: system.logout();
      default: System.out.println("Invalid input, please try again!");
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
    "5. Add Hotel\n6.Edit Hotel\n7.Edit Flight\n8.Remove Flight\n" +
    "9. Remove Hotel\n0. Logout\nWhat would you like to do?: ");
    switch(select) {
      case 1: system.searchForFlights();
      case 2: system.searchForHotels();
      case 3: system.manageAccount();
      //case 4: system.addFlight();
      //case 5: system.addHotel();
      //case 6: system.editHotel();
      //case 7: system.editFlight();
      //case 8: system.removeFlight();
      //case 9: system.removeHotel();
      case 0: system.logout();
      default: System.out.println("Invalid input, please try again!");
    }
  }
}
