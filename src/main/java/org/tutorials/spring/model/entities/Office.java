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

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    @ManyToOne
    private Company company;

    public Office() {
    }

    public Office(String name, Address address, Company company) {
        this.name = name;
        this.address = address;
        this.company = company;
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
