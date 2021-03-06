package org.tutorials.spring.model.entities;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;

/**
 * Created by mahsom on 3/21/16.
 */

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@SequenceGenerator(name = "default_seq", sequenceName = "contact_seq")
public class Contact extends UrlEntity {

    @Column(nullable = false)
    @NotBlank
    private String name;

    public Contact() {
    }

    public Contact(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
