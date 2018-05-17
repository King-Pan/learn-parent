package club.javalearn.boot.web;

import club.javalearn.boot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * learn-parent
 *
 * @author king-pan
 * @date 2018-05-16
 **/
@Controller
public class TagController {

    @Autowired
    HttpSession session;

    @GetMapping("/tag")
    public String tag(Model model) {
        model.addAttribute("text", "<div><p>哈哈</p><br/><p>李四</p></div>");
        User user = new User();
        user.setUserName("root");
        user.setRoleName("admin");
        user.setNikeName("库克");
        user.setAge(20);
        user.setLastLoginTime(new Date());

        session.setAttribute("user", user);

        return "thymeleaf-tag";
    }
}
