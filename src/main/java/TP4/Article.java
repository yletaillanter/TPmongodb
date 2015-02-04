package TP4;


import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

/**
 * Baptiste Quéré
 * Yoann Le Taillanter
 * TP SIR
 * M1 MIAGE
 */
@Entity
public class Article {
    @Id
    private ObjectId id = new ObjectId();
    private String name;
    private int stars;

    private List<Person> listPerson = new ArrayList<Person>();

    public List<Person> getListPerson() {
        return listPerson;
    }

    public void setListPerson(List<Person> listPerson) {
        this.listPerson = listPerson;
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

    public void addPerson(Person person) {
        listPerson.add(person);
    }


}
