package org.tutorials.spring.validators;

import org.tutorials.spring.model.entities.Company;
import org.tutorials.spring.model.entities.Person;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by mahsom on 3/26/16.
 */
public class EmployeeValidator implements ConstraintValidator<Employee, Person> {
    public void initialize(Employee employee) {


    }

    public boolean isValid(Person person, ConstraintValidatorContext constraintValidatorContext) {
        Company company = person.getEmployer();
        Person manager = person.getManager();
        return (company == null || manager == null || company.equals(manager.getEmployer()));
    }
}
