package pl.coderslab.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.coderslab.dao.ArticleDao;
import pl.coderslab.dao.CategoryDao;

@Controller
public class HomePageController {
	
	@Autowired
	ArticleDao articleDao;
	@Autowired
	CategoryDao categoryDao;

	@RequestMapping("/ex5")
	public String ex5(Model model){
		model.addAttribute("articles", articleDao.getLast(5));
		model.addAttribute("categories", categoryDao.getList());
		return "article/list";
	}
	
	@RequestMapping("/ex5/category/{id}")
	public String ex5(Model model, @PathVariable long id){
		model.addAttribute("articles", articleDao.getByCategoryId(id));
		return "article/listcategory";
	}
}
