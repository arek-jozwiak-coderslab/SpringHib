package pl.coderslab.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.coderslab.dao.BurgerDao;
import pl.coderslab.entity.Burger;

@Controller
@RequestMapping("/burger")
public class BurgerController {

    private final BurgerDao burgerDao;

    @Autowired
    public BurgerController(BurgerDao burgerDao) {
        this.burgerDao = burgerDao;
    }

    @GetMapping("/add")
    public String addBurger(Model model) {
        model.addAttribute("burger", new Burger());
        return "burger/add";
    }

    @PostMapping("/add")
    public String processAddBurger(@ModelAttribute Burger burger, Model model) {
        burgerDao.saveBurger(burger);
        return "redirect:/burger/list";
    }

    @GetMapping("/edit/{id}")
    public String editBurger(Model model, @PathVariable long id) {
        Burger burger = burgerDao.findById(id);
        model.addAttribute("burger", burger);
        return "burger/add";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("burgers", burgerDao.getList());
        return "burger/list";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable long id) {
        System.out.println(id);
        Burger burger = burgerDao.findById(id);
        burgerDao.delete(burger);
        return "redirect: ../list";
    }

}
