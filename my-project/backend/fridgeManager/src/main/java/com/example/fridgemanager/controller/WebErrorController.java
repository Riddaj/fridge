package com.example.fridgemanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebErrorController {
	
    @GetMapping({"/","/error"})
    public String redirctRoot() {
        return "index.html";
    }

    public String getErrorPath() {
        return "/error";
    }

}
