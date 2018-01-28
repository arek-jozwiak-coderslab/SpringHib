package pl.coderslab.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import pl.coderslab.entity.Burger;

@Component
@Transactional
public class BurgerDao {
    @PersistenceContext
    EntityManager entityManager;

    public Burger saveBurger(Burger entity) {
        entityManager.persist(entity);
        return entity;
    }

    public List<Burger> getList() {
        Query query = entityManager.createQuery("SELECT p FROM Burger p");
        List<Burger> burgers = query.getResultList();
        return burgers;
    }

    public void delete(Burger entity) {
        entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
    }

    public Burger findById(long id) {
        return entityManager.find(Burger.class, id);
    }
}