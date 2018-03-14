package axdum.master1.sir;

import axdum.master1.sir.domain.Address;
import axdum.master1.sir.domain.Article;
import axdum.master1.sir.domain.Person;
import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import redis.clients.jedis.Jedis;

public class App {
  public static void main(String[] args) {
    populateMongo();
    //populateRedis();
  }

  /**
   * Use MongoDB
   */
  private static void populateMongo() {
    Morphia morphia = new Morphia();
    MongoClient mongo = new MongoClient();
    morphia.map(Person.class).map(Address.class);
    Datastore ds = morphia.createDatastore(mongo, "jpamongo");

    Address a1 = new Address("99 rue Herge", "Moulinsart", "1000", "Belgium");
    ds.save(a1);

    Address a2 = new Address("24 Rue du Commandant Guilbaud", "Paris", "75016 ", "France");
    ds.save(a2);

    Address a3 = new Address("15 rue jeanne d'arc", "Rouen", "76000", "France");
    ds.save(a3);

    Address a4 = new Address("111 Rue de Lorient", "Rennes", "35000", "France");
    ds.save(a4);

    Person p1 = new Person();
    p1.setName("Tintin");
    p1.addAddress(a1);
    p1.addAddress(a3);
    ds.save(p1);

    Person p2 = new Person();
    p2.setName("Neymar Jr");
    p2.addAddress(a2);
    ds.save(p2);

    Person p3 = new Person();
    p3.setName("Jeanne d'Arc");
    p3.addAddress(a3);
    ds.save(p3);

    Person p4 = new Person();
    p4.setName("Romain Danze");
    p4.addAddress(a3);
    ds.save(p4);

    Article art1 = new Article();
    art1.setName("Tintin et le temple du soleil");
    art1.addBuyer(p1);
    art1.addBuyer(p2);
    art1.addBuyer(p3);
    ds.save(art1);

    Article art2 = new Article();
    art2.setName("Tintin et les picaros");
    art2.addBuyer(p1);
    art2.addBuyer(p2);
    ds.save(art2);

    Article art3 = new Article();
    art3.setName("Tintin et le lotus bleu");
    art3.addBuyer(p2);
    art3.addBuyer(p3);
    ds.save(art3);

    for (Person e : ds.find(Person.class))
      System.err.println(e);
  }

  /**
   * Use Redis
   */
  private static void populateRedis() {
    String cacheKey = "languages";
    Jedis jedis = new Jedis("localhost");
    // Adding a set as value
    jedis.sadd(cacheKey, "Java");
    jedis.sadd(cacheKey, "C#");
    jedis.sadd(cacheKey, "Python"); // SADD
    // Getting all values in the set: SMEMBERS
    System.out.println("Languages: " + jedis.smembers(cacheKey));
    // Adding new values
    jedis.sadd(cacheKey, "Java");
    jedis.sadd(cacheKey, "Ruby");
    // Getting the values... it doesn't allow duplicates
    System.out.println("Languages: " + jedis.smembers(cacheKey));
  }
}
