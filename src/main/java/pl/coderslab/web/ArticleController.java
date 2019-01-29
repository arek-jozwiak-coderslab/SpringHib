package pl.coderslab.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.entity.Article;
import pl.coderslab.entity.Category;
import pl.coderslab.repository.ArticleRepository;
import pl.coderslab.repository.CategoryRepository;

import javax.validation.Valid;
import java.util.Collection;

@Controller
public class ArticleController {

    private final CategoryRepository categoryRepository;
    private final ArticleRepository articleRepository;

    public ArticleController(CategoryRepository categoryRepository, ArticleRepository articleRepository) {
        this.categoryRepository = categoryRepository;
        this.articleRepository = articleRepository;
    }

    @GetMapping("/article/add")
    public String addBook(Model model) {
        model.addAttribute("article", new Article());
        return "article/add";
    }


    @RequestMapping(value = "/article/add", method = RequestMethod.POST)
    public String processForm(Model model, @Valid Article article, BindingResult result) {
        if (result.hasErrors()) {
            return "article/add";
        }
        articleRepository.save(article);
        return "redirect:/article/list";
    }

    @ModelAttribute("allcategories")
    public Collection<Category> authors() {
        return this.categoryRepository.findAll();
    }
}
