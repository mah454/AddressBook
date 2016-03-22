package org.tutorials.spring.servlet;

import org.tutorials.spring.model.repositories.ContactRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by mahsom on 3/21/16.
 */
@WebServlet("/contacts.do")
public class ContactListServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ContactRepository contactRepository = new ContactRepository();
        request.setAttribute("contacts", contactRepository.findAll());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/contactList.jsp");
        dispatcher.forward(request, response);
    }
}