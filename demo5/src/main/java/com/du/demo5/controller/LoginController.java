package com.du.demo5.controller;

import com.du.demo5.service.AuthService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private final AuthService authService;

    public LoginController(AuthService authService) {
        this.authService = authService;
    }

    /**
     * 로그인 페이지 이동
     */
    @GetMapping({"/", "/login"})
    public String loginPage() {
        return "login"; // templates/login.html
    }

    /**
     * 로그인 처리
     */
    @PostMapping("/login")
    public String login(
            @RequestParam String sellComId,
            @RequestParam String sellComPw
    ) {
        boolean success = authService.login(sellComId, sellComPw);

        if (success) {
            return "redirect:/main"; // 로그인 성공
        } else {
            return "redirect:/login?error";
        }
    }

    /**
     * 로그아웃
     */
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}

