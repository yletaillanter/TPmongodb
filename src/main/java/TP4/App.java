package TP4;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.mongodb.Mongo;
import java.net.UnknownHostException;

/**
 * Baptiste Quéré
 * Yoann Le Taillanter 
 * TP SIR
 * M1 MIAGE
 */
public class App {

    public static void main( String[] args ) throws UnknownHostException {

        Morphia morphia = new Morphia();

        Mongo mongo = new Mongo();

        morphia.map(Person.class).map(Address.class);

        Datastore ds = morphia.createDatastore(mongo, "maPremiereBaseMango");

        Person p = new Person();
        Person p1 = new Person();
        Person p2 = new Person();

        p.setName("Tintin");
        p1.setName("Batriste");
        p2.setName("YOYOYOLO");

        Address address = new Address();
        Address address1 = new Address();
        Address address2 = new Address();

        address.setStreet("123 Some street");
        address.setCity("Some city");
        address.setPostCode("123 456");
        address.setCountry("Some country");

        address1.setStreet("54 Avenue Jean Vivi");
        address1.setCity("Rennes");
        address1.setPostCode("35000");
        address1.setCountry("France");

        address2.setStreet("24 boulevard jan");
        address2.setCity("Lorient");
        address2.setPostCode("56100");
        address2.setCountry("France");

        p.addAddress(address);
        p1.addAddress(address1);
        p2.addAddress(address2);

        ds.save(address);
        ds.save(address1);
        ds.save(address2);

        Article article = new Article();
        Article article1 = new Article();
        Article article2 = new Article();

        article.setName("Joujou");
        article1.setName("Couteau");
        article2.setName("Gros Gun");

        ds.save(article);
        ds.save(article1);
        ds.save(article2);


        article.addPerson(p);
        article.addPerson(p1);
        article1.addPerson(p2);
        article2.addPerson(p2);

        ds.save(p);
        ds.save(p1);
        ds.save(p2);

        for (Person e : ds.find(Person.class))
            System.err.println(e.getName());

    }
}
