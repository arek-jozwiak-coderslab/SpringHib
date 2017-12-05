package pl.coderslab.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pl.coderslab.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

	List<Book> findBooksByTitle(String title);

	List<Book> findByTitleIgnoreCaseContaining(String title);

	List<Book> findByTitleStartingWith(String place);

	List<Book> findByAuthorId(Long id);

	@Modifying
	@Transactional
	@Query("delete from Book b where title = ?1")
	void deleteUsingSingleQuery(String firstName);
	
	@Modifying
	@Transactional
	@Query(value = "DELETE FROM `Book_Author` WHERE `books_id` =? AND `authors_id` =?", nativeQuery=true)
	void deleteUsingSingleNativeQuery(long bookId, long authorId);
}
