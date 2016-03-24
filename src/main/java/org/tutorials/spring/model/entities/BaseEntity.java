package org.tutorials.spring.model.entities;

import javax.persistence.*;

/**
 * Created by mahsom on 3/24/16.
 */
@MappedSuperclass
public abstract class BaseEntity {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "default_seq")
    private long id ;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
