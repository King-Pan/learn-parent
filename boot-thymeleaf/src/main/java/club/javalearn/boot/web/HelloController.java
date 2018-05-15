package club.javalearn.boot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * @author king-pan
 * @date 2018-05-14
 */
@Controller
public class HelloController {

    @GetMapping("/success")
    public ModelAndView success(HttpServletRequest request, HttpSession session) {
        ModelAndView view = new ModelAndView("success");
        view.addObject("msg", "我是中国人");
        view.addObject("userName", "king-pan");
        view.addObject("age", 100);

        request.setAttribute("key", "请求参数");

        List<String> nameList = Arrays.asList("king", "pan", "maly", "jack");

        Map<String, Object> info = new HashMap<>(3);
        info.put("name", "生物科技");
        info.put("code", "中兴药业");
        info.put("num", "13.56亿");
        view.addObject("companyInfo", info);
        view.addObject("names", nameList);




        return view;
    }
}
