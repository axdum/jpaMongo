package axdum.master1.sir;

import axdum.master1.sir.domain.Address;
import axdum.master1.sir.domain.Article;
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

    Address a1 = new Address("99 rue Herge", "Moulinsart", "1000", "Belgium");
    ds.save(a1);
    Person p1 = new Person();
    p1.setName("Tintin");
    p1.addAddress(a1);
    ds.save(p1);

    Article art1 = new Article();
    art1.setName("Tintin et le temple du soleil");
    art1.addBuyer(p1);

    for (Person e : ds.find(Person.class))
      System.err.println(e);
  }
}
