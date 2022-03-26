import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * FlightSystem
 * @author Lyn Cork, Evan Scales
 */
public class FlightSystem {
  private FlightList flightList;
  private UserList userList;
  private HotelList hotelList;
  private User user;
/**
 * 
 */
  public FlightSystem() {
    
  }
/**
 * 
 * @param username
 * @param password
 * @return
 */
  public User login(String username, String password) {
    
  }
/**
 * 
 * @return
 */
  public User createAccount() {
    
  }
/**
 * 
 */
  public void viewAccount() {
    
  }
/**
 * 
 */
  public void logout() {
    
  }
/**
 * 
 */
  public void searchForFlights() {
    
  }
/**
 * 
 */
  public void searchForHotels() {
    
  }
/**
 * 
 */
  public void editPrefernces() {
    
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
