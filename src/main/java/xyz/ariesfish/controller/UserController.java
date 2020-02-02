package xyz.ariesfish.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import xyz.ariesfish.domain.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(path = "/user")
public class UserController {

    @RequestMapping(path = "/testString")
    public String testString(Model model) {
        System.out.println("------ testString ------");
        User user = new User();
        user.setName("Maurice");
        user.setPassword("suzhou");
        user.setAge(30);
        model.addAttribute(user.getName(), user);
        return "success";
    }

    @RequestMapping(path = "/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("------ testVoid ------");

        // 转发请求路径，请求转发是一次请求，不用编写项目名称
        // request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request, response);

        // 重定向, 不能直接定向到 /WEB-INF/pages/success.jsp
        // response.sendRedirect(request.getContextPath() + "/response.jsp");

        // 直接响应
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        return;
    }

    @RequestMapping(path = "/testModelAndView")
    public ModelAndView testModelAndView() {
        System.out.println("------ testModelAndView ------");
        User user = new User();
        user.setName("Maurice");
        user.setPassword("suzhou");
        user.setAge(30);

        ModelAndView mv = new ModelAndView();
        mv.addObject(user.getName(), user);
        mv.setViewName("success"); // 经过视图解析器处理，可以跳转 WEB-INF
        return mv;
    }

    @RequestMapping(path = "/testForward")
    public String testForward() {
        System.out.println("------ testForward ------");
        return "forward:/WEB-INF/pages/success.jsp";
    }

    @RequestMapping(path = "/testRedirect")
    public String testRedirect() {
        System.out.println("------ testRedirect ------");
        return "redirect:/response.jsp"; // 不用额外加入项目名称 request.getContextPath()
    }
}
