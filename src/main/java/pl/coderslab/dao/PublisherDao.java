package pl.coderslab.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import pl.coderslab.entity.Publisher;

@Component
@Transactional
public class PublisherDao {
    @PersistenceContext
    EntityManager entityManager;
    
    public List<Publisher> getList(){
    	Query query = entityManager.createQuery("SELECT p FROM Publisher p");
    	List<Publisher> publishers = query.getResultList();
    	return publishers;
    }
}