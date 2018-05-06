package club.javalearn.boot.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HelloController {

    @GetMapping("/success")
    public ModelAndView success(){
        return new ModelAndView("success");
    }
}
