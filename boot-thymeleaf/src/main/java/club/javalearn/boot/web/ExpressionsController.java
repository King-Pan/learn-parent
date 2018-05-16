package club.javalearn.boot.web;

import club.javalearn.boot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Thymeleaf 简单表达式
 *
 * @author king-pan
 * @date 2018-05-16
 **/
@Controller
public class ExpressionsController {

    @Autowired
    HttpServletRequest request;

    @GetMapping("/expression")
    public String expression(){

        User user = new User();
        user.setUserName("root");
        user.setRoleName("admin");
        user.setNikeName("库克");
        user.setAge(20);
        user.setLastLoginTime(new Date());

        request.setAttribute("user",user);
        request.setAttribute("time",new Date());
        request.setAttribute("msg","Thymeleaf简答表达式页面");

        return "expressions";
    }
}
