package com.kessie.EventManagementSystem.Service;

import com.kessie.EventManagementSystem.Model.Ticket;
import com.kessie.EventManagementSystem.Repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService {
    @Autowired
    TicketRepository ticketRepository;

//    public Ticket createTicket() {
//
//    }

}
