package org.tutorials.spring.model.entities;

import javax.persistence.*;

/**
 * Created by mahsom on 3/24/16.
 */
@MappedSuperclass
public class BaseEntity {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "default_seq")
    private long id ;

    @Version
    private long version ;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }
}
