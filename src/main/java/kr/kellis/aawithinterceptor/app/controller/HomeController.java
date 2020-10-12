package kr.kellis.aawithinterceptor.app.controller;

import kr.kellis.aawithinterceptor.app.annotation.LoginRequired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/home")
    @LoginRequired
    public String home(){
        return "/home/home";
    }

    @GetMapping("/main")
    public String main(){
        return "/home/main";
    }
}
