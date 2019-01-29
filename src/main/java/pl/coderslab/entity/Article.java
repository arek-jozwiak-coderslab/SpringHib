package pl.coderslab.entity;

import pl.coderslab.validator.CategoryLimit;

import javax.persistence.*;
import java.util.List;

@Entity
@CategoryLimit("1")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany
    private List<Category> categories;
    @ManyToOne
    private Author author;
    private String content;

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                '}';
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

}
