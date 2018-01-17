package pl.coderslab.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import pl.coderslab.entity.Author;

@Component
@Transactional
public class AuthorDao {
    @PersistenceContext
    EntityManager entityManager;

    public void saveCategory(Author entity) {
        entityManager.persist(entity);
    }

    public List<Author> getList() {
        Query query = entityManager.createQuery("SELECT c FROM Author c");
        List<Author> books = query.getResultList();
        return books;
    }

    public Author findById(long id) {
        return entityManager.find(Author.class, id);
    }
}