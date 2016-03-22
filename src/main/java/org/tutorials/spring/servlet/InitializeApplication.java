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
        /*Address address = new Address();
        address.setState("Rezvan 11");
        address.setCity("Fazel Abad");
        address.setStreet("Emam Khomeini");
        address.setZip("4941117311");*/
        addressRepository.init();
//        addressRepository.create(address);

//        System.out.println(address.getId());
        ContactRepository contactRepository = new ContactRepository();
        contactRepository.init();
//        contactRepository.create(new Contact("Sina",address.getId()));
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
