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
public class Person {
    @Id
    private ObjectId id = new ObjectId();
    private String name;

    private List<Address> listAddress = new ArrayList<Address>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addAddress(Address address) {
        listAddress.add(address);
    }

}
