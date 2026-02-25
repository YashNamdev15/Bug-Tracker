package com.softwareTool.bugTracker.ServiceInterface;

import com.softwareTool.bugTracker.dto.ticket.TicketRequestDto;
import com.softwareTool.bugTracker.dto.ticket.TicketResponseDto;
import com.softwareTool.bugTracker.dto.ticketUpdate.UpdateStatusRequestDto;
import jakarta.validation.Valid;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TicketService {

    TicketResponseDto createTicket(Long projectId, TicketRequestDto ticketRequestDto);

    List<TicketResponseDto> getAllTicketsByProjectId(Long projectId);

    TicketResponseDto getTicketById(Long ticketId);

    TicketResponseDto updateStatusTicket(Long ticketId, @Valid UpdateStatusRequestDto statusRequestDto);

    TicketResponseDto addAssigneeToTicket(Long ticketId, Long userId);
}
