package com.softwareTool.bugTracker.service;

import com.softwareTool.bugTracker.ServiceInterface.TicketService;
import com.softwareTool.bugTracker.dto.ticket.TicketRequestDto;
import com.softwareTool.bugTracker.dto.ticket.TicketResponseDto;
import com.softwareTool.bugTracker.dto.ticketUpdate.UpdateStatusRequestDto;
import com.softwareTool.bugTracker.entity.*;
import com.softwareTool.bugTracker.exception.ResourceNotFoundException;
import com.softwareTool.bugTracker.exception.UserNotBelongToProject;
import com.softwareTool.bugTracker.repository.ProjectRepo;
import com.softwareTool.bugTracker.repository.TicketRepo;
import com.softwareTool.bugTracker.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepo ticketRepo;

    @Autowired
    private ProjectRepo projectRepo;

    @Autowired
    private UserRepo userRepo;

    @Override
    public TicketResponseDto createTicket(Long projectId, TicketRequestDto dto) {

        Project project = projectRepo.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Project not found with id: " + projectId));

        Ticket ticket = Ticket.builder()
                .title(dto.getTitle())
                .description(dto.getDescription())
                .priority(Priority.valueOf(dto.getPriority()))
                .status(Status.valueOf(dto.getStatus()))
                .createdAt(LocalDateTime.now())
                .dueDate(dto.getDueDate())
                .project(project)
                .build();

        Ticket savedTicket = ticketRepo.save(ticket);

        return mapToDto(savedTicket);
    }

    @Override
    public List<TicketResponseDto> getAllTicketsByProjectId(Long projectId) {

        List<Ticket> allTickets = ticketRepo.findByProjectId(projectId);

        List<TicketResponseDto> ticketResponseDtos = allTickets.stream()
                .map(this::mapToDto)
                .toList();

        return ticketResponseDtos;
    }

    @Override
    public TicketResponseDto getTicketById(Long ticketId) {

        Ticket ticket = ticketRepo.findById(ticketId)
                .orElseThrow(() -> new RuntimeException("Ticket not found with id: " + ticketId));

        return mapToDto(ticket);
    }


    @Override
    @Transactional
    public TicketResponseDto updateStatusTicket(Long ticketId, UpdateStatusRequestDto statusRequestDto) {

        Ticket ticket = ticketRepo.findById(ticketId)
                .orElseThrow(() -> new RuntimeException("Ticket not found with id: " + ticketId));

        String statusStr = statusRequestDto.getStatus();
        try {
            Status newStatus = Status.valueOf(statusStr.toUpperCase());
            ticket.setStatus(newStatus);
        } catch (IllegalArgumentException | NullPointerException ex) {
            throw new RuntimeException("Invalid status: " + statusStr);
        }

        // explicit save is optional when inside @Transactional, but clearer
        Ticket saved = ticketRepo.save(ticket);
        return mapToDto(saved);
    }

    @Override
    @Transactional
    public TicketResponseDto addAssigneeToTicket(Long ticketId, Long userId) {

        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));

        Ticket ticket = ticketRepo.findById(ticketId)
                .orElseThrow(() -> new RuntimeException("Ticket not found with id: " + ticketId));

        if(!ticket.getProject().getUsers().contains(user)){
            throw new UserNotBelongToProject("User not in project");
        }
        ticket.setAssignedUser(user);

        // ⭐ auto status change
        if (ticket.getStatus() == Status.OPEN) {
            ticket.setStatus(Status.IN_PROGRESS);
        }

        Ticket saved = ticketRepo.save(ticket);
        return mapToDto(saved);
    }

    public TicketResponseDto mapToDto(Ticket ticket) {
        return TicketResponseDto.builder()
                .id(ticket.getId())
                .title(ticket.getTitle())
                .description(ticket.getDescription())
                .priority(ticket.getPriority().name())
                .status(ticket.getStatus().name())
                .createdAt(ticket.getCreatedAt())
                .project(ticket.getProject())
                .dueDate(ticket.getDueDate())
                .assignedUser(ticket.getAssignedUser())
                .build();
    }
}
