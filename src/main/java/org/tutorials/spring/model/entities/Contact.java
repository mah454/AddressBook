package org.tutorials.spring.model.entities;

/**
 * Created by mahsom on 3/21/16.
 */
public class Contact {
    private long id;
    private String name;
    private Long addressId;

    public Contact() {
    }

    public Contact(String name, Long addressId) {
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

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }
}
