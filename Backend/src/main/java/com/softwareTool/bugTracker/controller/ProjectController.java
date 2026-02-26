package com.softwareTool.bugTracker.controller;


import com.softwareTool.bugTracker.ServiceInterface.ProjectService;
import com.softwareTool.bugTracker.dto.memberUpdate.MemberUpdateDto;
import com.softwareTool.bugTracker.dto.project.ProjectRequestDto;
import com.softwareTool.bugTracker.dto.project.ProjectResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping
    public ResponseEntity<?> createProject(@RequestBody
                                               ProjectRequestDto projectRequestDto) {

        ProjectResponseDto projectResponse = projectService.createProject(projectRequestDto);
        return ResponseEntity.ok(projectResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProjectById(@PathVariable Long id) {

        ProjectResponseDto projectResponse = projectService.getProjectById(id);
        return ResponseEntity.ok(projectResponse);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> getProjectByUserId(@PathVariable Long id) {

        List<ProjectResponseDto> projectList = projectService.getProjectByUserId(id);
        return ResponseEntity.ok(projectList);
    }

    @PutMapping("/{id}/add-member")
    public ResponseEntity<?> addMembers(@PathVariable Long id,
                                        @RequestBody MemberUpdateDto memberUpdateDto) {

        ProjectResponseDto projectResponse = projectService.addMembers(id, memberUpdateDto);
        return ResponseEntity.ok(projectResponse);
    }

    @PutMapping("/{id}/remove-member")
    public ResponseEntity<?> removeMembers(@PathVariable Long id,
                                           @RequestBody MemberUpdateDto memberUpdateDto) {

        ProjectResponseDto projectResponse = projectService.removeMembers(id, memberUpdateDto);
        return ResponseEntity.ok(projectResponse);
    }

    @GetMapping
    public ResponseEntity<?> getAllProject() {

        List<ProjectResponseDto> allProjects = projectService.getAllProject();
        return ResponseEntity.ok(allProjects);
    }
}
