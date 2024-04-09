package com.kessie.EventManagementSystem.Module;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
public class Category {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Long categoryId;
    @Column(nullable = false)
    private String categoryName;
    @Column(nullable = false)
    private String description;
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private Set<Event> events;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date dateCreated;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date dateUpdated;

    public Category() {
    }

    public Category(String categoryName, String description) {
        this.categoryName = categoryName;
        this.description = description;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Event> getEvents() {
        return events;
    }

    public void setEvents(Set<Event> events) {
        this.events = events;
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
