package org.tutorials.spring.model.entities;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

/**
 * Created by mahsom on 3/23/16.
 */
@Entity
public class Company extends Contact {

    @OneToMany
    private Set<Office> offices;

    public Company(String name, Set<Office> offices) {
        super(name);
        this.offices = offices;
    }

    public Company() {
    }

    @Override
    public String getUrl() {
        return "company.do?id=" + getId();
    }

    public Set<Office> getOffices() {
        return offices;
    }

    public void setOffices(Set<Office> offices) {
        this.offices = offices;
    }
}
