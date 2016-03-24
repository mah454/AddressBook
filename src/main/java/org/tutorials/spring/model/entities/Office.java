package org.tutorials.spring.model.entities;

import javax.persistence.*;

/**
 * Created by mahsom on 3/23/16.
 */
@Entity
public class Office {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "office_seq")
    @SequenceGenerator(name = "office_seq",sequenceName = "office_seq")
    private long id;

    @Column
    private String name;

    @OneToOne
    private Address address;

    public Office() {
    }

    public Office(Address address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
