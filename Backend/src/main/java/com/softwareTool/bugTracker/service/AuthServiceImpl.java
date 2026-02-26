package com.softwareTool.bugTracker.service;

import com.softwareTool.bugTracker.ServiceInterface.AuthService;
import com.softwareTool.bugTracker.dto.user.UserLoginRequest;
import com.softwareTool.bugTracker.dto.user.UserResponseDto;
import com.softwareTool.bugTracker.entity.User;
import com.softwareTool.bugTracker.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserResponseDto login(UserLoginRequest request) {
        // Implement login logic here

        User byEmail = userRepo.findByEmail(request.getEmail());

        if (byEmail == null || !byEmail.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("Invalid email or password");
        }
        return UserResponseDto.builder()
                .id(byEmail.getId())
                .name(byEmail.getName())
                .email(byEmail.getEmail())
                .password(byEmail.getPassword())
                .build();
    }
}
