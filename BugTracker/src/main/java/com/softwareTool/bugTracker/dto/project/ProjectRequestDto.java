package com.softwareTool.bugTracker.dto.project;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProjectRequestDto {

    @NotBlank(message = "Project name is required")
    private String name;

    private String description;

    private Set<Long> userIds;
}
