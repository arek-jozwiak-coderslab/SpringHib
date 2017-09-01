package pl.coderslab.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.coderslab.dao.BurgerDao;
import pl.coderslab.entity.Burger;
import pl.coderslab.entity.Person;

@Controller
public class BurgerController {
	
	@Autowired
	BurgerDao burgerDao;

	@GetMapping("/burger/add")
	public String addBurger(Model model){
		model.addAttribute("burger", new Burger());
		return "burger/add";
	}
	
	@GetMapping("/burger/edit/{id}")
	public String editBurger(Model model, @PathVariable long id){
		Burger burger = burgerDao.findById(id);
		model.addAttribute("burger", burger);
		return "burger/add";
	}
	

	
	@RequestMapping(value = "burger/list", method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("burgers", burgerDao.getList());
		return "burger/list";
	}
	
	@RequestMapping(value = "burger/delete/{id}",  method = RequestMethod.GET)
	public String delete(@PathVariable long id) {
		System.out.println(id);
		Burger burger = burgerDao.findById(id);
		burgerDao.delete(burger);
		return "redirect: ../list";
	}
	

}
