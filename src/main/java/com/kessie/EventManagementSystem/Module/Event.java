package com.kessie.EventManagementSystem.Module;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
public class Event {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private long eventId;
    @Column(nullable = false)
    private String eventName;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String location;
    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    @Column(nullable = false)
    private Set<Ticket> tickets;
    @Column(nullable = false)
    private Date dateTime;
    @ManyToOne
    @JoinColumn(name = "organizerId", nullable = false)
    private User organizer;
    @ManyToOne
    @JoinColumn(name = "categoryId", nullable = false)
    //@Column(nullable = false)
    private Category category;
    @Column(nullable = false)
    private int capacity;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, updatable = false)
    private Date dateCreated;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, updatable = false)
    private Date dateUpdated;

    public Event() {
    }

    public Event(long eventId, String eventName, String description, String location, Date dateTime, User organizer, int capacity) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.description = description;
        this.location = location;
        this.dateTime = dateTime;
        this.organizer = organizer;
        this.capacity = capacity;
    }

    public long getEventId() {
        return eventId;
    }

    public void setEventId(long eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public User getOrganizer() {
        return organizer;
    }

    public void setOrganizer(User organizer) {
        this.organizer = organizer;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
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
