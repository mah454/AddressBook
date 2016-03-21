package org.tutorials.spring.model.entities;

/**
 * Created by mahsom on 3/21/16.
 */
public class Contact {
    private long id;
    private String name;
    private String addressId;

    public Contact() {
    }

    public Contact(String name, String addressId) {
        this.name = name;
        this.addressId = addressId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }
}
