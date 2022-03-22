/**
 * Friend Class. 
 * @author Lyn Cork
 */
import java.util.*;
public class Friend {
  private String firstName;
  private String lastName;
  private int age;
  private boolean medicalCondition;
  private String gender;
  private String email;
  private String address;
  private UUID id;

  /**
   * 
   * @param firstName
   * @param lastName
   * @param age
   * @param medicalCondition
   * @param gender
   * @param email
   * @param address
   */
  Friend(String firstName, String lastName, int age,
  boolean medicalCondition, String gender, String email,
  String address) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
    this.medicalCondition = medicalCondition;
    this.gender = gender;
    this.email = email;
    this.address = address;
  }

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
  Friend(String firstName, String lastName, int age,
  boolean medicalCondition, String gender, String email,
  String address, UUID id) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
    this.medicalCondition = medicalCondition;
    this.gender = gender;
    this.email = email;
    this.address = address;
    this.id = id;
  }

  // Member functions

  // Getters

  /**
   * Get the first name
   * @return The first name
   */
  public String getFirstName() {
    return firstName;
  }

  /** 
   * Get the last name
   * @return The last name
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * Get the age
   * @return The age
   */
  public int getAge() {
    return age;
  }

  /**
   * Get the medical condition
   * @return The medical condition
   */
  public boolean getMedicalCondition() {
    return medicalCondition;
  }

  /**
   * Get the gender
   * @return The gender
   */
  public String getGender() {
    return gender;
  }

  /**
   * Get the email
   * @return The email
   */
  public String getEmail() {
    return email;
  }

  /**
   * Get the address
   * @return The address
   */
  public String getAddress() {
    return address;
  }

  /**
   * Get the id
   * @return The id
   */
  public UUID getID() {
    return id;
  }

  // Setters

  /**
   * Set the first name
   * @param firstName The first name
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * Set the last name
   * @param lastName The last name
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  /**
   * Set the age
   * @param age
   */
  public void setAge(int age) {
    this.age = age;
  }
    
  /**
   * Set the medical condition to true or false
   * @param medicalCondition
   */
  public void setMedicalCondition(boolean medicalCondition) {
    this.medicalCondition = medicalCondition;
  }

  /**
   * Set the gender
   * @param gender
   */
  public void setGender(String gender) {
    this.gender = gender;
  }

  /**
   * Set the email
   * @param email
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * Set the address
   * @param address
   */
  public void setAddress(String address) {
    this.address = address;
  }

  /**
   * Set the UUID
   * @param id
   */
  public void setId(UUID id) {
    this.id = id;
  }

}
