package com.softwareTool.bugTracker.controller;

import com.softwareTool.bugTracker.ServiceInterface.AuthService;
import com.softwareTool.bugTracker.dto.user.UserLoginRequest;
import com.softwareTool.bugTracker.dto.user.UserResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserLoginRequest request) {
        UserResponseDto user = authService.login(request);
        return ResponseEntity.ok(user);
    }
}
