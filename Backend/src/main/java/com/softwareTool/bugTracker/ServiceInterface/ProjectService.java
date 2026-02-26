package com.softwareTool.bugTracker.ServiceInterface;

import com.softwareTool.bugTracker.dto.memberUpdate.MemberUpdateDto;
import com.softwareTool.bugTracker.dto.project.ProjectRequestDto;
import com.softwareTool.bugTracker.dto.project.ProjectResponseDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProjectService {

    ProjectResponseDto createProject(ProjectRequestDto projectRequestDto);

    List<ProjectResponseDto> getProjectByUserId(Long id);

    ProjectResponseDto addMembers(Long id, MemberUpdateDto memberUpdateDto);

    ProjectResponseDto removeMembers(Long id, MemberUpdateDto memberUpdateDto);

    List<ProjectResponseDto> getAllProject();

    ProjectResponseDto getProjectById(Long id);
}
