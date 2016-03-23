package org.tutorials.spring.servlet;

import org.tutorials.spring.model.entities.Address;
import org.tutorials.spring.model.entities.Contact;
import org.tutorials.spring.model.repositories.AddressRepository;
import org.tutorials.spring.model.repositories.ContactRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/contact.do")
public class ContactServlet extends HttpServlet {
    private final ContactRepository contactRepository = new ContactRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("add") != null) {
            req.getRequestDispatcher("addContact.jsp").forward(req, resp);
        } else {
            /*
            * Get contact information from id parameter
            * */
            long id = Long.parseLong(req.getParameter("id"));
            Contact contact = contactRepository.find(id);
            req.setAttribute("contact", contact);
            if (req.getParameter("edit") != null) {
                /*
                * If client click on edit button
                * dispatch to editContact.jsp Page
                * */
                req.getRequestDispatcher("editContact.jsp").forward(req, resp);
            } else {
                /*
                * If client do not click on edit button
                * go to viewContact.jsp Page
                * */
                req.getRequestDispatcher("viewContact.jsp").forward(req, resp);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("add") != null) {
            /*
            * Get new contact information and save that on database
            * */
            Address address = new Address(req.getParameter("street"),
                    req.getParameter("city"),
                    req.getParameter("state"),
                    req.getParameter("zip"));
            Contact contact = new Contact(req.getParameter("name"), address);
            contact = contactRepository.save(contact);
            /*
            * Redirect client to contact view page
            * */
            resp.sendRedirect("/contact.do?id=" + contact.getId());
        } else if (req.getParameter("edit") != null) {
            /*
            * Find contact information from id parameter and update contact
            * */
            long id = Long.parseLong(req.getParameter("id"));
            Contact contact = contactRepository.find(id);
            Address address = contact.getAddress();
            contact.setName(req.getParameter("name"));
            address.setState(req.getParameter("state"));
            address.setCity(req.getParameter("city"));
            address.setStreet(req.getParameter("street"));
            address.setZip(req.getParameter("zip"));
            contactRepository.save(contact);
            /*
            * Redirect client to contact view page
            * */
            resp.sendRedirect("contact.do?id=" + contact.getId());
        } else if (req.getParameter("delete") != null) {
            /*
            * Delete contact and addressbook from database
            * */
            long id = Long.parseLong(req.getParameter("id"));
            Contact contact = contactRepository.find(id);
            contactRepository.delete(contact);
            /*
            * Redirect client to show all contact page
            * */
            resp.sendRedirect("contacts.do");
        } else {
            super.doPost(req, resp);
        }
    }
}
