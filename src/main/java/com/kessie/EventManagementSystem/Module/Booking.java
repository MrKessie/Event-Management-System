package com.kessie.EventManagementSystem.Module;

import com.kessie.EventManagementSystem.Enums.BookingStatus;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Booking {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private long bookingId;
    @ManyToOne
    @JoinColumn(nullable = false, name = "userId")
    private User user;
    @ManyToOne
    @JoinColumn(nullable = false, name = "eventId")
    private Event event;
    @Column(nullable = false)
    private int numberOfTickets;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BookingStatus bookingStatus;
    @Column(nullable = false)
    private double totalPrice;

//    @Column(nullable = false)
//    private int payment;
    @Column(updatable = false)
    private Date dateCreated;
    @Column(updatable = false)
    private Date dateUpdated;

    public Booking() {
    }

    public Booking(User user, Event event, int numberOfTickets, double totalPrice) {
        this.user = user;
        this.event = event;
        this.numberOfTickets = numberOfTickets;
        this.totalPrice = totalPrice;
    }

    public long getBookingId() {
        return bookingId;
    }

    public void setBookingId(long bookingId) {
        this.bookingId = bookingId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setNumberOfTickets(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(Date dateUpdated) {
        this.dateUpdated = dateUpdated;
    }
}
