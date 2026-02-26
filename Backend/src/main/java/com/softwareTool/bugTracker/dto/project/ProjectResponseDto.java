package com.softwareTool.bugTracker.dto.project;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProjectResponseDto {

    private Long id;

    private String name;

    private String description;

    private Set<Long> userIds;

    private int ticketCount;

}
