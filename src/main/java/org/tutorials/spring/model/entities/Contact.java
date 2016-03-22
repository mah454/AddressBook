package org.tutorials.spring.model.entities;

import javax.persistence.*;

/**
 * Created by mahsom on 3/21/16.
 */
@Entity
public class Contact {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;

    //TODO Relation OneToOne ...
    private Long addressId;

    public Contact() {
    }

    public Contact(String name, Long addressId) {
        this.name = name;
        this.addressId = addressId;
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

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }
}
