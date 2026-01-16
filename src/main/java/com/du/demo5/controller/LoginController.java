package com.du.demo5.controller;

import com.du.demo5.service.AuthService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private final AuthService authService;

    public LoginController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/")
    public String root() {
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(
            @RequestParam String id,
            @RequestParam String pw,
            HttpSession session
    ) {
        if (authService.login(id, pw)) {
            session.setAttribute("USER_ID", id); // ASP Session("USER_ID")
            return "redirect:/main";
        }

        return "redirect:/login?error";
    }

    @GetMapping("/main")
    public String main(HttpSession session) {
        if (session.getAttribute("USER_ID") == null) {
            return "redirect:/login";
        }
        return "main";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
