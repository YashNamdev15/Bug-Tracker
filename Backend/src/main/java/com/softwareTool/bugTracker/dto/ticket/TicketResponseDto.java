package com.softwareTool.bugTracker.dto.ticket;


import com.softwareTool.bugTracker.entity.Project;
import com.softwareTool.bugTracker.entity.User;
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

    private LocalDateTime dueDate;

    private String status;

    private String priority;

    private LocalDateTime createdAt;

    private User assignedUser;

    private Project project;
}
