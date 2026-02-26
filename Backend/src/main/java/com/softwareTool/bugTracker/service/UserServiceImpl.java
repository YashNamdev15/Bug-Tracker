package com.softwareTool.bugTracker.service;

import com.softwareTool.bugTracker.ServiceInterface.UserService;
import com.softwareTool.bugTracker.dto.user.UserRequestDto;
import com.softwareTool.bugTracker.dto.user.UserResponseDto;
import com.softwareTool.bugTracker.entity.User;
import com.softwareTool.bugTracker.exception.InvalidArgsException;
import com.softwareTool.bugTracker.exception.ResourceNotFoundException;
import com.softwareTool.bugTracker.repository.UserRepo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepository;

    @Override
    public UserResponseDto createUser(@Valid UserRequestDto userRequest) {
        User user = User.builder()
                        .name(userRequest.getName())
                        .email(userRequest.getEmail())
                        .password(userRequest.getPassword())
                        .build();
        User savedUser = userRepository.save(user);

        if(savedUser == null) {
            throw new InvalidArgsException("Failed to create user");
        }
        else{
            UserResponseDto userResponse = UserResponseDto.builder()
                    .id(savedUser.getId())
                    .name(savedUser.getName())
                    .email(savedUser.getEmail())
                    .password(savedUser.getPassword())
                    .build();
            return userResponse;
        }
    }

    @Override
    public UserResponseDto getUserById(Long id) {
            User user = userRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));

        UserResponseDto userResponse = UserResponseDto.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
        return userResponse;
    }

    @Override
    public UserResponseDto updateUser(Long id, UserRequestDto userRequest) {

            User existingUser = userRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));

            existingUser.setName(userRequest.getName());
            existingUser.setEmail(userRequest.getEmail());
            existingUser.setPassword(userRequest.getPassword());

            User updatedUser = userRepository.save(existingUser);

                UserResponseDto userResponse = UserResponseDto.builder()
                        .id(updatedUser.getId())
                        .name(updatedUser.getName())
                        .email(updatedUser.getEmail())
                        .password(updatedUser.getPassword())
                        .build();

        return userResponse;
    }

    @Override
    public List<UserResponseDto> getUserByProjectId(Long id) {
        List<UserResponseDto> users = userRepository.findByProjects_Id(id)
                .stream()
                .map(user -> UserResponseDto.builder()
                        .id(user.getId())
                        .name(user.getName())
                        .email(user.getEmail())
                        .password(user.getPassword())
                        .build())
                .toList();

        return users;
    }


}
