package org.tutorials.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.tutorials.spring.model.entities.Address;
import org.tutorials.spring.model.entities.Contact;
import org.tutorials.spring.model.repositories.ContactRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class ContactController {
    @Autowired
    private ContactRepository contactRepository;

    @RequestMapping(value = "contacts.do", method = RequestMethod.GET)
    public String getContactList(Model model) throws ServletException, IOException {
        model.addAttribute("contacts",contactRepository.findAll());
        return "contact/list";
    }

    @RequestMapping(value = "contact.do", params = "add", method = RequestMethod.GET)
    public String getAddContact() {
        return "contact/add";
    }

    @RequestMapping(value = "contact.do", params = "edit", method = RequestMethod.GET)
    public String getEditContact(@RequestParam long id, Model model) throws IOException {
        model.addAttribute("contact", contactRepository.findOne(id));
        return "contact/edit";
    }

    @RequestMapping(value = "contact.do", method = RequestMethod.GET)
    public String getViewContact(@RequestParam long id, Model model) throws IOException {
        model.addAttribute("contact", contactRepository.findOne(id));
        return "contact/view";
    }

    @RequestMapping(value = "contact.do", params = "add" ,method = RequestMethod.POST)
    public String postAddContact(@RequestParam String name ,
                               @RequestParam String state,
                               @RequestParam String city,
                               @RequestParam String street,
                               @RequestParam String zip) {
        Address address = new Address(street,city,state,zip);
        Contact contact = new Contact(name,address);
        contactRepository.save(contact);
        return "redirect:contact.do?id="+contact.getId();
    }
    
    @RequestMapping(value = "contact.do", method = RequestMethod.POST)
    public void postContact(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("edit") != null) {
            /*
            * Edit Contact
            * */
            long id = Long.parseLong(request.getParameter("id"));
            Contact contact = contactRepository.findOne(id);
            Address address = contact.getAddress();
            contact.setName(request.getParameter("name"));
            address.setState(request.getParameter("state"));
            address.setCity(request.getParameter("city"));
            address.setStreet(request.getParameter("street"));
            address.setZip(request.getParameter("zip"));
            contactRepository.save(contact);
            response.sendRedirect("contact.do?id=" + contact.getId());
        } else if (request.getParameter("delete") != null) {
                /*
                * Delete Contact
                * */
            long id = Long.parseLong(request.getParameter("id"));
            Contact contact = contactRepository.findOne(id);

            contactRepository.delete(contact);
            response.sendRedirect("contacts.do");
        }
    }
}
