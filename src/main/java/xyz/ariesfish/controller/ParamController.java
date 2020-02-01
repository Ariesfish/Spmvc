package xyz.ariesfish.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import xyz.ariesfish.domain.Account;

@Controller
@RequestMapping(path = "/param") // 具体的模块
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
    public String testParam(String username) {
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
}
