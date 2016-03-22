package org.tutorials.spring.servlet;

import org.tutorials.spring.model.repositories.ContactRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by mahsom on 3/21/16.
 */
@WebServlet("/contactList.do")
public class ContactListServlet extends HttpServlet {
    private ContactRepository contactRepository = new ContactRepository();

    public void service(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("contacts", contactRepository.findAll());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/contactList.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}