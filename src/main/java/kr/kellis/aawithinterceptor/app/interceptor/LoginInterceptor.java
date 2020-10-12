package kr.kellis.aawithinterceptor.app.interceptor;

import kr.kellis.aawithinterceptor.app.annotation.AdminOnly;
import kr.kellis.aawithinterceptor.app.annotation.LoginRequired;
import kr.kellis.aawithinterceptor.app.controller.LoginController;
import kr.kellis.aawithinterceptor.app.dto.User;
import kr.kellis.aawithinterceptor.app.exception.AuthenticationException;
import kr.kellis.aawithinterceptor.app.exception.AuthorizationException;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Configuration
public class LoginInterceptor extends HandlerInterceptorAdapter {
    private static final String ADMIN = "ADMIN";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(handler instanceof HandlerMethod){
            HandlerMethod hm = (HandlerMethod)handler;
            User sessionUser = (User)request.getSession().getAttribute(LoginController.LOGGED_USER);
            if(hm.hasMethodAnnotation(LoginRequired.class) && sessionUser == null){
                throw new AuthenticationException(request.getRequestURI());
            }
            if(hm.hasMethodAnnotation(AdminOnly.class) && !ADMIN.equals(sessionUser.getAuthority())){
                throw new AuthorizationException();
            }
        }
        return super.preHandle(request, response, handler);
    }
}
