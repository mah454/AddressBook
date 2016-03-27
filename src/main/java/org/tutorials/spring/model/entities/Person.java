package org.tutorials.spring.model.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * Created by mahsom on 3/23/16.
 */
@Entity
public class Person extends Contact {

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    private Address address;

    @ManyToOne
    @JsonManagedReference
    private Person manager;

    @ManyToOne
    @JsonManagedReference
    private Company employer;

    public Person() {
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

    public Person getManager() {
        return manager;
    }

    public void setManager(Person manager) {
        this.manager = manager;
    }

    public Company getEmployer() {
        return employer;
    }

    public void setEmployer(Company employer) {
        this.employer = employer;
    }
}
