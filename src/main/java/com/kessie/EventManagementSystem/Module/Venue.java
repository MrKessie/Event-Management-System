package com.kessie.EventManagementSystem.Module;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Venue {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Long venueId;
    @Column(nullable = false)
    private String venueName;
    @Column(nullable = false)
    private String venueAddress;
    @Column(nullable = false)
    private String venueCapacity;
    @ElementCollection
    @CollectionTable(name = "venue_facilities", joinColumns = @JoinColumn(name = "venue_id"))
    private Set<String> venueFacilities;
//    @OneToMany(mappedBy = "venue", cascade = CascadeType.ALL)
//    private Set<Event> venueEvents;

    public Venue() {
    }

    public Venue(String venueName, String venueAddress, String venueCapacity, Set<String> venueFacilities) {
        this.venueName = venueName;
        this.venueAddress = venueAddress;
        this.venueCapacity = venueCapacity;
        this.venueFacilities = venueFacilities;
    }

    public Long getVenueId() {
        return venueId;
    }

    public void setVenueId(Long venueId) {
        this.venueId = venueId;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public String getVenueAddress() {
        return venueAddress;
    }

    public void setVenueAddress(String venueAddress) {
        this.venueAddress = venueAddress;
    }

    public String getVenueCapacity() {
        return venueCapacity;
    }

    public void setVenueCapacity(String venueCapacity) {
        this.venueCapacity = venueCapacity;
    }

    public Set<String> getVenueFacilities() {
        return venueFacilities;
    }

    public void setVenueFacilities(Set<String> venueFacilities) {
        this.venueFacilities = venueFacilities;
    }

//    public Set<Event> getVenueEvents() {
//        return venueEvents;
//    }

//    public void setVenueEvents(Set<Event> venueEvents) {
//        this.venueEvents = venueEvents;
//    }
}
