package kr.kellis.aawithinterceptor.app.controller;

import kr.kellis.aawithinterceptor.app.dto.User;
import kr.kellis.aawithinterceptor.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    public static final String LOGGED_USER = "LOGGED_USER";

    @Autowired
    private HttpSession session;

    @Autowired
    private UserService userService;

    @GetMapping("login")
    public String loginPage(){
        return "/home/home";
    }

    @PostMapping("login")
    public String login(User user, @RequestParam String orgRequestUrl){
        User loginUser = userService.getUser(user);
        session.setAttribute(LOGGED_USER, loginUser);
        return "redirect:"+(orgRequestUrl == null ? "home" : orgRequestUrl);
    }

    @PostMapping("logout")
    public String logout(){
        session.invalidate();
        return "redirect:main";
    }
}
