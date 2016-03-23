package org.tutorials.spring.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tutorials.spring.model.entities.Contact;

public interface ContactRepository extends JpaRepository<Contact,Long> {
}
