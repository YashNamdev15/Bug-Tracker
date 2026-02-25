package com.softwareTool.bugTracker.service;

import com.softwareTool.bugTracker.ServiceInterface.ProjectService;
import com.softwareTool.bugTracker.dto.memberUpdate.MemberUpdateDto;
import com.softwareTool.bugTracker.dto.project.ProjectRequestDto;
import com.softwareTool.bugTracker.dto.project.ProjectResponseDto;
import com.softwareTool.bugTracker.entity.Project;
import com.softwareTool.bugTracker.entity.User;
import com.softwareTool.bugTracker.exception.ResourceNotFoundException;
import com.softwareTool.bugTracker.repository.ProjectRepo;
import com.softwareTool.bugTracker.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepo projectRepo;

    @Autowired
    private UserRepo userRepo;

    @Override
    public ProjectResponseDto createProject(ProjectRequestDto dto) {

        var users = userRepo.findAllById(dto.getUserIds());

        Project project = Project.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .users(new HashSet<>(users)) // OWNER SIDE SET
                .build();

        Project savedProject = projectRepo.save(project);

        return mapToDto(savedProject);
    }

    @Override
    public List<ProjectResponseDto> getProjectByUserId(Long id) {

        List<ProjectResponseDto> projectList = projectRepo.findByUsersId(id)
                .stream()
                .map(project -> ProjectResponseDto.builder()
                        .id(project.getId())
                        .name(project.getName())
                        .description(project.getDescription())
                        .userIds(project.getUsers().stream().map(user -> user.getId()).collect(Collectors.toSet()))
                        .build()).toList();
        return projectList;
    }

    @Override
    public ProjectResponseDto addMembers(Long id, MemberUpdateDto memberUpdateDto) {

        Project project = projectRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Project not found with id: " + id));

        var users = userRepo.findAllById(memberUpdateDto.getUserIds());
        project.getUsers().addAll(users);

        Project updatedProject = projectRepo.save(project);

        return mapToDto(updatedProject);
    }

    @Override
    public ProjectResponseDto removeMembers(Long id, MemberUpdateDto memberUpdateDto) {

        Project project = projectRepo.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Project not found with id: " + id));

        var users = userRepo.findAllById(memberUpdateDto.getUserIds());
        project.getUsers().removeAll(users);

        Project updatedProject = projectRepo.save(project);

        return mapToDto(updatedProject);
    }

    @Override
    public List<ProjectResponseDto> getAllProject() {

        List<ProjectResponseDto> allProjects = projectRepo.findAll()
                .stream()
                .map(project -> ProjectResponseDto.builder()
                        .id(project.getId())
                        .name(project.getName())
                        .description(project.getDescription())
                        .userIds(project.getUsers().stream().map(user -> user.getId()).collect(Collectors.toSet()))
                        .build()).toList();

        return allProjects;
    }

    private static ProjectResponseDto mapToDto(Project project) {

        return ProjectResponseDto.builder()
                .id(project.getId())
                .name(project.getName())
                .description(project.getDescription())
                .userIds(
                        project.getUsers()
                                .stream()
                                .map(User::getId)
                                .collect(java.util.stream.Collectors.toSet())
                )
                .build();
    }
}
