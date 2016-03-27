package org.tutorials.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tutorials.spring.model.entities.Contact;
import org.tutorials.spring.model.repositories.ContactRepository;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;

@Controller
public class ContactController {
    @Autowired
    private ContactRepository contactRepository;

    @RequestMapping(value = "contacts.do", method = RequestMethod.GET)
    public String getContactList(Model model) throws ServletException, IOException {
        model.addAttribute("contacts", contactRepository.findAll(new Sort("id")));
        return "contact/list";
    }

    @RequestMapping(value = "contacts.do" ,method = RequestMethod.GET,produces="application/json")
    public @ResponseBody List<Contact> getContactList(){
        return contactRepository.findAll();
    }
}
