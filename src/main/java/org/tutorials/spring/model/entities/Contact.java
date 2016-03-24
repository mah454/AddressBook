package org.tutorials.spring.model.entities;

import javax.persistence.*;

/**
 * Created by mahsom on 3/21/16.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Contact {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="contact_seq")
    @SequenceGenerator(name = "contact_seq" , sequenceName = "contact_seq")
    private long id;
    @Column
    private String name;


    public Contact() {
    }

    public Contact(String name) {
        this.name = name;
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
}
