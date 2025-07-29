package com.hashirama.AshBackend.AshController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
	@GetMapping("/login")
    public String showLoginPage() {
        return "index"; 
    }

    @GetMapping("/register")
    public String showRegisterPage() {
        return "createaccount"; 
    }
    @GetMapping("/home")
    public String showHomePage() {
    	return "Homepage";
    }
}
