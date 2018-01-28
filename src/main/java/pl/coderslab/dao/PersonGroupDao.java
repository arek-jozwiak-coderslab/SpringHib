package pl.coderslab.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import pl.coderslab.entity.PersonGroup;

@Component
@Transactional
public class PersonGroupDao {
    @PersistenceContext
    EntityManager entityManager;

    public PersonGroup findById(long id) {
        return entityManager.find(PersonGroup.class, id);
    }

    public PersonGroup savePerson(PersonGroup entity) {
        entityManager.persist(entity);
        return entity;
    }

    public List<PersonGroup> getList() {
        Query query = entityManager.createQuery("SELECT p FROM PersonGroup p");
        List<PersonGroup> personGroups = query.getResultList();
        return personGroups;
    }
}