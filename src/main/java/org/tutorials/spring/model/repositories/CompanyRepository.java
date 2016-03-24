package org.tutorials.spring.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tutorials.spring.model.entities.Company;

/**
 * Created by mahsom on 3/24/16.
 */
public interface CompanyRepository extends JpaRepository<Company, Long> {
}
