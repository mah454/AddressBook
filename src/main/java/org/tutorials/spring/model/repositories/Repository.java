package org.tutorials.spring.model.repositories;

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
        return entityManager.createQuery("from " + entityClass.getSimpleName() + " order by id", entityClass).getResultList();
    }

    public E save(E entity) {
        entityManager.getTransaction().begin();
        entity = entityManager.merge(entity);
        entityManager.getTransaction().commit();
        return entity;
    }

    public void delete(E entity) {
        entityManager.getTransaction().begin();
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
    }
}
