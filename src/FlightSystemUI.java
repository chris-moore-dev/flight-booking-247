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
  private FlightSystem system;

  public static void main(String[] args) {
    FlightSystemUI systemInterface = new FlightSystemUI();
    systemInterface.run();
  }

  FlightSystemUI() {
    system = new FlightSystem();
  }

  public void run() {
    boolean loop = true;
    User freeUser;
    RegisteredUser registeredUser;

    while(loop) {
      freeUser = system.getFreeUser();
      registeredUser = system.getRegisteredUser();

      if (freeUser != null) {
        displayMenuUser();
      } else if (registeredUser != null && !(registeredUser.getAdmin())) {
        displayMenuRegisteredUser();
      } else {
        displayMenuAdmin();
      }

      DataWriter.saveDatabase();
    }
  }

  private void displayMenuAdmin() {
    System.out.print("Welcome to our Flight and Hotel Booker!\n"+
    "\nHello, " + system.getRegisteredUser().getFirstName() + " " + system.getRegisteredUser().getLastName() + ". You are logged in as an administrator.\n\n" +
    "************ Main Menu ************\n" +
    "1. Search Flights\n2. Search Hotels\n3. Manage Account\n4. Add Flight\n"  +
    "5. Edit Flight\n6. Remove Flight\n7. Add Hotel\n8. Edit Hotel\n" +
    "9. Remove Hotel\n0. Logout\n\nWhat would you like to do?: ");

    String sOption = scanner.nextLine();
    int option = Integer.parseInt(sOption);

    switch (option) {
      case 1:
        
        break;
      case 2:
        break;
      case 3:
        break;
      case 4:
        break;
      case 5:
        break;
      case 6:
        break;
      case 7:
        break;
      case 8:
        break;
      case 9:
        break;
      case 0:
        system.setFreeUser(new User());
        system.setRegisteredUser(null);
        break;
      default:
        System.out.println("Invalid input, please try again!\n");
        break;
    }
  }

  private void displayMenuRegisteredUser() {
    System.out.print("Welcome to our Flight and Hotel Booker!\n" +
    "\nHello, " + system.getRegisteredUser().getFirstName() + " " + system.getRegisteredUser().getLastName() + ". You are logged in as a regular user.\n\n" +
    "************ Main Menu ************\n" +
    "1. Search Flights\n2. Search Hotels\n3. Manage Account\n4. Logout\n5. Exit\n\n" +
    "What would you like to do?: ");

    String sOption = scanner.nextLine();
    int option = Integer.parseInt(sOption);

    switch (option) {
      case 1:
        system.evanSearchForFlights();
        break;
      case 2:
        break;
      case 3:
        break;
      case 4:
        system.setFreeUser(new User());
        system.setRegisteredUser(null);
        break;
      case 5:
        System.exit(0);
      default: 
        System.out.println("Invalid input, please try again!\n");
        break;
    }

  }

  private void displayMenuUser() {
    System.out.print("Welcome to our Flight and Hotel Booker!\n" + 
    "\nYou are not logged in.\n\n" +
    "************ Main Menu ************\n" +
    "1. Search Flights\n2. Search Hotels\n3. Create Account\n4. Login\n5. Exit\n\n" +
    "What would you like to do?: ");
    
    String sOption = scanner.nextLine();
    int option = Integer.parseInt(sOption);



    switch (option) {
      case 1:
        system.evanSearchForFlights();
        break;
      case 2:
        break;
      case 3:
        system.createAccount();
        break;
      case 4:
        RegisteredUser changeTo = system.login();
        if (changeTo != null) {
          system.setRegisteredUser(changeTo);
          system.setFreeUser(null);
        }
        break;
      case 5:
        System.exit(0);
      default: 
        System.out.println("Invalid input, please try again!\n");
        break;
    }
  }

/**
 * Displays logged-out user menu by default.
 * MENU AVAILABLE FOR DEBUGGING PURPOSES ONLY
 */
  
  
}
