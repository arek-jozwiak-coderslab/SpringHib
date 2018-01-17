package pl.coderslab.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import javax.validation.groups.Default;

import org.hibernate.validator.constraints.NotBlank;

import pl.coderslab.validator.RepeatAuthor;
import pl.coderslab.validator.StartWith;
import pl.coderslab.validator.ValidationGroupName;

@Entity
@RepeatAuthor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @StartWith(value = "a", value2 = "z", groups = { Default.class, ValidationGroupName.class })
    @Size(min = 2)
    private String title;
    @ManyToOne
    private Author author;
    @ManyToOne
    private Publisher publisher;
    @ManyToMany
    private List<Author> authors;

    @NotBlank(groups = { ValidationGroupName.class })
    private String description;
    @Min(value = 1, groups = { ValidationGroupName.class })
    private int rating;

    private boolean active;

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Book [id=" + id + ", title=" + title + "publisher=" + publisher + ", description=" + description
                + ", rating=" + rating + "]";
    }
}