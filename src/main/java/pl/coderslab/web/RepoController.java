package pl.coderslab.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.coderslab.entity.Book;
import pl.coderslab.repository.BookRepository;

@Controller
public class RepoController {

    private final BookRepository bookRepository;

    @Autowired
    public RepoController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/checkBook")
    @ResponseBody
    public String checkRepoBook() {
        List<Book> books = bookRepository.findAll();
        return books.toString();
    }

    @GetMapping("/checkrepo")
    @ResponseBody
    public String showList(Model model) {
        StringBuilder builder = new StringBuilder();
        List<Book> books = bookRepository.findBooksByTitle("Thinking in java");
        builder.append(books.toString());

        List<Book> books2 = bookRepository.findByTitleIgnoreCaseContaining("Thinking");
        builder.append("<br/><hr/>");
        builder.append(books2.toString());
        return builder.toString();
    }
}
