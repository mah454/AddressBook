package org.tutorials.spring.model.entities;

import javax.persistence.*;

/**
 * Created by mahsom on 3/21/16.
 */
@Entity
public class Contact {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="contact_seq")
    @SequenceGenerator(name = "contact_seq" , sequenceName = "contact_seq")
    private long id;
    @Column
    private String name;
    @OneToOne (cascade = CascadeType.ALL)
    private Address address;

    public Contact() {
    }

    public Contact(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
