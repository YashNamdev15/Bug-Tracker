package com.softwareTool.bugTracker.repository;

import com.softwareTool.bugTracker.dto.user.UserResponseDto;
import com.softwareTool.bugTracker.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    List<User> findByProjects_Id(Long id);

    User findByEmail(String email);
}
