package kr.kellis.aawithinterceptor.config;

import kr.kellis.aawithinterceptor.app.exception.AuthenticationException;
import kr.kellis.aawithinterceptor.app.exception.AuthorizationException;
import kr.kellis.aawithinterceptor.app.exception.InvalidAccountException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler({AuthenticationException.class, InvalidAccountException.class})
    public ModelAndView authException(Exception e){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login/login");
        mv.addObject(e.getClass() == InvalidAccountException.class ? "errorMsg": "orgRequestUrl", e.getMessage());

        return mv;
    }

    @ExceptionHandler({AuthorizationException.class})
    public String authorizationException(Exception e){
        return "error/access_error";
    }
}
