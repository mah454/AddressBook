package org.tutorials.spring.model.entities;

import javax.persistence.*;

/**
 * Created by mahsom on 3/21/16.
 */
@Entity
public class Address {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "address_seq")
    @SequenceGenerator(name = "address_seq",sequenceName = "address_seq")
    private long id ;
    @Column
    private String street ;
    @Column
    private String city ;
    @Column
    private String state ;
    @Column
    private String zip ;

    public Address() {
    }

    public Address(String street, String city, String state, String zip) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}
