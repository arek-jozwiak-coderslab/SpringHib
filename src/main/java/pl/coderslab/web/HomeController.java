package pl.coderslab.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class HomeController {
    private final Logger logger = LoggerFactory.getLogger(HomeController.class);
    
    @GetMapping("/")
    public String indexAction() {
        logger.info("index info from home controller");
        return "index";
    }

    @GetMapping("/testAction")
    @ResponseBody
    public String testAction() {
        return "testAction";
    }

}
