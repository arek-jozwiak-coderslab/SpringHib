package pl.coderslab.web;

import java.util.Collection;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.groups.Default;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.coderslab.dao.PersonGroupDao;
import pl.coderslab.entity.Person;
import pl.coderslab.entity.PersonGroup;
import pl.coderslab.services.PersonService;

@Controller
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonGroupDao personGroupDao;

    @Autowired
    Validator validator;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping("/validateperson")
    @ResponseBody
    public String validatePerson() {
        Person person = new Person();
        person.setLogin("jan");
        person.setPassword("2");
        person.setTitle("qazw");
        person.setRating(1);
        Set<ConstraintViolation<Person>> violations = validator.validate(person);
        if (!violations.isEmpty()) {
            for (ConstraintViolation<Person> constraintViolation : violations) {
                System.out.println(constraintViolation.getPropertyPath() + " " + constraintViolation.getMessage());
            }
        } else {
            // save object
        }

        return "";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String processSimple(@RequestParam String search, Model model) {
        // serach books
        return "form/search results";
    }

    @ModelAttribute("groups")
    public Collection<PersonGroup> populateGropups() {
        return this.personGroupDao.getList();
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegistrationForm(Model model) {
        // model.addAttribute("groups",personGroupDao.getList() ); // == method
        // populateGropups
        model.addAttribute("person", new Person());
        return "person/registerForm";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String processForm(@Validated({ Default.class }) Person person, BindingResult result) {
        if (result.hasErrors()) {

            return "person/registerForm";
        }
        personService.create(person);
        return "person/success";
    }

}
