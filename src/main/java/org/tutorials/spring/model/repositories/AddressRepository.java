package org.tutorials.spring.model.repositories;

import org.tutorials.spring.model.entities.Address;
import org.tutorials.spring.model.entities.Contact;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AddressRepository extends Repository<Address> {

    public AddressRepository() {
        super(Address.class);
    }
}
