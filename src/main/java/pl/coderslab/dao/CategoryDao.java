package pl.coderslab.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import pl.coderslab.entity.Category;

@Component
@Transactional
public class CategoryDao {
    @PersistenceContext
    EntityManager entityManager;

    public void saveCategory(Category entity) {
        entityManager.persist(entity);
    }

    public List<Category> getList() {
        Query query = entityManager.createQuery("SELECT c FROM Category c");
        List<Category> books = query.getResultList();
        return books;
    }

    public Category findById(long id) {
        return entityManager.find(Category.class, id);
    }
}