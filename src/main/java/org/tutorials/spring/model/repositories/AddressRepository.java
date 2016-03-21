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
import java.util.ArrayList;
import java.util.List;

public class AddressRepository {
    private DataSource dataSource;

    public AddressRepository() {
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
            String sql = "CREATE TABLE IF NOT EXISTS address (id INTEGER PRIMARY KEY Auto_increment,street VARCHAR (255),city VARCHAR (255),state VARCHAR (255),zip VARCHAR (255))";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.execute();
            preparedStatement.close();
            connection.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Address find(long id) {
        Address address = new Address();
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM address WHERE id=?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                return null;
            } else {
                address = unmarshal(resultSet);
                resultSet.close();
                preparedStatement.close();
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return address;
    }

    public List<Address> findAll() {
        ArrayList<Address> list = new ArrayList<Address>();
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from address");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                list.add(unmarshal(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void create(Address address) {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO address (street,city,state,zip) VALUES (?,?,?,?)");
            preparedStatement.setString(1, address.getStreet());
            preparedStatement.setString(2, address.getCity());
            preparedStatement.setString(3, address.getState());
            preparedStatement.setString(4, address.getZip());
            preparedStatement.execute();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Address address) {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE address set street=?,city=?,state=?,zip=? WHERE id=?");
            preparedStatement.setString(1, address.getStreet());
            preparedStatement.setString(2, address.getCity());
            preparedStatement.setString(3, address.getState());
            preparedStatement.setString(4, address.getZip());
            preparedStatement.setLong(5, address.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(long id) {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM address WHERE  id=?");
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void truncate() {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("TRUNCATE address");
            preparedStatement.execute();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Address unmarshal(ResultSet resultSet) {
        Address address = new Address();
        try {
            address.setId(resultSet.getLong("id"));
            address.setStreet(resultSet.getString("street"));
            address.setCity(resultSet.getString("city"));
            address.setState(resultSet.getString("state"));
            address.setZip(resultSet.getString("zip"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return address;
    }
}
