package club.javalearn.boot.web;

import club.javalearn.boot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Thymeleaf
 *
 * @author king-pan
 * @date 2018-05-15
 **/
@RestController
public class VariablesController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private HttpServletResponse response;

    @Autowired
    private HttpSession session;

    @Autowired
    private ServletContext servletContext;

    @GetMapping("/variables")
    public ModelAndView variables(){
        ModelAndView view = new ModelAndView("variables");
        request.setAttribute("requestP1","HttpServletRequest参数1");
        request.setAttribute("requestP2","HttpServletRequest参数2");
        request.setAttribute("requestP3","HttpServletRequest参数3");

        User user = new User();
        user.setAge(20);
        user.setNikeName("残风VS逝梦");
        user.setRoleName("超级管理员");
        user.setUserName("root");
        session.setAttribute("user",user);

        servletContext.setAttribute("name","超级无敌有限公司");
        servletContext.setAttribute("email","admin@admin.com");
        servletContext.setAttribute("phone","8888888888888");


        view.addObject("springMVCP1","springMVC参数1");
        view.addObject("springMVCP2","springMVC参数2");
        view.addObject("springMVCP3","springMVC参数3");

        return view;
    }
}
