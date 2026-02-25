package com.softwareTool.bugTracker.dto.ticket;


import com.softwareTool.bugTracker.entity.Project;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TicketResponseDto {

    private Long id;

    private String title;

    private String description;

    private String status;

    private String priority;

    private LocalDateTime createdAt;

    private Project project;
}
