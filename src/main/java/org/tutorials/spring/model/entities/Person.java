package org.tutorials.spring.model.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 * Created by mahsom on 3/23/16.
 */
@Entity
public class Person extends Contact {

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    public Person() {
    }

    @Override
    public String getUrl() {
        return "person.do?id=" + getId();
    }

    public Person(String name, Address address) {
        super(name);
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
