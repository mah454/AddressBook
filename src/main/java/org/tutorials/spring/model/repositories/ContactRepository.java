package org.tutorials.spring.model.repositories;

import org.tutorials.spring.model.entities.Address;
import org.tutorials.spring.model.entities.Contact;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContactRepository {
    private DataSource dataSource;

    public ContactRepository() {
        try {
            Context context = new InitialContext();
            try {
                dataSource = (DataSource) context.lookup("java:comp/env/jdbc/addressbook");
            } finally {
                context.close();
            }
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }

    public void init() {
        try {
            Connection connection = dataSource.getConnection();

            /*
            * MySQL Query [Note : Auto_Increment,Foreign key]
            * String sql = "CREATE TABLE IF NOT EXISTS contact (id INTEGER PRIMARY KEY Auto_increment,name VARCHAR (255),address_id INTEGER ,FOREIGN KEY (address_id) REFERENCES address(id))";
            * */

            /*
            * PostgreSQL Query
            * */
            String sql = "CREATE TABLE IF NOT EXISTS contact (id serial PRIMARY KEY ,name VARCHAR (255),address_id INTEGER REFERENCES address(id))";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.execute();
            preparedStatement.close();
            connection.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Contact find(long id) {
        Contact contact = new Contact();
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM contact WHERE id=?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                return null;
            } else {
                contact = unmarshal(resultSet);
                resultSet.close();
                preparedStatement.close();
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contact;
    }

    public List<Contact> findAll() {
        ArrayList<Contact> list = new ArrayList<Contact>();
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from contact ORDER BY id");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                list.add(unmarshal(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void create(Contact contact) {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO contact (name,address_id) VALUES (?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, contact.getName());
            preparedStatement.setLong(2, contact.getAddressId());
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if(resultSet.next())
                contact.setId(resultSet.getLong("id"));
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Contact contact) {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE contact set name=?,address_id=?WHERE id=?");
            preparedStatement.setString(1, contact.getName());
            preparedStatement.setLong(2, contact.getAddressId());
            preparedStatement.setLong(3, contact.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Contact contact) {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM contact WHERE  id=?");
            preparedStatement.setLong(1, contact.getId());
            preparedStatement.execute();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Contact unmarshal(ResultSet resultSet) {
        Contact contact = new Contact();
        try {
            contact.setId(resultSet.getLong("id"));
            contact.setName(resultSet.getString("name"));
            contact.setAddressId(resultSet.getLong("address_id"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return contact;
    }
}
