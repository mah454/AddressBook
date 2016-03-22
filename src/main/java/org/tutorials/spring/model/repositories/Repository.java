package org.tutorials.spring.model.repositories;

import org.tutorials.spring.model.entities.Address;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

public class Repository<E> {
    private EntityManager entityManager = Persistence.createEntityManagerFactory("addressbook").createEntityManager();
    private final Class<E> entityClass;

    public Repository(Class<E> entityClass) {
        this.entityClass = entityClass;
    }

    public E find(long id) {
        return entityManager.find(entityClass, id);
    }

    public List<E> findAll() {
        return entityManager.createQuery("from " + entityClass.getSimpleName(), entityClass).getResultList();
    }

    public void save(E entity) {
        entityManager.persist(entity);
    }

    public void update(E entity) {
        entityManager.merge(entity);
    }

    public void delete(E entity) {
        entityManager.remove(entity);
    }
}
