package org.tutorials.spring.model.entities;

import javax.persistence.*;

/**
 * Created by mahsom on 3/23/16.
 */
@Entity
@SequenceGenerator(name = "default_seq", sequenceName = "office_seq")
public class Office extends BaseEntity {

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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
