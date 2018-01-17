package pl.coderslab.web;

import java.util.Collection;

import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import pl.coderslab.entity.Unit;
import pl.coderslab.entity.User;
import pl.coderslab.repository.UnitRepository;
import pl.coderslab.repository.UserRepository;

@Controller
public class MuserController {

    private final UserRepository userRepository;
    private final UnitRepository unitRepository;

    @Autowired
    public MuserController(UserRepository muserRepository, UnitRepository munitRepository) {
        this.userRepository = muserRepository;
        this.unitRepository = munitRepository;
    }

    @GetMapping("/user/edit/{id}")
    @Transactional
    public String editBook(Model model, @PathVariable long id) {
        User user = userRepository.findOne(id);
        if (user != null) {
            Hibernate.initialize(user.getUnits());
        }
        model.addAttribute("user", user);
        return "user/addm";
    }

    @ModelAttribute("allutnits")
    public Collection<Unit> units() {
        return this.unitRepository.findAll();
    }
}
