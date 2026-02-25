package com.softwareTool.bugTracker.dto.ticket;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TicketRequestDto {

    @NotBlank
    private String title;

    private String description;

    private String status;

    private String priority;
}
