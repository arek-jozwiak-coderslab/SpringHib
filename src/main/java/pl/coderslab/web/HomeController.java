package pl.coderslab.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("/")
    public String indexAction() {
        return "index";
    }

    @GetMapping("/testAction")
    @ResponseBody
    public String testAction() {
        return "testAction";
    }

}
