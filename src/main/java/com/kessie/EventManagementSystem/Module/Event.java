package com.kessie.EventManagementSystem.Module;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

@Entity
public class Event {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private int eventId;
    @Column(nullable = false)
    private String eventName;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String location;
//    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
//    @Column(nullable = false)
//    private Set<Ticket> tickets;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private String eventDate;
    @ManyToOne
    @JoinColumn(name = "organizerId", nullable = false)
    private User organizer;
    @Column(nullable = false)
    private int capacity;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, updatable = false)
    private LocalDateTime dateCreated;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, updatable = false)
    private LocalDateTime dateUpdated;

    public Event() {
    }

    public Event(int eventId, String eventName, String description, String location, String eventDate, User organizer, int capacity) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.description = description;
        this.location = location;
        this.eventDate = eventDate;
        this.organizer = organizer;
        this.capacity = capacity;
    }

    public long getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
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


    public String getEventDateTime() {
        return eventDate;
    }

    public void setEventDateTime(String dateTime) {
        this.eventDate = dateTime;
    }

    public User getOrganizer() {
        return organizer;
    }

    public void setOrganizer(User organizer) {
        this.organizer = organizer;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public LocalDateTime getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(LocalDateTime dateUpdated) {
        this.dateUpdated = dateUpdated;
    }
}
