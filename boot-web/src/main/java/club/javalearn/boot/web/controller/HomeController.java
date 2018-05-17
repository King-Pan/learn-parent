package club.javalearn.boot.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * learn-parent
 *
 * @author king-pan
 * @date 2018-05-17
 **/
@RestController
public class HomeController {

    @GetMapping("/web")
    public String hello() {
        return "Hello Spring Boot web";
    }

    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView view = new ModelAndView();
        view.setViewName("login");
        return view;
    }

    @GetMapping(value = {"/","/index","/home"})
    public ModelAndView index() {
        ModelAndView view = new ModelAndView();
        view.setViewName("dashboard");
        return view;
    }
}
