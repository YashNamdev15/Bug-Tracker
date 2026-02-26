package com.softwareTool.bugTracker.controller;


import com.softwareTool.bugTracker.ServiceInterface.UserService;
import com.softwareTool.bugTracker.dto.user.UserRequestDto;
import com.softwareTool.bugTracker.dto.user.UserResponseDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@Valid
                                        @RequestBody
                                        UserRequestDto userRequest) {

        UserResponseDto user = userService.createUser(userRequest);
        return ResponseEntity.ok(user);

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable
                                             Long id) {

        UserResponseDto user = userService.getUserById(id);
        return ResponseEntity.ok(user);

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id,
                                        @Valid
                                        @RequestBody UserRequestDto userRequest) {

        UserResponseDto user = userService.updateUser(id, userRequest);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/project/{projectId}")
    public ResponseEntity<?> getUserByProjectId(@PathVariable Long projectId) {

        List<UserResponseDto> users = userService.getUserByProjectId(projectId);
        return ResponseEntity.ok(users);
    }

}
