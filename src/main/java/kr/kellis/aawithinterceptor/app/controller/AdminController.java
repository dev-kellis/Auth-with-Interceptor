package kr.kellis.aawithinterceptor.app.controller;

import kr.kellis.aawithinterceptor.app.annotation.AdminOnly;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
    @GetMapping("/admin/home")
    @AdminOnly
    public String adminHome(){
        return "admin/home";
    }
}
