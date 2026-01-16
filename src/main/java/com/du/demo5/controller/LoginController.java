package com.du.demo5.controller;

import com.du.demo5.service.AuthService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private final AuthService authService;

    public LoginController(AuthService authService) {
        this.authService = authService;
    }

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
}
