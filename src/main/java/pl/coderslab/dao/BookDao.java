package pl.coderslab.dao;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import pl.coderslab.entity.Book;

@Component
@Transactional
public class BookDao {
    @PersistenceContext
    EntityManager entityManager;
    
    public void saveBook(Book entity) {
        entityManager.persist(entity);
    }
    
    public List<Book> getList(){
    	Query query = entityManager.createQuery("SELECT b FROM Book b");
    	List<Book> books = query.getResultList();
    	return books;
    }
}