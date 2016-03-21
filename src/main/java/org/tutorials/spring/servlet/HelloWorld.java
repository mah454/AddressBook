package org.tutorials.spring.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by mahsom on 3/21/16.
 */
@WebServlet("/hello-servlet.do")
public class HelloWorld extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("text/html");
            response.getWriter().println("<html><body><h1>Initialize WEB-MVC Application</h1></body></html>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
