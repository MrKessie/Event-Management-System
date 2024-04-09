package com.kessie.EventManagementSystem.Module;

import jakarta.persistence.*;

@Entity
public class Ticket {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private long ticketId;
    @Column(nullable = false)
    private String ticketType;
    @Column(nullable = false)
    private double price;
    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;
    @Column(nullable = false)
    private int availability;

    public Ticket() {
    }

    public Ticket(String ticketType, double price, Event event, int availability) {
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

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
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
