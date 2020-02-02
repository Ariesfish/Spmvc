package xyz.ariesfish.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SysExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        // 获取异常对象
        SysException se = null;
        if (e instanceof SysException) {
            se = (SysException) e;
        } else {
            se = new SysException("系统维护中...");
        }

        // 创建ModelAndView
        ModelAndView mv = new ModelAndView();
        mv.addObject("errorMessage", se.getMessage());
        mv.setViewName("error");
        return mv;
    }
}
