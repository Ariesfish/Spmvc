package xyz.ariesfish.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import xyz.ariesfish.domain.User;
import xyz.ariesfish.exception.SysException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.List;
import java.util.UUID;

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

    @RequestMapping(path = "/testAjax")
    public @ResponseBody User testAjax(@RequestBody User user) {
        System.out.println("------ testAjax ------");
        // 客户端发送的ajax请求, 传递的json字符串后端已经封装到user对象中
        System.out.println(user);

        // 响应, 模拟数据库查询
        user.setAge(40);
        return user;
    }

    @RequestMapping("/fileUpload")
    public String fileUpload(HttpServletRequest request) throws Exception {
        System.out.println("------ File Uploading ------");
        // 使用fileUpload组件上传文件
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        File dir = new File(path);
        // 创建文件夹
        if (!dir.exists()) {
            dir.mkdirs();
        }

        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        // 解析request
        List<FileItem> items = upload.parseRequest(request);
        for (FileItem item : items) {
            if (item.isFormField()) { // 普通表单项

            } else { // 上传文件项
                // 上传文件的名称
                String filename = item.getName();
                // 使文件名唯一
                String uuid = UUID.randomUUID().toString().replace("-", "");
                filename = uuid + "_" + filename;
                // 文件上传
                item.write(new File(path, filename));
                // 删除临时文件
                item.delete();
            }
        }
        return "success";
    }

    @RequestMapping("/mvcFileUpload")
    public String mvcFileUpload(HttpServletRequest request, MultipartFile upload) throws Exception {
        System.out.println("------ MVC File Uploading ------");
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        File dir = new File(path);
        // 创建文件夹
        if (!dir.exists()) {
            dir.mkdirs();
        }

        // 上传文件的名称
        String filename = upload.getOriginalFilename();
        // 使文件名唯一
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = uuid + "_" + filename;
        // 文件上传
        upload.transferTo(new File(path, filename));

        return "success";
    }

    @RequestMapping("/overFileUpload")
    public String overFileUpload(MultipartFile upload) throws Exception {
        System.out.println("------ Multi Server File Uploading ------");
        // 定义上传文件服务器的路径
        String path = "http://localhost:8090/uploads/";

        // 上传文件的名称
        String filename = upload.getOriginalFilename();
        // 使文件名唯一
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = uuid + "_" + filename;

        // 创建客户端对象
        Client client = Client.create();

        // 和文件服务器进行连接
        System.out.println(path+filename);
        WebResource webResource = client.resource(path+filename);

        // 调用PUT方法上传文件，需要将Tomcat的conf/web.xml servlet 设置 readonly 为 false
        webResource.put(upload.getBytes());

        return "success";
    }

    @RequestMapping(path = "/testException")
    public String testException() throws Exception {
        System.out.println("------ testException ------");
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SysException("查询用户出错");
        }
        return "success";
    }
}
