/**
 * Review
 * @author Lyn Cork
 */
import java.util.*;
public class Review {
  private int rating;
  private String comment;
  private String user;
  private UUID id;

/**
 * Review constructor with id
 * @param rating
 * @param comment
 * @param user
 * @param id
 */
  Review(int rating, String comment, String user, UUID id) {
    setRating(rating);
    setComment(comment);
    setUser(user);
    setId(id);
  }

  /**
   * Review constructor without id
   * @param rating
   * @param comment
   * @param user
   */
  Review(int rating, String comment, String user) {
    setRating(rating);
    setComment(comment);
    setUser(user);
    setId(null);
  }
  // Member functions
  public String toString() {
    String ret;
    ret = "\nUser: " + user + " "  +
          "\nRating: " + rating + "\n" + comment;
    return ret;
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
  public String getUser() {
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
  public void setUser(String user) {
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
