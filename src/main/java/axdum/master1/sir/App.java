package axdum.master1.sir;

import axdum.master1.sir.domain.Address;
import axdum.master1.sir.domain.Person;
import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

/**
 * Hello world!
 */
public class App {
  public static void main(String[] args) {
    Morphia morphia = new Morphia();
    MongoClient mongo = new MongoClient();
    morphia.map(Person.class).map(Address.class);
    Datastore ds = morphia.createDatastore(mongo, "jpamongo");

    Address address = new Address("123 Some street", "Moulinsart", "1000", "Belgium");
    Person p = new Person();
    p.setName("Tintin");
    p.addAddress(address);

    // Save the POJO
    ds.save(p);
    for (Person e : ds.find(Person.class))
      System.err.println(e);
  }
}
