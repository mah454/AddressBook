package org.tutorials.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.tutorials.spring.model.entities.Address;
import org.tutorials.spring.model.entities.Company;
import org.tutorials.spring.model.entities.Person;
import org.tutorials.spring.model.repositories.CompanyRepository;
import org.tutorials.spring.model.repositories.PersonRepository;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Created by mahsom on 3/24/16.
 */
@Controller
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @RequestMapping(value = "person.do", params = "add", method = RequestMethod.GET)
    public String getAddPerson() {
        return "person/add";
    }

    @RequestMapping(value = "person.do", params = "edit", method = RequestMethod.GET)
    public String getEditPerson(@RequestParam long id, Model model) throws IOException {
        model.addAttribute("person", personRepository.findOne(id));
        model.addAttribute("managers", personRepository.findAll());
        model.addAttribute("employers", companyRepository.findAll());
        return "person/edit";
    }

    @RequestMapping(value = "person.do", method = RequestMethod.GET)
    public String getViewPerson(@RequestParam long id, Model model) throws IOException {
        model.addAttribute("person", personRepository.findOne(id));
        return "person/view";
    }

    @RequestMapping(value = "person.do", params = "add", method = RequestMethod.POST)
    public String postAddPerson(@RequestParam String name,
                                @RequestParam String state,
                                @RequestParam String city,
                                @RequestParam String street,
                                @RequestParam String zip) {
        Address address = new Address(street, city, state, zip);
        Person person = new Person(name, address);
        personRepository.save(person);
        return "redirect:person.do?id=" + person.getId();
    }

    @RequestMapping(value = "person.do", params = "edit", method = RequestMethod.POST)
    @Transactional
    public String postEditPerson(@RequestParam Long id,
                                 @RequestParam String name,
                                 @RequestParam String state,
                                 @RequestParam String city,
                                 @RequestParam String street,
                                 @RequestParam String zip,
                                 @RequestParam("employer_id") long employerId,
                                 @RequestParam("manager_id") long managerId) {
        Person person = personRepository.findOne(id);
        Address address = person.getAddress();
        person.setManager(personRepository.findOne(managerId));
        person.setEmployer(companyRepository.findOne(employerId));
        address.setState(state);
        address.setCity(city);
        address.setStreet(street);
        address.setZip(zip);

        personRepository.save(person);
        return "redirect:person.do?id=" + person.getId();
    }


    @RequestMapping(value = "person.do", params = "delete", method = RequestMethod.POST)
    public String postPerson(@RequestParam long id) throws ServletException, IOException {
        personRepository.delete(id);
        return "redirect:contacts.do";
    }
}
