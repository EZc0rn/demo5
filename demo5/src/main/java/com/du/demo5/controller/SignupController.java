package com.du.demo5.controller;

import com.du.demo5.service.SignupService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignupController {

    private final SignupService signupService;

    public SignupController(SignupService signupService) {
        this.signupService = signupService;
    }
    @GetMapping("/signup")
    public String signupPage() {
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(
            String sellComName,
            String sellRegNum,
            String sellRepName,
            String sellComAdr,
            String sellComId,
            String sellComPw,
            String sellComNum,
            String sellComEmail,
            String sellBmName,
            String sellBmNum,
            String sellBmDep,
            Model model   // ✅ 반드시 필요
    ) {

        try {
            signupService.signup(
                    sellComName,
                    sellRegNum,
                    sellRepName,
                    sellComAdr,
                    sellComId,
                    sellComPw,
                    sellComNum,
                    sellComEmail,
                    sellBmName,
                    sellBmNum,
                    sellBmDep
            );
            return "redirect:/login";

        } catch (IllegalStateException e) {
            model.addAttribute("error", e.getMessage()); // ✅ 여기
            return "signup";
        }
    }
}
