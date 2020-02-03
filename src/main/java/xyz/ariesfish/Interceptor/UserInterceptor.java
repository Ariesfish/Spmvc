package xyz.ariesfish.Interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserInterceptor implements HandlerInterceptor {
    /**
     * 预处理，Controller方法执行前
     * @param request
     * @param response
     * @param handler
     * @return true，放行，执行下一个拦截器，如果没有则执行Controller中的方法
     *         false, 不放行
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("UserInterceptor preHandle executed");
        return true;

        // request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request, response);
        // return false;
    }

    /**
     * 后处理，Controller方法执行后，success.jsp页面显示前
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("UserInterceptor postHandle executed");
        // request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request, response);
    }

    /**
     * success.jsp页面显示后执行
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("UserInterceptor afterCompletion executed");
    }
}
