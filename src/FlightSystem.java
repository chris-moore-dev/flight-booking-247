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
 * This class contains the bulk of the functionality for the program's
 * user interface. Essentially, every way the user can interact
 * with the program is filtered through here to allow input and output.
 * @author Chris Moore, Lyn Cork, Evan Scales
 */
public class FlightSystem {
  private Scanner scanner = new Scanner(System.in);
  private UserList userList = UserList.getInstance();
  private HotelList hotelList;
  private FlightList flightList;
  DateTimeFormatter format = DateTimeFormatter.ofPattern("MM-dd-yyyy");
  
/**
 * Default constructor for FlightSystem
 */
  public FlightSystem() {
    
  }

/* 
===================
  USER FUNCTIONS
===================
*/

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
      System.out.println("Incorrect username or password. Please try again.");
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
    System.out.println("----- Enter the Following Information -----\n\n" +
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
      break;
      case 2: gender = "Female";
      break;
      case 3: gender = "Unspecified";
      break;
      case 4: gender = "Undisclosed";
      break;
      default: gender = "Undisclosed";
      break;
    }
    // ADDRESS
    System.out.println("----- Your Address -----");
    System.out.println("Country:");
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
    RegisteredUser saveThis = new RegisteredUser(firstName, lastName, email, age, address, password, gender, 
    preferredAirport, frequentFlyer, admin, medicalCondition, blackListedAirports, 
    tickets, hotelReservations, friends);
    //Write saveThis to Users.json 
    System.out.println("Account succesfully created. You can now log in.");
  }



