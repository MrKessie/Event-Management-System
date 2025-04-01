package com.kessie.EventManagementSystem.Module;

import com.kessie.EventManagementSystem.Enums.Role;
import com.kessie.EventManagementSystem.Enums.TicketType;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Ticket {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private long ticketId;
    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "ticketType", joinColumns = @JoinColumn(name = "ticketId"))
    @Column(nullable = false)
    private Set<TicketType> ticketType;
    @Column(nullable = false)
    private double price;
    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;
    @Column(nullable = false)
    private int availability;

    public Ticket() {
    }

    public Ticket(Set<TicketType> ticketType, double price, Event event, int availability) {
        this.ticketType = ticketType;
        this.price = price;
        this.event = event;
        this.availability = availability;
    }

    public long getTicketId() {
        return ticketId;
    }

    public void setTicketId(long ticketId) {
        this.ticketId = ticketId;
    }

    public Set<TicketType> getTicketType() {
        return ticketType;
    }

    public void setTicketType(Set<TicketType> ticketType) {
        this.ticketType = ticketType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }
}
