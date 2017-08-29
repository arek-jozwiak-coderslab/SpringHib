package pl.coderslab.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pl.coderslab.entity.Person;
import pl.coderslab.services.PersonService;

@Controller
public class PersonController {
	
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }
    
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String processSimple(@RequestParam String search, Model model) {
        // serach books
        return "form/search results";
    }

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String showRegistrationForm(Model model) {
		model.addAttribute("person", new Person());
		return "person/registerForm";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String processForm(@ModelAttribute Person person) {
		personService.create(person);
		return "person/success";
	}

}
