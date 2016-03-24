package org.tutorials.spring.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tutorials.spring.model.entities.Person;

/**
 * Created by mahsom on 3/24/16.
 */
public interface PersonRepository extends JpaRepository<Person,Long> {
}
