package com.softwareTool.bugTracker.repository;

import com.softwareTool.bugTracker.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
