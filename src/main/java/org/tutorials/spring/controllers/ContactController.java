package org.tutorials.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.tutorials.spring.model.repositories.ContactRepository;

import javax.servlet.ServletException;
import java.io.IOException;

@Controller
public class ContactController {
    @Autowired
    private ContactRepository contactRepository;

    @RequestMapping(value = "contacts.do", method = RequestMethod.GET)
    public String getContactList(Model model) throws ServletException, IOException {
        model.addAttribute("contacts", contactRepository.findAll());
        return "contact/list";
    }
}
