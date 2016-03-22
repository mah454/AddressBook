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
            long id = Long.parseLong(req.getParameter("id"));
            Contact contact = contactRepository.find(id);
            Address address = contact.getAddress();
            System.out.println(address.getCity());
            System.out.println(address.getId());
            req.setAttribute("contact", contact);
            req.setAttribute("address", address);
            if (req.getParameter("edit") != null) {
                req.getRequestDispatcher("editContact.jsp").forward(req, resp);
            } else {
                req.getRequestDispatcher("viewContact.jsp").forward(req, resp);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("add") != null) {
            Address address = new Address(req.getParameter("street"),
                    req.getParameter("city"),
                    req.getParameter("state"),
                    req.getParameter("zip"));
            address = addressRepository.save(address);
            Contact contact = new Contact(req.getParameter("name"),address);
            contact = contactRepository.save(contact);
            resp.sendRedirect("/contact.do?id=" + contact.getId());
        } else if (req.getParameter("edit") != null) {
            long id = Long.parseLong(req.getParameter("id"));
            Contact contact = contactRepository.find(id);
            Address address = contact.getAddress();
            contact.setName(req.getParameter("name"));
            address.setState(req.getParameter("state"));
            address.setCity(req.getParameter("city"));
            address.setStreet(req.getParameter("street"));
            address.setZip(req.getParameter("zip"));
            contactRepository.save(contact);
            addressRepository.save(address);
            resp.sendRedirect("contact.do?id="+contact.getId());
        } else if (req.getParameter("delete")!=null) {
            long id = Long.parseLong(req.getParameter("id"));
            Contact contact = contactRepository.find(id);
            Address address = contact.getAddress();
            contactRepository.delete(contact);
            addressRepository.delete(address);
            resp.sendRedirect("contacts.do");
        } else {
            super.doPost(req, resp);
        }
    }
}
