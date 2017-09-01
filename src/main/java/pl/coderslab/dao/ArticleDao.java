package pl.coderslab.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import pl.coderslab.entity.Article;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Burger;

@Component
@Transactional
public class ArticleDao {
	@PersistenceContext
	EntityManager entityManager;

	public Article saveArticle(Article entity) {
		entityManager.persist(entity);
		return entity;
	}

	public List<Article> getLast(int count) {
		Query query = entityManager.createQuery("SELECT a FROM Article a ORDER BY id DESC");
		query.setMaxResults(count);
		List<Article> burgers = query.getResultList();
		return burgers;
	}
	
    public List<Book> getList(){
    	Query query = entityManager.createQuery("SELECT a FROM Article a");
    	List<Book> books = query.getResultList();
    	return books;
    }
	


}