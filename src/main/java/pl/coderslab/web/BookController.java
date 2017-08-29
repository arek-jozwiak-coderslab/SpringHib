package pl.coderslab.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.coderslab.dao.BookDao;
import pl.coderslab.entity.Book;

@Controller
public class BookController {
	
	@Autowired
	BookDao bookDao;

	@GetMapping("/book/add")
	@ResponseBody
	public String addBook(){
		Book book = new Book();
		book.setTitle("Thinking in java");
		book.setDescription("abuot java programming");
		bookDao.saveBook(book);
		return "ok";
	}
	
	@GetMapping("/books")
	public String showList(Model model){
		model.addAttribute("books", bookDao.getList());
		return "book/list";
	}
}
