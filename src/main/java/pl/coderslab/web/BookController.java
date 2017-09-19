package pl.coderslab.web;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.coderslab.dao.BookDao;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;

@Controller
public class BookController {

	@Autowired
	BookDao bookDao;

	private final PublisherDao publisherDao;

	@Autowired
	public BookController(PublisherDao publisherDao) {
		this.publisherDao = publisherDao;
	}

	@GetMapping("/book/add")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		return "book/add";
	}

	@RequestMapping(value = "/book/add", method = RequestMethod.POST)
	@ResponseBody
	public String processForm(@ModelAttribute Book book) {
		bookDao.saveBook(book);
		return "success";
	}

	@GetMapping("/books")
	public String showList(Model model) {
		model.addAttribute("books", bookDao.getList());
		return "book/list";
	}
	
	
	@ModelAttribute("publishers")
	public Collection<Publisher> publishers() {
	    return this.publisherDao.getList();
	}
}
