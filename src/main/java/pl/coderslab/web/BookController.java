package pl.coderslab.web;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.dao.BookDao;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;
import pl.coderslab.repository.BookRepository;
import pl.coderslab.validator.ValidationGroupName;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Collection;

@Controller
public class BookController {

    private final AuthorDao authorDao;
    private final BookDao bookDao;
    private final PublisherDao publisherDao;
    private final BookRepository bookRepository;

    @Autowired
    public BookController(PublisherDao publisherDao, AuthorDao authorDao, BookRepository bookRepository,
            BookDao bookDao) {
        this.bookDao = bookDao;
        this.authorDao = authorDao;
        this.publisherDao = publisherDao;
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/test-repo/{id}")
    @ResponseBody
    public String testRepo(@PathVariable long id) {
        Book book = bookRepository.findOne(id);
        return book.toString();
    }

    @GetMapping("/book/add")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        return "book/add";
    }

    @ResponseBody
    @Transactional
    @GetMapping("/book/remove/{authorId}/{bookId}")
    public String removeAuthor(@PathVariable long authorId, @PathVariable long bookId) {
        Book b = bookRepository.findOne(bookId);
        Hibernate.initialize(b.getAuthors());
        Author a = authorDao.findById(authorId);

        b.getAuthors().remove(a);
        return "removed";
    }

    @ResponseBody
    @GetMapping("/book/remove2/{authorId}/{bookId}")
    public String removeAuthor2(@PathVariable long authorId, @PathVariable long bookId) {
        bookRepository.deleteUsingSingleQuery("az");
        return "removed";
    }

    @ResponseBody
    @GetMapping("/book/remove3/{bookId}/{authorId}")
    public String removeAuthor3(@PathVariable long authorId, @PathVariable long bookId) {
        bookRepository.deleteUsingSingleNativeQuery(bookId, authorId);

        return "removed";
    }

    @GetMapping("/book/edit/{id}")
    @Transactional
    public String editBook(Model model, @PathVariable long id) {
        Book b = bookDao.findById(id);
        model.addAttribute("book", bookDao.findById(id));
        if (b != null) {
            Hibernate.initialize(b.getAuthors());
        }
        return "book/add";
    }

    @GetMapping("/book/show/{id}")
    public String showBook(Model model, @PathVariable long id) {

        Book book = bookDao.findById(id);

        model.addAttribute("book", book);
        return "book/show";
    }

    @RequestMapping(value = "/book/add", method = RequestMethod.POST)
    public String processForm(Model model, @Valid Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "book/add";
        }
        bookDao.saveBook(book);
        return "redirect:/book/list";
    }

    @RequestMapping(value = "/book/add2", method = RequestMethod.POST)
    public String processForm2(Model model, @Validated({ ValidationGroupName.class }) Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "book/add";
        }
        bookDao.saveBook(book);
        return "redirect:/book/list";
    }

    @GetMapping("/book/list")
    public String showList(Model model) {
        model.addAttribute("books", bookDao.getList());
        return "book/list";
    }

    @ModelAttribute("publishers")
    public Collection<Publisher> publishers() {
        return this.publisherDao.getList();
    }

    @ModelAttribute("allauthors")
    public Collection<Author> authors() {
        return this.authorDao.getList();
    }
}
