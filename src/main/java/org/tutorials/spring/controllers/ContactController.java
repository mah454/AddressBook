package org.tutorials.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.tutorials.spring.model.repositories.ContactRepository;

import javax.servlet.ServletException;
import java.io.IOException;

@Controller
public class ContactController {
    @Autowired
    private ContactRepository contactRepository;

    @RequestMapping("contacts.do")
    public String getContactList(Model model) throws ServletException, IOException {
        model.addAttribute(contactRepository.findAll());
        return "contact/list";
    }

    @RequestMapping(value = "contact.do", params = "add")
    public String getAddContact() {
        return "contact/add";
    }

    @RequestMapping(value = "contact.do", params = "edit")
    public String getEditContact(@RequestParam long id, Model model) throws IOException {
        model.addAttribute("contact", contactRepository.findOne(id));
        return "contact/edit";
    }

    @RequestMapping(value = "contact.do")
    public String getViewContact(@RequestParam long id, Model model) throws IOException {
        model.addAttribute("contact", contactRepository.findOne(id));
        return "contact/view";
    }
}
