package com.app.employee.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootContoller {
	@GetMapping("/")
    public String home() {
        return "Service is running!";
    }
}
