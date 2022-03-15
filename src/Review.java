/**
 * Review
 * @author Lyn Cork
 */
import java.util.*;
public class Review {
  private int rating;
  private String comment;
  private RegisteredUser user;
  private UUID id;

/**
 * Review
 * @param rating
 * @param comment
 * @param user
 * @param id
 */
  Review(int rating, String comment, RegisteredUser user, UUID id) {
    
  }

  /**
   * 
   * @param rating
   * @param comment
   * @param user
   */
  Review(int rating, String comment, RegisteredUser user) {

  }

  // Getters

  /**
   * 
   * @return
   */
  public int getRating() {
    return this.rating;
  }

  /**
   * 
   * @return
   */
  public String getComment() {
    return this.comment;
  }

  /**
   * 
   * @return
   */
  public UserAccount getUser() {
    return this.user;
  }

  /**
   * 
   * @return
   */
  public UUID getId() {
    return this.id;
  }

  // Setters

  /**
   * 
   * @param rating
   */
  public void setRating(int rating) {
    this.rating = rating;
  }

  /**
   * 
   * @param comment
   */
  public void setComment(String comment) {
    this.comment = comment;
  }

  /**
   * 
   * @param user
   */
  public void setUser(RegisteredUser user) {
    this.user = user;
  }

  /**
   * 
   * @param id
   */
  public void setId(UUID id) {
    if (id != null)
      this.id = id;
    else
      this.id = UUID.randomUUID();
  }
}
