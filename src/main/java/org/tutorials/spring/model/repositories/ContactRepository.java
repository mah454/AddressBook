package org.tutorials.spring.model.repositories;

import org.tutorials.spring.model.entities.Contact;

public class ContactRepository extends Repository<Contact> {

    public ContactRepository() {
        super(Contact.class);
    }
}
