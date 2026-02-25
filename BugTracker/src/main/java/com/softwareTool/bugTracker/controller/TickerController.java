package com.softwareTool.bugTracker.controller;


import com.softwareTool.bugTracker.ServiceInterface.TicketService;
import com.softwareTool.bugTracker.dto.ticket.TicketRequestDto;
import com.softwareTool.bugTracker.dto.ticket.TicketResponseDto;
import com.softwareTool.bugTracker.dto.ticketUpdate.UpdateStatusRequestDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class TickerController {

    @Autowired
    private TicketService ticketService;


    @PostMapping("/project/{projectId}")
    public ResponseEntity<?> createTicket(@PathVariable Long projectId,
                                          @Valid @RequestBody TicketRequestDto ticketRequestDto){

        TicketResponseDto savedTicket = ticketService.createTicket(projectId, ticketRequestDto);

        return new ResponseEntity<>(savedTicket, HttpStatus.CREATED);
    }

    @GetMapping("/project/{projectId}")
    public ResponseEntity<?> getAllTickets(@PathVariable Long projectId){

        List<TicketResponseDto> ticketResponseDtos = ticketService.getAllTicketsByProjectId(projectId);
        return new ResponseEntity<>(ticketResponseDtos, HttpStatus.OK);
    }

    @GetMapping("/{ticketId}")
    public ResponseEntity<?> getTicketById(@PathVariable Long ticketId) {

        TicketResponseDto ticketResponseDto = ticketService.getTicketById(ticketId);
        return new ResponseEntity<>(ticketResponseDto, HttpStatus.OK);
    }

    @PutMapping("/status/{ticketId}")
    public ResponseEntity<?> updateTicketStatus(@PathVariable Long ticketId,
                                          @Valid @RequestBody UpdateStatusRequestDto ticketRequestDto) {

        TicketResponseDto updatedTicket = ticketService.updateStatusTicket(ticketId, ticketRequestDto);
        return new ResponseEntity<>(updatedTicket, HttpStatus.OK);
    }

    @PutMapping("/{TicketId}/assign/{userId}")
    public ResponseEntity<?> addAssigneeToTicket(@PathVariable Long ticketId, @PathVariable Long userId) {

        ticketService.addAssigneeToTicket(ticketId, userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
