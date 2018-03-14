package axdum.master1.sir.domain;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;

import java.util.ArrayList;
import java.util.List;

@Entity("persons")
public class Person {
  @Id
  private ObjectId id;
  private String name;
  @Reference
  private List<Address> addresses;

  /**
   * Create a person.
   *
   * @param name      the name
   * @param addresses adresses
   */
  public Person(String name, List<Address> addresses) {
    this.name = name;
    this.addresses = addresses;
  }

  /**
   * Create a person without parameters.
   */
  public Person() {
    this.addresses = new ArrayList<Address>();
  }

  /**
   * Add an address.
   *
   * @param address the address
   */
  public void addAddress(Address address) {
    this.addresses.add(address);
  }

  /**
   * Remove an asdress.
   *
   * @param address the address
   */
  public void removeAddress(Address address) {
    this.addresses.remove(address);
  }

  /**
   * Get the Id.
   *
   * @return the Id
   */
  public ObjectId getId() {
    return id;
  }

  /***
   * Set the Id.
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
   * Get addresses
   *
   * @return addresses
   */
  public List<Address> getAddresses() {
    return addresses;
  }

  /**
   * Set addreses.
   *
   * @param addresses addresses
   */
  public void setAddresses(List<Address> addresses) {
    this.addresses = addresses;
  }
}
