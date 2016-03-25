package org.tutorials.spring.model.entities;

import javax.persistence.MappedSuperclass;

/**
 * Created by mahsom on 3/25/16.
 */

@MappedSuperclass
public class UrlEntity extends BaseEntity {
    public String getUrl() {
        return getClass().getSimpleName().toLowerCase() + "?id=" + getId();
    }
}
