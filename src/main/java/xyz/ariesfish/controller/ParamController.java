package xyz.ariesfish.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import xyz.ariesfish.domain.Account;
import xyz.ariesfish.domain.User;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
@RequestMapping(path = "/param") // 具体的模块
@SessionAttributes(value = "message") // 把 message=Hello 存入了sessionScope中
public class ParamController {

    @RequestMapping(path = "/hello")
    public String sayHello() {
        System.out.println("Hello SpringMVC");
        return "success";
    }

    @RequestMapping(path = "/testRequestMapping")
    public String testRequestMapping() {
        System.out.println("Test Request Mapping Annotation");
        return "success";
    }

    @RequestMapping(path = "/testParam")
    public String testParam(@RequestParam(name = "name") String username) {
        System.out.println("Test parameter");
        System.out.println("UserName: " + username);
        return "success";
    }

    /**
     * 请求参数绑定把数据封装到JavaBean的类中
     * @return
     */
    @RequestMapping(path = "/saveAccount")
    public String saveAccount(Account account) {
        System.out.println("Test parameter");
        System.out.println(account);
        return "success";
    }

    /**
     * 自定义类型转换器
     * @param user
     * @return
     */
    @RequestMapping(path = "/saveUser")
    public String saveUser(User user) {
        System.out.println("Test parameter");
        System.out.println(user);
        return "success";
    }

    @RequestMapping(path = "/testServletAPI")
    public String testServletAPI(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("Test Servlet API");

        System.out.println(request);
        HttpSession session = request.getSession();
        System.out.println(session);

        ServletContext servletContext = session.getServletContext();
        System.out.println(servletContext);

        System.out.println(response);

        return "success";
    }

    @RequestMapping(path = "/testRequestBody")
    public String testRequestBody(@RequestBody String body) {
        System.out.println("Test Request Body");
        System.out.println(body);

        return "success";
    }

    @RequestMapping(path = "/testPathVariable/{sid}")
    public String testPathVariable(@PathVariable(name = "sid") String id) {
        System.out.println("Test Path Variable");
        System.out.println(id);

        return "success";
    }

    @RequestMapping(path = "/testModeAttribute")
    public String testModeAttribute(User user) {
        System.out.println("Test Mode Attribute");
        System.out.println(user);
        return "success";
    }

    @ModelAttribute
    public User showUser(String name, Integer age) {
        System.out.println("showUser is called");
        User user = new User();
        user.setName(name);
        user.setAge(age);
        user.setBirthday(new Date());

        return user;
    }

    /**
     * 将Key-Value通过Model存入SessionAttribute中
     * @param model
     * @return
     */
    @RequestMapping(path = "/setSessionAttribute")
    public String setSessionAttribute(Model model) {
        System.out.println("Set Session Attribute");
        model.addAttribute("message", "Hello"); // 底层也会存储数据到requestScope中
        return "success";
    }

    /**
     * 从SessionAttribute中取出数据
     * @param modelMap
     * @return
     */
    @RequestMapping(path = "/getSessionAttribute")
    public String getSessionAttribute(ModelMap modelMap) {
        System.out.println("Get Session Attribute");
        System.out.println((String) modelMap.get("message"));
        return "success";
    }

    /**
     * 设置Session状态清楚数据
     * @param status
     * @return
     */
    @RequestMapping(path = "/delSessionAttribute")
    public String delSessionAttribute(SessionStatus status) {
        System.out.println("Delete Session Attribute");
        status.setComplete();
        return "success";
    }
}
