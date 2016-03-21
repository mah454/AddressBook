package org.tutorials.spring.model.repositories;

import org.tutorials.spring.model.entities.Address;
import org.tutorials.spring.model.entities.Contact;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ContactRepository {
    private DataSource dataSource;

    public ContactRepository() {
        try {
            Context context = new InitialContext();
            try {
                dataSource = (DataSource) context.lookup("java:comp/env/jdbc/jndi");
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
            String sql = "CREATE TABLE IF NOT EXISTS contact (id INTEGER PRIMARY KEY Auto_increment,name VARCHAR (255),address_id INTEGER ,FOREIGN KEY (address_id) REFERENCES address)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.execute();
            preparedStatement.close();
            connection.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Contact find(long id)  {
        Contact contact = new Contact();
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM contact WHERE id=?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                return null;
            } else {
                contact.setId(resultSet.getLong("id"));
                contact.setName(resultSet.getString("address"));
                contact.setAddressId(resultSet.getString("address_id"));
                resultSet.close();
                preparedStatement.close();
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contact ;
    }

    public void create(Contact contact) {
        try {
            Connection connection = dataSource.getConnection() ;
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO contact () VALUES (?,?)");
            preparedStatement.setString(1,contact.getName());
            preparedStatement.setString(2,contact.getAddressId());
            preparedStatement.execute();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Contact contact) {
        try {
            Connection connection = dataSource.getConnection() ;
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE contact set name=?,address_id=?WHERE id=?");
            preparedStatement.setString(1,contact.getName());
            preparedStatement.setString(2,contact.getAddressId());
            preparedStatement.setLong(3,contact.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(long id) {
        try {
            Connection connection = dataSource.getConnection() ;
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM contact WHERE  id=?");
            preparedStatement.setLong(1,id);
            preparedStatement.execute();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void truncate() {
        try {
            Connection connection = dataSource.getConnection() ;
            PreparedStatement preparedStatement = connection.prepareStatement("TRUNCATE address");
            preparedStatement.execute();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}