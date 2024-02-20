package com.example.StudentManagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class LoginController {
    @GetMapping("/showLoginPage")
    public String showLoginPage(){
        return "logins/logins";
    }

    @GetMapping("/showPage403")
    public String showPage403(){
        return "error/403";
    }

}
