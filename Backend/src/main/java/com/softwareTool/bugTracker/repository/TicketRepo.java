package com.softwareTool.bugTracker.repository;

import com.softwareTool.bugTracker.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TicketRepo extends JpaRepository<Ticket, Long> {

    List<Ticket> findByProjectId(Long projectId);
}
