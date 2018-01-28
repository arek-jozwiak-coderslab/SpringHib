package pl.coderslab.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Component;

import pl.coderslab.entity.Book;
import pl.coderslab.entity.PersonGroup;

@Component
@Transactional
public class BookDao {
    @PersistenceContext
    EntityManager entityManager;

    public void saveBook(Book entity) {
        entityManager.persist(entity);
    }

    public List<Book> getList() {
        Query query = entityManager.createQuery("SELECT b FROM Book b");
        List<Book> books = query.getResultList();
        return books;
    }

    public Book findById(long id) {

        return entityManager.find(Book.class, id);
    }

    public Book findByIdWithAuthors(long id) {
        Book b = entityManager.find(Book.class, id);
        Hibernate.initialize(b.getAuthors());
        return b;
    }
}