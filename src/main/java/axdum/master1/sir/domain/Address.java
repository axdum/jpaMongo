package axdum.master1.sir.domain;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity("addresses")
public class Address {
  @Id
  ObjectId id;
  private String street;
  private String city;
  private String postCode;
  private String country;

  /**
   * Create a new adress.
   *
   * @param street   the street
   * @param city     the city
   * @param postCode the post code
   * @param country  the contry
   */
  public Address(String street, String city, String postCode, String country) {
    this.street = street;
    this.city = city;
    this.postCode = postCode;
    this.country = country;
  }

  /**
   * Create a new adress without parameters.
   */
  public Address() {
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
   * @param id
   */
  public void setId(ObjectId id) {
    this.id = id;
  }

  /**
   * Get the street.
   *
   * @return the street
   */
  public String getStreet() {
    return street;
  }

  /**
   * Set the street.
   *
   * @param street the street
   */
  public void setStreet(String street) {
    this.street = street;
  }

  /**
   * Get the city.
   *
   * @return the city
   */
  public String getCity() {
    return city;
  }

  /**
   * Set the city.
   *
   * @param city the city
   */
  public void setCity(String city) {
    this.city = city;
  }

  /**
   * Get the post code.
   *
   * @return the post code
   */
  public String getPostCode() {
    return postCode;
  }

  /**
   * Set the post code.
   *
   * @param postCode the post code
   */
  public void setPostCode(String postCode) {
    this.postCode = postCode;
  }

  /**
   * Get the country.
   *
   * @return the country
   */
  public String getCountry() {
    return country;
  }

  /**
   * Set the country.
   *
   * @param country the country
   */
  public void setCountry(String country) {
    this.country = country;
  }
}
