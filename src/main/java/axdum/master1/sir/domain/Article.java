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

  public Article(String name, int stars, List<Person> buyers) {
    this.name = name;
    this.stars = stars;
    this.buyers = buyers;
  }

  public Article() {
    this.buyers = new ArrayList<Person>();
  }

  public void addBuyer(Person person){
    this.buyers.add(person);
  }

  public void removeBuyer(Person person){
    this.buyers.remove(person);
  }

  public ObjectId getId() {
    return id;
  }

  public void setId(ObjectId id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getStars() {
    return stars;
  }

  public void setStars(int stars) {
    this.stars = stars;
  }

  public List<Person> getBuyers() {
    return buyers;
  }

  public void setBuyers(List<Person> buyers) {
    this.buyers = buyers;
  }
}
