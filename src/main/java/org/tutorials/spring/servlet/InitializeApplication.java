package org.tutorials.spring.servlet;

import org.tutorials.spring.model.entities.Address;
import org.tutorials.spring.model.entities.Contact;
import org.tutorials.spring.model.repositories.AddressRepository;
import org.tutorials.spring.model.repositories.ContactRepository;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


/**
 * Created by mahsom on 3/21/16.
 */
@WebListener
public class InitializeApplication implements ServletContextListener {
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println(">>>> initializing Application <<<<");
        AddressRepository addressRepository = new AddressRepository();
        addressRepository.init();
        ContactRepository contactRepository = new ContactRepository();
        contactRepository.init();
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
