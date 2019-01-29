package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
	
}
