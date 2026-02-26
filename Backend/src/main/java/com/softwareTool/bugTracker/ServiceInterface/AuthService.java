package com.softwareTool.bugTracker.ServiceInterface;

import com.softwareTool.bugTracker.dto.user.UserLoginRequest;
import com.softwareTool.bugTracker.dto.user.UserResponseDto;
import org.springframework.stereotype.Component;

@Component
public interface AuthService {

        UserResponseDto login(UserLoginRequest request);
}
