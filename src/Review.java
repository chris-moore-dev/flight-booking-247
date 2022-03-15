/**
 * Review
 * @author Lyn Cork
 */
public class Review {

  public int rating = 10;
  public String comment = "Review text";
  public UserAccount user;
  private UUID id = randomUUID();

/**
 * Review
 * @param rating
 * @param comment
 * @param user
 * @param id
 */
  public Review(int rating, String comment, RegisteredUser user, UUID id) {
    
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
 */
  public void setRating(int rating) {
    this.rating = rating;
  }
/**
 * 
 */
  public void setComment(string comment) {
    this.comment = comment;
  }
/**
 * 
 */
  public void setUser(UserAccount user) {
    this.user = user;
  }
/**
 * 
 */
  public void setId(UUID id) {
    this.id = id;
  }
}
