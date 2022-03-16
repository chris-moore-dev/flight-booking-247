/**
 * Ticket
 * @author Lyn Cork
 */
public class Ticket extends Reservation {
  private String boardingGroup;
  private String boardingTime;
  private String gate;
  private String name;
  private int numOfCheckedBags;
/**
 * 
 * @param boardingGroup
 * @param boardingTime
 */
  public Ticket(String boardingGroup, String boardingTime) {
    
  }
/**
 * 
 */
  public void printReservations() {
    
  }
  // Getters
/**
 * 
 * @return
 */
  public String getBoardingGroup() {
    return boardingGroup;
  }
/**
 * 
 * @return
 */
  public String getBoardingTime() {
    return boardingTime;
  }
/**
 * 
 * @return
 */
  public String getGate() {
    return gate;
  }
/**
 * 
 * @return
 */
  public String getName() {
    return name;
  }
/**
 * 
 * @return
 */
  public int getNumOfCheckedBags() {
    return numOfCheckedBags;
  }
  // Setters
/**
 * 
 * @param boardingGroup
 */
  public void setBoardingGroup(String boardingGroup) {
    this.boardingGroup = boardingGroup;
  }
/**
 * 
 * @param boardingTime
 */
  public void setBoardingTime(String boardingTime) {
    this.boardingTime = boardingTime;
  }
/**
 * 
 * @param gate
 */
  public void setGate(String gate) {
    this.gate = gate;
  }
/**
 * 
 * @param name
 */
  public void setName(String name) {
    this.name = name;
  }
/**
 * 
 * @param numOfCheckedBags
 */
  public void setNumOfCheckedBags(int numOfCheckedBags) {
    this.numOfCheckedBags = numOfCheckedBags;
  }
}
