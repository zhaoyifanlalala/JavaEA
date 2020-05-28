package club.banyuan.blog.interceptor;

import club.banyuan.blog.bean.User;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //check user 状态

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("CURRENT_USER");
        if (user == null){
            //用户未登录
            //将当前uri放到session后重定向
            session.setAttribute("next", request.getRequestURI());
            response.sendRedirect("/login");
            return false;
        }
        return true;
    }
}
