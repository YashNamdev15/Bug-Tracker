package com.softwareTool.bugTracker.ServiceInterface;

import com.softwareTool.bugTracker.dto.user.UserRequestDto;
import com.softwareTool.bugTracker.dto.user.UserResponseDto;
import jakarta.validation.Valid;
import org.springframework.stereotype.Component;


@Component
public interface UserService {

    UserResponseDto createUser(@Valid UserRequestDto userRequest);

    UserResponseDto getUserById(Long id);

    UserResponseDto updateUser(Long id, @Valid UserRequestDto userRequest);
}
