package com.softwareTool.bugTracker.repository;

import com.softwareTool.bugTracker.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProjectRepo extends JpaRepository<Project, Long> {
    List<Project> findByUsersId(Long id);
}
