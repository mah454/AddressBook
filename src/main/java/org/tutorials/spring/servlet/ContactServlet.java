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
    private final AddressRepository addressRepository = new AddressRepository();
    private final ContactRepository contactRepository = new ContactRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("add") != null) {
            req.getRequestDispatcher("addContact.jsp").forward(req, resp);
        } else {
            //TODO
            super.doGet(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("add") != null) {
            Address address = new Address();
            address.setState(req.getParameter("state"));
            address.setCity(req.getParameter("city"));
            address.setStreet(req.getParameter("street"));
            address.setZip(req.getParameter("zip"));
            addressRepository.create(address);
            Contact contact = new Contact();
            contact.setName(req.getParameter("name"));
            contact.setAddressId(address.getId());
            contactRepository.create(contact);
            resp.sendRedirect("/contacts.do");
        } else {
            super.doPost(req, resp);
        }
    }
}
