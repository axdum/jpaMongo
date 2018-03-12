package axdum.master1.sir;

import axdum.master1.sir.domain.Address;
import axdum.master1.sir.domain.Article;
import axdum.master1.sir.domain.Person;
import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import redis.clients.jedis.Jedis;

/**
 * Hello world!
 */
public class App {
  public void main(String[] args) {
    // Exemple 1
    //this.populateMongo();
    /*Jedis jedis = new Jedis("localhost");
    jedis.set("foo", "bar");
    String value = jedis.get("foo");
    System.err.println(value);*/

    // Exemple 2
    /*Jedis jedis = new Jedis( "localhost" );
    System. out .println(jedis.get( "counter" ));
    jedis.incr( "counter" );
    System. out .println(jedis.get( "counter" ));*/

    // Exemple 3
    /*String cacheKey = "cachekey";
    Jedis jedis = new Jedis("localhost");
    // adding a new key
    jedis.set(cacheKey, "cached value");
    // setting the TTL in seconds
    jedis.expire(cacheKey, 15);
    // Getting the remaining ttl
    System.out.println("TTL:" + jedis.ttl(cacheKey));
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("TTL:" + jedis.ttl(cacheKey));
    // Getting the cache value
    System.out.println("Cached Value:" + jedis.get(cacheKey));
    // Wait for the TTL finishs
    try {
      Thread.sleep(15000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    // trying to get the expired key
    System.out.println("Expired Key:" + jedis.get(cacheKey));*/

    // Exemple 4
    String cacheKey = "languages" ;
    Jedis jedis = new Jedis( "localhost" );
    // Adding a set as value
    jedis.sadd(cacheKey, "Java" );
    jedis.sadd(cacheKey, "C#" );
    jedis.sadd(cacheKey, "Python" ); // SADD
    // Getting all values in the set: SMEMBERS
    System. out .println( "Languages: " + jedis.smembers(cacheKey));
    // Adding new values
    jedis.sadd(cacheKey, "Java" );
    jedis.sadd(cacheKey, "Ruby" );
    // Getting the values... it doesn't allow duplicates
    System. out .println( "Languages: " + jedis.smembers(cacheKey));
  }

  private void populateMongo() {
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
}
