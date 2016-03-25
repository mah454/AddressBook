package org.tutorials.spring.model.entities;

import javax.persistence.*;

/**
 * Created by mahsom on 3/23/16.
 */
@Entity
@SequenceGenerator(name = "default_seq", sequenceName = "office_seq")
public class Office extends UrlEntity {

    @Column
    private String name;

    @OneToOne
    private Address address;

    @ManyToOne
    private Company company;

    public Office() {
    }

    public Office(Address address) {
        this.address = address;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
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
