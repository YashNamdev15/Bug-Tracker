package com.softwareTool.bugTracker.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HealthChecker {

    @GetMapping("/health")
    public String checkHealth() {
        return "Application is running!";
    }
}