/**
 * Allows the user to view and edit
 * several aspects of their account, including
 * tickets, reservations, preferences, and friends.
 */
  public void manageAccount(RegisteredUser user) {
    while(true){
      String isFF = "not ";
      if(user.getFrequentFlyer()) {
        isFF = "";
      }
      System.out.println("----- My Account -----");
      System.out.println("You are " + isFF + "a frequent flyer.\n\n" +
      "1. View Plane Tickets\n2. View Hotel Reservations\n3. View Preferences\n" +
      "4. View Linked People Options\n5. Return to Menu\n\n" +"What would you like to do?: ");
      int mainSelect = scanner.nextInt();
      boolean endLoop = false;
      switch(mainSelect) {
        case 1: viewTickets(user);
          break;
        case 2: viewReservations(user);
          break;
        case 3: viewPreferences(user);
          break;
        case 4: viewLinkedPeople(user);
          break;
        case 5: break;
        default: System.out.println("Invalid input, please try again!");
          break;
      }
      if(mainSelect == 5) {
        break;
      }
      else {
        continue;
      }
    }
  }

  /**
   * Sub-method of ManageAccount(), allows user to view plane tickets
   * @param user Current RegisteredUser instance
   */
  public void viewTickets(RegisteredUser user) {
    while(true) {
      System.out.println("----- Plane Tickets -----");
      ArrayList<Ticket> tickets = user.getTickets();
      for(int i = 0; i < tickets.size(); i++) {
        System.out.println(i+1 + ". " + tickets.get(i));
      }
      System.out.println("Which ticket would you like to view? (Enter 0 to return to menu):");
      int view = scanner.nextInt();
      if(view == 0) {
        manageAccount(user);
      }
      else {
        tickets.get(view-1).toString();
      }
      System.out.println("1. Cancel ticket and request refund\n2. Add checked baggage\n" + 
      "3. Return to menu\nWhat would you like to do?:");
      int select = scanner.nextInt();
      switch(select) {
        case 1: tickets.remove(view-1);
        System.out.println("Your ticket has been cancelled. A refund will be issued to your account.");
        manageAccount(user);
        break;
        case 2: System.out.println("----- Enter the Following Information -----\n Weight of bag (lbs):");
        double weight = scanner.nextDouble();
        // Is there anywhere to store a bags' weight??
        tickets.get(view-1).setNumOfCheckedBags(tickets.get(view-1).getNumOfCheckedBags() + 1);
        System.out.println("Success. You have been charged $30");
        case 3: manageAccount(user);
        break;
        default: break;
      }
      continue;
    }
  }

  /**
   * Sub-method of ManageAccount(), allows user to view hotel reservations
   * @param user Current RegisteredUser instance
   */
  public void viewReservations(RegisteredUser user) {
    while(true){
      System.out.println("----- Hotel Reservations -----");
      ArrayList<HotelReservation> reservations = user.getHotelReservations();
      for(int i = 0; i < reservations.size(); i++) {
        System.out.println(i+1 + ". " + reservations.get(i));
      }
      System.out.println("Which reservation would you like to view? (Enter 0 to return to menu):");
      int view = scanner.nextInt();
      if(view == 0) {
        manageAccount(user);
      }
      else {
        reservations.get(view-1).toString();
      }
      System.out.println("1. Cancel reservation and request refund\n2. Return to menu:\n" +
      "What would you like to do?:");
      int select = scanner.nextInt();
      switch(select) {
        case 1: reservations.remove(view-1);
        System.out.println("Your reservation has been cancelled. A refund will be issued to your account.");
        manageAccount(user);
        break;
        case 2: manageAccount(user);
        break;
        default: break;
      }
      continue;
    }
  }
  
  /**
   * Sub-method of ManageAccount(), allows user to change certain preferences
   * @param user Current RegisteredUser instance
   */
  public void viewPreferences(RegisteredUser user) {
      System.out.println("----- Preferences -----\n"+
      "1. Edit medical condition\n2. Change preferred airport\n3. Add blacklisted airport \n4. Return to my account\n\n"+
      "What would you like to do?");
      int select = scanner.nextInt();
      scanner.nextLine();
      switch(select) {
        case 1: System.out.println("Do you have a disability or other medical condition which you would like airlines and hotels to accomodate? (y/n):");
        String medical = scanner.nextLine();
        switch(medical) {
          case "y": user.setMedicalCondition(true);
            break;
          case "n": user.setMedicalCondition(false);
            break;
        }
        System.out.println("Medical condition updated.");
        break;
        case 2: System.out.println("Please set your preferred airport (Use three-letter code, ex. LAX):");
          String preferredAirport = scanner.nextLine();
          user.setPreferredAirport(preferredAirport);
          System.out.println("Preferred airport updated.");
        break;
        case 3: System.out.println("Please add a blacklisted airport (Use three-letter code, ex. LAX):");
          String blacklistedAirport = scanner.nextLine();
          user.addBlackListedAirport(blacklistedAirport);
          System.out.println("Blacklisted airports updated.");
        break;
        case 4: manageAccount(user);
        break;
        default: break;
      }
  }

  /**
   * 
   * @param user
   */
  public void viewLinkedPeople(RegisteredUser user) {
    System.out.println("----- Linked People Options -----\n"+
    "1. View linked people\n2. Add people\n3. Return to my account\n\n"+
    "What would you like to do?");
    int select = scanner.nextInt();
    scanner.nextLine();
    switch(select) {
      case 1: System.out.println("----- Linked People -----\n");
        for(int i = 0; i < user.getFriends().size(); i++) {
          System.out.println((i+1) + ". " + user.getFriends().get(i));
        }
        break;
      case 2: String firstName;
      String lastName;
      String email;
      int age;
      String address;
      String gender;
      boolean medicalCondition = false;
      // NAME + AGE
      System.out.println("----- Enter the Following Information -----\n\n" +
      "----- Friend's Name -----\n"+
      "First name: ");
      firstName = scanner.nextLine();
      System.out.println("Last name: ");
      lastName = scanner.nextLine();
      System.out.println("Age: ");
      age = scanner.nextInt();
      scanner.nextLine();
      // GENDER
      System.out.println("----- Friend's Gender -----\n"+
      "1. Male\n"+
      "2. Female\n"+
      "3. Unspecified\n"+
      "4. Undisclosed\n\n"+
      "Select your gender: ");
      int genderSelect = scanner.nextInt();
      switch(genderSelect) {
        case 1: gender = "Male";
        break;
        case 2: gender = "Female";
        break;
        case 3: gender = "Unspecified";
        break;
        case 4: gender = "Undisclosed";
        break;
        default: gender = "Undisclosed";
        break;
      }
      // ADDRESS
      System.out.println("----- Friend's Address -----");
      System.out.println("Country:");
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
      System.out.println("----- Friend's Email -----\n"+
      "Email: ");
      email = scanner.nextLine();
      // MEDICAL CONDITION
      System.out.println("Does this person have a medical condition? (y/n)\n");
      String medical = scanner.nextLine();
      switch(medical) {
        case "y": medicalCondition = true;
        case "n": medicalCondition = false;
      }
      // Create new friend, and add to user's friend list
      Friend friend = new Friend(firstName, lastName, age, medicalCondition, gender, email, address);
      user.addFriend(friend);
    case 3: manageAccount(user);
      break;
      }
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
 * Prompts non-registered users to create an account before booking a flight
 */
  public void searchForFlights(RegisteredUser user) {
    System.out.println("----- Enter the Following Information -----\n" +
    "----- Flight Type -----\n" +
    "1. One way\n"+
    "2. Round trip\n\n"+
    "Select your flight type: ");
    int flightType = scanner.nextInt();
    switch(flightType) {
      case 1: 
      System.out.println("----- Number of Passengers -----\nEnter number of passengers:");
      int numPassengers = scanner.nextInt();

      System.out.println("----- Departing Airport -----\nWhere would you like to fly out of?");
      String departingAirport = scanner.nextLine();

      System.out.println("----- Destination Airport -----\nWhere would you like to fly to?");
      String destAirport = scanner.nextLine();

      System.out.println("----- Departing Date -----\nWhen would you like to leave? (Enter date in format of MM/DD/YYYY)");
      String departDateStr = scanner.nextLine();
      LocalDate departDate = LocalDate.parse(departDateStr, format);

      System.out.println("----- Return Date -----\nWhen would you like to return? (Enter date in format of MM/DD/YYYY)");
      String returnDateStr = scanner.nextLine();
      LocalDate returnDate = LocalDate.parse(returnDateStr, format);
  
      System.out.println("----- Searching Flights -----");
      user.getFlights(departingAirport, destAirport, departDate);
      System.out.println("----- Choose Flights -----");
  
      System.out.println("Which flight would you like to choose?: ");
      int flightChoice = scanner.nextInt();
  
      System.out.println("Which cabin would you like to fly? :");
      int cabinChoice = scanner.nextInt();

      // SECOND FLIGHT (ROUND-TRIP)
      System.out.println("Which flight would you like to choose?: ");
      int flightChoiceTwo = scanner.nextInt();
  
      System.out.println("Which cabin would you like to fly? :");
      int cabinChoiceTwo = scanner.nextInt();

      System.out.println("----- Your Trip ----- ");

      System.out.println("Thank you for using our flight search to view potential flights.\n"+
      "If you'd like to book a flight, please log in.");
      break;

      case 2:
      
      break;
    }
  }

/**
 * Allows the user to search for hotels by certain parameters
 * Prompts non-registered users to create an account before booking a hotel
 */
  public void searchForHotels(RegisteredUser user) {
    System.out.println("----- Enter the Following Information ----- ");

    System.out.println("----- Hotel City ----- ");

    System.out.println("----- Searching for Hotels in City ----- ");

    System.out.println("----- Choose Hotel ----- ");

    System.out.println("----- Hotel Options ----- ");

    System.out.println("----- Book Room ----- ");

    System.out.println("----- Choose Room Type ----- ");

    System.out.println("----- Hotel Booking ----- ");
    
  }

/* 
===================
  ADMIN FUNCTIONS
===================
*/

public void addFlight() {
  //TODO
}

public void editFlight() {
  //TODO
}

public void removeFlight() {
  //TODO
}

public void addHotel() {
  //TODO
}

public void editHotel() {
  //TODO
}

public void removeHotel() {
  //TODO
}

/* 
===================
   FILE PRINTING
===================
*/

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