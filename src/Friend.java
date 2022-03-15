/**
 * Friend
 * @author Lyn Cork
 */
public class Friend {
  private String firstName = "John";
  private String lastName = "Smith";
  private int age = 25;
  private boolean medicalCondition = false;
  private String gender = "male";
  private String email = "email@email.com";
  private String address = "123 Street St";
  private UUID id = randomUUID();

/**
 * 
 * @param firstName
 * @param lastName
 * @param age
 * @param medicalCondition
 * @param gender
 * @param email
 * @param address
 * @param id
 */
  public Friend(String firstName, String lastName, int age, boolean medicalCondition, String gender, String email, String address, UUID id) {
  
  }

  // Getters
/**
 * 
 * @return
 */
  public String getFirstName() {
    return this.firstName;
  }
/**
 * 
 * @return
 */
  public String getLastName() {
    return this.lastName;
  }
/**
 * 
 * @return
 */
  public int getAge() {
    return this.age; 
  }
/**
 * 
 * @return
 */
  public boolean getMedicalCondition() {
    return this.medicalCondition;
  }
/**
 * 
 * @return
 */
  public String getGender() {
    return this.gender;
  }
/**
 * 
 * @return
 */
  public String getEmail() {
    return this.email;
  }
/**
 * 
 * @return
 */
  public String getAddress() {
    return this.address;
  }
/**
 * 
 * @return
 */
  public UUID getId() {
    return this.id;
  }
    //Setters
/**
 * 
 * @param firstName
 */
  public void setFirstName(string firstName) {
    this.firstName = firstName;
  }
/**
 * 
 * @param lastName
 */
  public void setLastName(string lastName) {
    this.lastName = lastName;
  }
/**
 * 
 * @param age
 */
  public void setAge(int age) {
    this.age = age;
  }
/**
 * 
 * @param medicalCondition
 */
  public void setMedicalCondition(boolean medicalCondition) {
    this.medicalCondition = medicalCondition;
  }
/**
 * 
 * @param gender
 */
  public void setGender(String gender) {
    this.gender = gender;
  }
/**
 * 
 * @param email
 */
  public void setEmail(String email) {
    this.email = email;
  }
/**
 * 
 * @param address
 */
  public void setAddress(String address) {
    this.address = address;
  }
/**
 * 
 * @param id
 */
  public void setId(UUID id) {
    this.id = id;
  }
}
