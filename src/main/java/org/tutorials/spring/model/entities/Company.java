package org.tutorials.spring.model.entities;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by mahsom on 3/23/16.
 */
@Entity
public class Company extends Contact {

    @OneToMany(mappedBy = "company",orphanRemoval = true)
    private List<Office> offices;

    public Company(String name, List<Office> offices) {
        super(name);
        this.offices = offices;
    }

    public Company() {
    }

    public List<Office> getOffices() {
        return offices;
    }

    public void setOffices(List<Office> offices) {
        this.offices = offices;
    }
}
