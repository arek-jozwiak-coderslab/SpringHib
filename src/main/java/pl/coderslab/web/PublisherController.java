package pl.coderslab.web;

import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.coderslab.entity.Publisher;
import pl.coderslab.repository.PublisherRepository;

@Controller
@RequestMapping("/publisher")
public class PublisherController {

    private final PublisherRepository publisherRepository;

    @Autowired
    public PublisherController(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @RequestMapping("/{id}/books")
    @ResponseBody
    @Transactional
    public String checkRepoBook(@PathVariable long id) {
        Publisher publisher = publisherRepository.findOne(id);
        if (publisher != null) {
            Hibernate.initialize(publisher.getBooks());
            System.out.println(publisher.getBooks());
        }
        return "res";
    }

}
