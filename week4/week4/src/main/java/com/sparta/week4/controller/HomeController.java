package com.sparta.week4.controller;

import com.sparta.week4.security.UserDetailsImpl;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/user/register")
    public String registerPage() {
        return "register";
    }

    @GetMapping("/user/loginView")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/")
    public String home(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        try {
            model.addAttribute("username", userDetails.getNickname());
            return "index";
        }catch (Exception e) {
            return "index";
        }
    }
}

