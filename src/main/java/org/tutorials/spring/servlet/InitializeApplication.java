package org.tutorials.spring.servlet;

import org.tutorials.spring.model.entities.Address;
import org.tutorials.spring.model.repositories.AddressRepository;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by mahsom on 3/21/16.
 */
public class InitializeApplication implements ServletContextListener {
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        AddressRepository addressRepository = new AddressRepository() ;
        addressRepository.init();
        Address address = new Address() ;
        address.setStreet("Rezvan 11");
        address.setCity("Fazel Abad");
        address.setState("Golestan");
        address.setZip("4941117311");
        addressRepository.create(address);
        addressRepository.truncate();
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
