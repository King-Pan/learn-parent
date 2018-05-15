package club.javalearn.boot.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * learn-parent
 *
 * @author king-pan
 * @date 2018-05-15
 **/
@RestController
public class EachController {

    @GetMapping("/each")
    public ModelAndView each(HttpServletRequest request) {
        ModelAndView view = new ModelAndView("each");

        //list 数据类型
        view.addObject("list", Arrays.asList("king", "pan", "jack", "张三", "小龙女", "过儿"));

        //map 数据类型
        Map<String, Object> companyInfo = new HashMap<>(4);
        companyInfo.put("name", "智科技科技有限公司");
        companyInfo.put("code", "XDS-2009-2888");
        companyInfo.put("person", 5000);
        companyInfo.put("money", 2000);
        view.addObject("companyInfo",companyInfo);

        //set 数据类型
        Set<String> set = new HashSet<>(5);
        set.add("中百超市");
        set.add("中百仓储");
        set.add("沃尔玛");
        set.add("7TT");
        set.add("可多");
        view.addObject("set", set);

        //数组 数据类型
        String[] cityArray = new String[]{"北京","上海","深圳","广州","杭州","武汉"};
        view.addObject("cityArray",cityArray);

        //request
        request.setAttribute("requestParam", "HttpServletRequest请求参数");

        return view;
    }
}
