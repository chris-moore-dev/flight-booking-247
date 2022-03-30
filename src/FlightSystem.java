import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * FlightSystem
 * This class contains the bulk of the functionality for the program's
 * user interface. Essentially, every way the user can interact
 * with the program is filtered through here to allow input and output.
 * @author Chris Moore, Lyn Cork, Evan Scales
 */
public class FlightSystem {
  private Scanner scanner = new Scanner(System.in);
  private UserList userList;
  private HotelList hotelList;
  private FlightList flightList;
  private DateTimeFormatter format = DateTimeFormatter.ofPattern("MM/dd/yyyy");
  private User freeUser;
  private RegisteredUser registeredUser;

  /**
   * Get the free user
   * @return The free user
   */
  public User getFreeUser() {
    return freeUser;
  }

  /**
   * Get the registered user
   * @return The registered user
   */
  public RegisteredUser getRegisteredUser() {
    return registeredUser;
  }

  /**
   * Set the free user
   * @param user The user
   */
  public void setFreeUser(User user) {
    this.freeUser = user;
  }

  /**
   * Set the registered user
   * @param user The registered user
   */
  public void setRegisteredUser(RegisteredUser user) {
    this.registeredUser = user;
  }
  
/**
 * Default constructor for FlightSystem
 */
  public FlightSystem() {
    userList = UserList.getInstance();
    hotelList = HotelList.getInstance();
    flightList = FlightList.getInstance();
    freeUser = new User();
    registeredUser = null;
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
    System.out.print("\n----- Log In -----\n"+
    "Enter email: ");
    String email = scanner.nextLine();
    System.out.print("Enter password: ");
    String password = scanner.nextLine();

    // String sDate = "04/01/2022";
    // LocalDate date = LocalDate.parse(sDate, format);
    // String departingAirport = "CAE";
    // String destAirport = "SEA";
    // String takeOffTime = "6:00 AM";
    // String landingTime = "11:09 PM";
    // String totalFlightTime = "20h 9m";
    // boolean layover = true;
    // String company = "American Airlines";
    // HashMap<String, Integer> pricing = new HashMap<>();
    // pricing.put("First", 1298);
    // pricing.put("Main Cabin", 612);
    // pricing.put("Economy", 550);
    // String departingGate = "17";
    // String destGate = "420";
    // Map<String, Seating> seats = new HashMap<>();

    // ArrayList<Flight> flights = flightList.getFlights();

    // ArrayList<Flight> addThis = new ArrayList<>();
    // addThis.add(flights.get(4));
    // addThis.add(flights.get(6));

    // Flight toAdd = new Flight(date, departingAirport, destAirport, takeOffTime, landingTime, totalFlightTime, layover, addThis, 1, 0.8, company);


    // // Flight toAdd = new Flight(date, departingAirport, destAirport, takeOffTime,
    // // landingTime, totalFlightTime, layover, company, pricing, seats, departingGate, destGate);
    // flights.add(toAdd);

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
    System.out.print("----- Enter the Following Information -----\n\n" +
    "----- Your Name -----\n"+
    "First name: ");
    firstName = scanner.nextLine();
    System.out.print("Last name: ");
    lastName = scanner.nextLine();
    System.out.print("Age: ");
    String sAge = scanner.nextLine();
    age = Integer.parseInt(sAge);


    // GENDER
    System.out.print("\n----- Your Gender -----\n"+
    "1. Male\n"+
    "2. Female\n"+
    "3. Unspecified\n"+
    "4. Undisclosed\n\n"+
    "Select your gender: ");
    int genderSelect = scanner.nextInt();
    scanner.nextLine();


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
    System.out.println("\n----- Your Address -----");
    System.out.print("Country: ");
    String country = scanner.nextLine();
    System.out.print("Street: ");
    String street = scanner.nextLine();
    System.out.print("City: ");
    String city = scanner.nextLine();
    System.out.print("State: ");
    String state = scanner.nextLine();
    System.out.print("Postal Code: ");
    String postal = scanner.nextLine();
    address = street + ", " + city + ", " + state + ", " + country + ", " + postal;
    // EMAIL
    System.out.print("\n----- Your Email -----\n"+
    "Email: ");
    email = scanner.nextLine();
    // PASSWORD
    System.out.println("\n----- Create Your Password -----");
    boolean noMatch = true;
    while(noMatch) {
      String password1 = "default";
      String password2 = "default";
      System.out.print("Password: ");
      password1 = scanner.nextLine();
      System.out.print("Confirm Password: ");
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
    ArrayList<RegisteredUser> users = userList.getUsers();
    users.add(saveThis);
    System.out.println("Account succesfully created. You can now log in.\n");
  }



/**
 * Allows the user to view and edit
 * several aspects of their account, including
 * tickets, reservations, preferences, and friends.
 */
  public void manageAccount() {
      String isFF = "not ";
      if(registeredUser.getFrequentFlyer()) {
        isFF = "";
      }
      System.out.println("----- My Account -----");
      System.out.println("You are " + isFF + "a frequent flyer.\n\n" +
      "1. View Plane Tickets\n2. View Hotel Reservations\n3. View Preferences\n" +
      "4. View Linked People Options\n5. Return to Menu\n\n" +"What would you like to do?: ");
      int mainSelect = scanner.nextInt();
      scanner.nextLine();
      switch(mainSelect) {
        case 1: viewTickets(registeredUser);
          break;
        case 2: viewReservations(registeredUser);
          break;
        case 3: viewPreferences(registeredUser);
          break;
        case 4: viewLinkedPeople(registeredUser);
          break;
        case 5: break;
        default: System.out.println("Invalid input, please try again!");
          break;
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
      if(tickets.size() == 0) {
        System.out.println("You don't have any tickets yet. You can book some through 'Search Flights' in the main menu.\n");
        break;
      }
      else {
        for(int i = 0; i < tickets.size(); i++) {
          System.out.println(i+1 + ". " + tickets.get(i));
        }
        System.out.println("Which ticket would you like to view? (Enter 0 to return to menu):");
        int view = scanner.nextInt();
      scanner.nextLine();
        if(view == 0) {
          manageAccount();
        }
        else {
          tickets.get(view-1).toString();
        }
        System.out.println("1. Cancel ticket and request refund\n2. Add checked baggage\n" + 
        "3. Return to menu\nWhat would you like to do?:");
        int select = scanner.nextInt();
        scanner.nextLine();
        switch(select) {
          case 1: tickets.remove(view-1);
          System.out.println("Your ticket has been cancelled. A refund will be issued to your account.");
          manageAccount();
          break;
          case 2: System.out.println("----- Enter the Following Information -----\n Weight of bag (lbs):");
          double weight = scanner.nextDouble();
          // Is there anywhere to store a bags' weight??
          tickets.get(view-1).setNumOfCheckedBags(tickets.get(view-1).getNumOfCheckedBags() + 1);
          System.out.println("Success. You have been charged $30");
          case 3: manageAccount();
          break;
          default: break;
        }
        continue;
      }
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
      if(reservations.size() == 0) {
        System.out.println("You don't have any hotel reservations yet. You can book some through 'Search Hotels' in the main menu.\n");
        break;
      }
      else {
        for(int i = 0; i < reservations.size(); i++) {
          System.out.println(i+1 + ". " + reservations.get(i));
        }
        System.out.println("Which reservation would you like to view? (Enter 0 to return to menu):");
        int view = scanner.nextInt();
        if(view == 0) {
          manageAccount();
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
          manageAccount();
          break;
          case 2: manageAccount();
          break;
          default: break;
        }
        continue;
      }
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
        case 4: manageAccount();
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
    case 3: manageAccount();
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
   * Prints a basic iteray to the screen
   * @param flight The flight about to be booked
   * @param price The price of the flight
   * @param cabin The cabin the suer chose
   */
  private void printTrip(Flight flight, int price, String cabin) {
    String stops = "";
    if (!(flight.getIsLayover())) {
      stops = "Nonstop";
    } else {
      int size = flight.getFlights().size();
      if (size == 1)
        stops += "1 Stop";
      else
        stops += size + " Stops";
    }
    System.out.println(flight.getDepartingAirport() + "     ->     " + flight.getDestAirport());
    System.out.println(flight.getTakeOffTime() + "     " + flight.getLandingTime() + "\t" +
    flight.getTotalFlightTime() + "     " + stops + "     Cabin: " + cabin +
    "     Price: $" + price + "\n");
  }

  /**
   * Here is where the user will be displayed the avaialbe flights.
   * They will then choose one of the flights
   * @param departingAirport The departing airport
   * @param destAirport The dest airport
   * @param departDate The depart Date
   * @param user User to call methods
   * @return The flight the user chose
   */
  private Flight flightSearchHelper(String departingAirport, String destAirport, LocalDate departDate, User user) {
    Flight ret;
    System.out.println("\n----- Searching Flights -----\n\n----- Choose Flights -----\n");
    ArrayList<Flight> chooseFrom = user.getFlights(departingAirport, destAirport, departDate);
    System.out.println(departingAirport + " -> " + destAirport);
    System.out.println(departDate);
    for (int i = 0; i < chooseFrom.size(); i++) {
      Flight flight = chooseFrom.get(i);
      System.out.println("\n" + (i+1) + ".");
      System.out.println(flight);
    }
    System.out.print("Which flight would you like to choose?: ");
    int chooseFlight = scanner.nextInt();
    scanner.nextLine();
    Flight chosenFlight = chooseFrom.get(chooseFlight-1);
    ret = chosenFlight;
    return ret;
  }

  /**
   * The user will be displayed available hotels, and choose one.
   * @param city The city
   * @param user User to call methods
   * @return The hotel the user chose
   */
  private Hotel hotelSearchHelper(String city, User user) {
    Hotel ret;
    System.out.println("\n----- Searching Hotels in " + city + "-----\n\n----- Choose Hotel -----\n");
    ArrayList<Hotel> chooseFrom = user.getHotelsByCity(city);
    for (int i = 0; i < chooseFrom.size(); i++) {
      Hotel hotel = chooseFrom.get(i);
      System.out.println("\n" + (i+1) + ".");
      System.out.println(hotel);
    }
    System.out.print("Which hotel would you like to choose?: ");
    int chooseHotel = scanner.nextInt();
    scanner.nextLine();
    Hotel chosenHotel = chooseFrom.get(chooseHotel-1);
    ret = chosenHotel;
    return ret;
  }


  /**
   * Search for flights
   */
  public void searchForFlights() {
    ArrayList<Seating> seatsToBook = new ArrayList<>();
    ArrayList<Flight> flightsToBook = new ArrayList<>();
    ArrayList<Friend> ticketHolders = new ArrayList<>();
    User user = new User();
    String departingAirport;
    String destAirport;
    LocalDate departDate;
    LocalDate returnDate;
    int numPassengers;
    ArrayList<Boolean> shouldDiscount = new ArrayList<>();

    System.out.print("\n----- Enter the Following Information -----\n" +
    "\n----- Flight Type -----\n" +
    "1. One way\n"+
    "2. Round trip\n\n"+
    "Select your flight type: ");

    int flightType = scanner.nextInt();
    scanner.nextLine();

    System.out.print("\n----- Number of Passengers -----\n\nEnter number of passengers: ");
    numPassengers = scanner.nextInt();
    scanner.nextLine();

    System.out.println("\n----- Departing Airport -----");
    if (registeredUser != null && !(registeredUser.getPreferredAirport().equals(""))) {
      System.out.println("Would you like to fly out of " + registeredUser.getPreferredAirport()
      + " (saved preference)?\n");
      System.out.println("1. Yes");
      System.out.println("2. No\n");
      System.out.print("Select Option: ");
      int choice = scanner.nextInt();
      scanner.nextLine();

      switch (choice) {
        case 1:
          departingAirport = registeredUser.getPreferredAirport();
          break;
        case 2:
          departingAirport = getDepartingAirport();
          break;
        default:
          departingAirport = getDepartingAirport();
          break;
      }
    } else {
      departingAirport = getDepartingAirport();
    }

    System.out.print("\n----- Destination Airport -----\n\nWhere would you like to fly to? (Enter 3 letter airport code): ");
    destAirport = scanner.nextLine();

    System.out.print("\n----- Departing Date -----\n\nWhen would you like to leave? (Enter date in format of MM/DD/YYYY): ");
    String departDateStr = scanner.nextLine();
    departDate = LocalDate.parse(departDateStr, format);

    switch (flightType) {
      case 1:
        Flight chosenFlight = flightSearchHelper(departingAirport, destAirport, departDate, user);
        
        System.out.print("\nWhich cabin would you like to fly?: ");
        String cabin = scanner.nextLine();
        int price = chosenFlight.getPrice(cabin) * numPassengers;

        System.out.println("\n----- Your Trip -----\n");
        printTrip(chosenFlight, price, cabin);
        System.out.println("Total Estimated Price: $" + price + "\n");

        for (int i = 0; i < numPassengers; i++) {
          if (!(chosenFlight.getIsLayover())) {
            shouldDiscount.add(false);
            flightsToBook.add(chosenFlight);
          } else {
            for (Flight flight : chosenFlight.getFlights()) {
              shouldDiscount.add(true);
              flightsToBook.add(flight);
            }
          }
        }

        break;
      case 2:
        System.out.print("\n----- Return Date -----\n\nWhen would you like to return? (Enter date in format of MM/DD/YYYY): ");
        String returnDateStr = scanner.nextLine();
        returnDate = LocalDate.parse(returnDateStr, format);

        Flight flightThere = flightSearchHelper(departingAirport, destAirport, departDate, user);
        System.out.print("\nWhich cabin would you like to fly?: ");
        String cabin1 = scanner.nextLine();
        int price1 = flightThere.getPrice(cabin1);

        Flight flightBack = flightSearchHelper(destAirport, departingAirport, returnDate, user);
        System.out.print("\nWhich cabin would you like to fly?: ");
        String cabin2 = scanner.nextLine();
        int price2 = flightThere.getPrice(cabin2);

        for (int i = 0; i < numPassengers; i++) {
          if (!(flightThere.getIsLayover())) {
            shouldDiscount.add(false);
            flightsToBook.add(flightThere);
          } else {
            for (Flight flight : flightThere.getFlights()) {
              shouldDiscount.add(true);
              flightsToBook.add(flight);
            }
          }
        }
        
        for (int i = 0; i < numPassengers; i++) {
          if (!(flightBack.getIsLayover())) {
            shouldDiscount.add(false);
            flightsToBook.add(flightBack);
          } else {
            for (Flight flight : flightBack.getFlights()) {
              shouldDiscount.add(true);
              flightsToBook.add(flight);
            }
          }
        }

        System.out.println("\n----- Your Trip -----\n");
        printTrip(flightThere, price1, cabin1);
        printTrip(flightBack, price2, cabin2);
        int totalPrice = (price1 + price2) * numPassengers;
        System.out.println("Total Estimated Price: $" + totalPrice + "\n");
        break;
      default:
        break;
    }

    if (registeredUser == null) {
      System.out.println("Please log in to book flights\n");
      return;
    }

    System.out.println("\n-----Passenger Details-----");
    System.out.println("\nChoose one of the following people, or input custom passenger details\n");
    ticketHolders = getTicketHolders(numPassengers, flightsToBook.size());
    for (int i = 0; i < flightsToBook.size(); i++) {
      Flight flightToBook = flightsToBook.get(i);
      Friend ticketHolder = ticketHolders.get(i);
      System.out.println("----- Seat for " + ticketHolder.getFirstName() + " -----\n");
      System.out.println("Choose seat for " + flightToBook.getDepartingAirport() +
      " -> " + flightToBook.getDestAirport());
      System.out.println("X = Unavailable Seat");
      System.out.println("O = Open Seat");
      System.out.println("M = Medical Seat");
      System.out.println(flightToBook.printSeats());
      Map<String, Seating> seats = flightToBook.getSeating();

      Boolean validSeat = false;
      while(!validSeat) {
        System.out.print("Select your seat number: ");
        String seatNum = scanner.nextLine();
        Seating seat = seats.get(seatNum);
        if (seat.getBooked()) {
          System.out.println("Seat is taken, please try again!");
        } else {
          seatsToBook.add(seat);
          seat.setBooked(true);
          validSeat = true;
        }
      }

    }

    registeredUser.bookFlights(flightsToBook, seatsToBook, ticketHolders, shouldDiscount);
    System.out.println("\n---- Flight Booking -----");
    System.out.println("\nYour tickets have been added to your account");
    System.out.println("\nThank you for shopping with us!");
    System.out.println("\nWould you also like to book a hotel?\n");
    System.out.println("1. Yes");
    System.out.println("2. No");
    System.out.print("\nEnter your choice: ");
    int hotelChoice = scanner.nextInt();
    scanner.nextLine();
    if (hotelChoice == 1) {
      searchForHotels();
    } 
    System.out.println("\nReturning to main menu\n");

  }

  /**
   * Makes an array list of friends
   * Each index coresponds to the flight they will want to book in flights to book
   * @param numPassengers The number of passengers
   * @param size Size of flights to be booked. Used to determine how many flights each passenger will have
   * @return The array list holding all the ticket holders
   */
  private ArrayList<Friend> getTicketHolders(int numPassengers, int size) {
    ArrayList<Friend> ret = new ArrayList<>();
    ArrayList<Friend> preRet = new ArrayList<>();
    int flightsPerPassenger = size / numPassengers;

    ArrayList<Friend> chooseFromFriends = new ArrayList<>();

    for (Friend friend : registeredUser.getFriends()) {
      chooseFromFriends.add(friend);
    }

    for (int i = 0; i < numPassengers; i++) {
      for (int j = 0; j < chooseFromFriends.size(); j++) {
        System.out.println((j+1) + ".");
        System.out.println(chooseFromFriends.get(j));

      }

      int lastElement = chooseFromFriends.size() + 1;
      System.out.println(lastElement + ".");
      System.out.println("Input custom passenger details");

      System.out.print("\nEnter choice: ");

      int choice = scanner.nextInt();
      scanner.nextLine();

      System.out.println("\n");

      if (choice == lastElement) {
        Friend toAdd = makeFriend();
        preRet.add(toAdd);
      } else {
        preRet.add(chooseFromFriends.get(choice-1));
        chooseFromFriends.remove(choice-1);
      }
    }

    for (int i = 0; i < preRet.size(); i++) {
      for (int j = 0; j < flightsPerPassenger; j++) {
        ret.add(preRet.get(i));
      }
    }
    return ret;
  }

  /**
   * When a user enters a new passenger details make them a friend of the user
   * @return Friend a friend of the user
   */
  private Friend makeFriend() {
    String firstName;
    String lastName;
    int age;
    String gender;
    String email;
    String address;

    // NAME + AGE
    System.out.print("----- Enter the Following Information -----\n\n" +
    "----- Your Name -----\n"+
    "First name: ");
    firstName = scanner.nextLine();
    System.out.print("Last name: ");
    lastName = scanner.nextLine();
    System.out.print("Age: ");
    String sAge = scanner.nextLine();
    age = Integer.parseInt(sAge);

    // GENDER
    System.out.print("\n----- Your Gender -----\n"+
    "1. Male\n"+
    "2. Female\n"+
    "3. Unspecified\n"+
    "4. Undisclosed\n\n"+
    "Select your gender: ");
    int genderSelect = scanner.nextInt();
    scanner.nextLine();
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
    System.out.println("\n----- Your Address -----");
    System.out.print("Country: ");
    String country = scanner.nextLine();
    System.out.print("Street: ");
    String street = scanner.nextLine();
    System.out.print("City: ");
    String city = scanner.nextLine();
    System.out.print("State: ");
    String state = scanner.nextLine();
    System.out.print("Postal Code: ");
    String postal = scanner.nextLine();
    address = street + ", " + city + ", " + state + ", " + country + ", " + postal;
    // EMAIL
    System.out.print("\n----- Passenger Email -----\n"+
    "Email: ");
    email = scanner.nextLine();
    Friend ret = new Friend(firstName, lastName, age, false, gender, email, address);
    registeredUser.addFriend(ret);
    return ret;
  }

  /**
   * Helper method to get the departing airport from user
   * @return The departing airport
   */
  private String getDepartingAirport() {
    String ret = "";
    System.out.print("\nWhere yould you like to fly out of? (Enter 3 letter airport code): ");
    ret = scanner.nextLine();
    return ret;
  }

/**
 * Allows the user to search for hotels by certain parameters
 * Prompts non-registered users to create an account before booking a hotel
 */
  public void searchForHotels() {
    User user = new User();
    String city;
    LocalDate checkInDate;
    LocalDate checkOutDate;
    // numGuests doesn't seem to be called
    int numGuests = 1;

    System.out.println("----- Enter the Following Information ----- ");
      System.out.println("\n----- Hotel City ----- ");
      city = scanner.nextLine();

    System.out.println("----- Searching for Hotels in " + city + " ----- ");
      Hotel chosenHotel = hotelSearchHelper(city, user);

    System.out.println("----- Hotel Options ----- ");
      System.out.println("1. Read Reviews\n2. Book Room\nWhat would you like to do?:");
      int select = scanner.nextInt();
      scanner.nextLine();
      switch(select){
        case 1: 
          System.out.println("Ratings of selected hotel:");
          for(int i = 0; i < chosenHotel.getReviews().size(); i++){
            if(i >= 1) {
              System.out.println(", ");
            }
            System.out.println(chosenHotel.getReviews().get(i).toString());
          }
          break;
        case 2:
          System.out.println("----- Book Room ----- ");
          System.out.println("When would you like to check in?");
          String checkInDateStr = scanner.nextLine();
          checkInDate = LocalDate.parse(checkInDateStr, format);
          System.out.println("When would you like to check out?");
          String checkOutDateStr = scanner.nextLine();
          checkOutDate = LocalDate.parse(checkOutDateStr, format);
    
        System.out.println("----- Choose Room Type ----- ");
    
          String chosenRoom = scanner.nextLine();
          Room room = chosenHotel.getRooms().get(chosenRoom);
          int price = chosenHotel.getPrice(chosenRoom);
        
          registeredUser.bookHotel(chosenHotel, room, numGuests, checkInDate, checkOutDate);
    
        System.out.println("----- Hotel Booking ----- ");
          System.out.println("Total Price:" + price);
          System.out.println("\nYour reservation has been added to your account\n\n");
          System.out.println("\nThank you for shopping with us!\n");
          break;
      }
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