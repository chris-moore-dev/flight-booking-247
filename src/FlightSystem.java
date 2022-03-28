import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * FlightSystem
 * @author Chris Moore, Lyn Cork, Evan Scales
 */
public class FlightSystem {
  private FlightList flightList;
  private Scanner scanner = new Scanner(System.in);
  private UserList userList;
  private HotelList hotelList;
  private User user;
  private Admin admin;
/**
 * 
 */
  public FlightSystem() {
    
  }
/**
 * Logs the user in after a username and password check
 * @return RegisteredUser object, or null if login fails
 */
  public RegisteredUser login() {
    System.out.println("----- Log In -----\n"+
    "Enter email: ");
    String email = scanner.nextLine();
    System.out.println("Enter password: ");
    String password = scanner.nextLine();
    if(userList.getUser(email, password) != null) {
      RegisteredUser user = userList.getUser(email, password);
      return user;
    }
    else {
      return null;
    }
  }

/**
 * Prompts the user to input account information,
 * creates a new RegisteredUser()
 */
  public void createAccount() {
    // Default values of RegisteredUser account attributes 
    // most will be left with default values as per design document
    String firstName;
    String lastName;
    String email;
    int age;
    String address;
    String password = "default";
    String gender;
    String preferredAirport = "";
    boolean frequentFlyer = false;
    boolean admin = false;
    boolean medicalCondition = false;
    ArrayList<String> blackListedAirports = new ArrayList<>();
    ArrayList<Ticket> tickets = new ArrayList<>();
    ArrayList<HotelReservation> hotelReservations = new ArrayList<>();
    ArrayList<Friend> friends = new ArrayList<>();

    // NAME + AGE
    System.out.println("----- Enter the Following Information -----\n" +
    "----- Your Name -----\n"+
    "First name: ");
    firstName = scanner.nextLine();
    System.out.println("Last name: ");
    lastName = scanner.nextLine();
    System.out.println("Age: ");
    age = scanner.nextInt();

    // GENDER
    System.out.println("----- Your Gender -----\n"+
    "1. Male\n"+
    "2. Female\n"+
    "3. Unspecified\n"+
    "4. Undisclosed\n\n"+
    "Select your gender: ");
    int genderSelect = scanner.nextInt();
    switch(genderSelect) {
      case 1: gender = "Male";
      case 2: gender = "Female";
      case 3: gender = "Unspecified";
      case 4: gender = "Undisclosed";
      default: gender = "Undisclosed";
    }

    // ADDRESS
    System.out.println("----- Your Address -----\n"+
    "Country: ");
    String country = scanner.nextLine();
    System.out.println("Street: ");
    String street = scanner.nextLine();
    System.out.println("City: ");
    String city = scanner.nextLine();
    System.out.println("State: ");
    String state = scanner.nextLine();
    System.out.println("Postal Code: ");
    String postal = scanner.nextLine();
    address = street + ", " + city + ", " + state + ", " + country + ", " + postal;

    // EMAIL
    System.out.println("----- Your Email -----\n"+
    "Email: ");
    email = scanner.nextLine();

    // PASSWORD
    System.out.println("----- Create Your Password -----");
    boolean noMatch = true;
    while(noMatch) {
      String password1 = "default";
      String password2 = "default";
      System.out.println("Password: ");
      password1 = scanner.nextLine();
      System.out.println("Confirm Password: ");
      password2 = scanner.nextLine();
      if(password1.equals(password2)) {
        noMatch = false;
        password = password1;
      }
      else {
        System.out.println("Passwords do not match. Please try again.");
      }
    }

    // Create account with user-input attributes, 
    // with default values where applicable
    new RegisteredUser(firstName, lastName, email, age, address, password, gender, 
    preferredAirport, frequentFlyer, admin, medicalCondition, blackListedAirports, 
    tickets, hotelReservations, friends);
    System.out.println("Account succesfully created. You will now be prompted to log in.");
  }

/**
 * Allows the user to view and edit
 * several aspects of their account, including
 * tickets, reservations, preferences, and friends.
 */
  public void manageAccount() {
    
  }

/**
 * Logs the user out and exits the terminal
 */
  public void logout() {
    System.out.println("Thank you for using our Flight and Hotel Booker!\n"+
    "You will now be logged out.");
    System.exit(0);
  }

/**
 * Allows the user to search for flights by certain parameters
 */
  public void searchForFlights() {
    
  }

/**
 * Allows the user to search for hotels by certain parameters
 */
  public void searchForHotels() {
    
  }

  /**
   * Prints the ticket to a file
   * @param ticket The ticket to be printed to a file
   */
  public void printTicketToFile(Ticket ticket) {
    // Probably same as data loader
    // Windows do flight-booking/TextFiles/file.txt
    // Mac do TextFiles/file.txt

    try {
      String name = ticket.getReservationHolderFirstName() + ticket.getReservationHolderLastName();
      String fileName = "flight-booking/TextFiles/ticket" + name + ticket.getID() + ".txt";
      File printTo = new File(fileName);
      if (printTo.createNewFile()) {
        FileWriter fileWriter = new FileWriter(printTo);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.print(ticket);
        printWriter.close();
      } else {
        System.out.println("File exists, look for the file");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Prints the hotel reservation to a file
   * @param reservation The hotel reservation
   */
  public void printHotelReservationToFile(HotelReservation reservation) {
    // Probably same as data loader
    // Windows do flight-booking/TextFiles/file.txt
    // Mac do TextFiles/file.txt
    try {
      String name = reservation.getReservationHolderFirstName() + reservation.getReservationHolderLastName();
      String fileName = "flight-booking/TextFiles/hotelReservation" + name + reservation.getID() + ".txt";
      File printTo = new File(fileName);
      if (printTo.createNewFile()) {
        FileWriter fileWriter = new FileWriter(printTo);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.print(reservation);
        printWriter.close();
      } else {
        System.out.println("File exists, look for the file");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }


}
