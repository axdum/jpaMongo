package axdum.master1.sir.domain;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.*;

import java.util.ArrayList;
import java.util.List;

@Entity("articles")
@Indexes(
        @Index(value = "article", fields = @Field("stars"))
)
public class Article {
  @Id
  private ObjectId id;
  private String name;
  private int stars;
  @Reference
  private List<Person> buyers;

  /**
   * Create a new Article.
   *
   * @param name
   * @param stars
   * @param buyers
   */
  public Article(String name, int stars, List<Person> buyers) {
    this.name = name;
    this.stars = stars;
    this.buyers = buyers;
  }

  /**
   * Create a new article without paramets.
   */
  public Article() {
    this.buyers = new ArrayList<Person>();
  }

  /**
   * Add a buyer.
   *
   * @param person the buyer
   */
  public void addBuyer(Person person) {
    this.buyers.add(person);
  }

  /**
   * Remove a buyer.
   *
   * @param person the buyer
   */
  public void removeBuyer(Person person) {
    this.buyers.remove(person);
  }

  /**
   * Get the Id.
   *
   * @return the Id
   */
  public ObjectId getId() {
    return id;
  }

  /**
   * Set the Id.
   *
   * @param id the Id
   */
  public void setId(ObjectId id) {
    this.id = id;
  }

  /**
   * Get the name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Set the name.
   *
   * @param name the name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Get the number of stars.
   *
   * @return the number of stars
   */
  public int getStars() {
    return stars;
  }

  /**
   * Set the number of stars.
   *
   * @param stars the number of stars
   */
  public void setStars(int stars) {
    this.stars = stars;
  }

  /**
   * Get buyers.
   *
   * @return buyers
   */
  public List<Person> getBuyers() {
    return buyers;
  }

  /**
   * Set buyers.
   *
   * @param buyers buyers
   */
  public void setBuyers(List<Person> buyers) {
    this.buyers = buyers;
  }
}
