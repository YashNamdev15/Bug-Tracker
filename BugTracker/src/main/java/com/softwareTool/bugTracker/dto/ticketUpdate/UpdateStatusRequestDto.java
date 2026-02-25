package com.softwareTool.bugTracker.dto.ticketUpdate;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateStatusRequestDto {

    String status;
}
