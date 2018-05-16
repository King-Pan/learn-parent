package club.javalearn.boot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Spring Boot + Thymeleaf 实现国际化
 *
 * @author king-pan
 * @date 2018-05-16
 **/
@Controller
public class I18nController {

    @GetMapping("/i18n")
    public String i18n(){
        return "i18n";
    }

}
