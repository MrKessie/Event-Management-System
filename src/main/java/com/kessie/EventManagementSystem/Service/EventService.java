package com.kessie.EventManagementSystem.Service;

import com.kessie.EventManagementSystem.Enums.EventType;
import com.kessie.EventManagementSystem.Enums.LifeCycle;
import com.kessie.EventManagementSystem.Model.Event;
import com.kessie.EventManagementSystem.Model.User;
import com.kessie.EventManagementSystem.Repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Random;

@Service
public class EventService {
    @Autowired
    EventRepository eventRepository;

    public Event createEvent(String eventName, String description, EventType eventType, LifeCycle lifeCycle, String location,
                             int capacity, LocalDate eventDate, LocalTime eventTime, User organizer){
        Long eventId = randomNumbers();
        Event event = new Event();
        event.setEventId(eventId);
        event.setEventName(eventName);
        event.setDescription(description);
        event.setEventType(eventType);
        event.setLifeCycle(lifeCycle);
        event.setLocation(location);
        event.setEventDate(eventDate);
        event.setEventTime(eventTime);
        event.setOrganizer(organizer);
        event.setCapacity(capacity);
        event.setDateCreated(LocalDateTime.now());
        event.setDateUpdated(LocalDateTime.now());

        eventRepository.save(event);
        return event;
    }

    public List<Event> allEvents(){
        List<Event> events = (List<Event>) eventRepository.findAll();
        return events;
    }

    public Event removeEvent(int eventId){
        Event event = eventRepository.findById(eventId);
        eventRepository.delete(event);
        return event;
    }

    public boolean existsByEventId(Long eventId) {
        return eventRepository.existsByEventId(eventId);
    }

    public boolean deleteEvent(Long eventId) {
        if (eventRepository.existsByEventId(eventId)) {
            eventRepository.deleteById(eventId);
            return true;
        }
        return false;
    }

    public Long randomNumbers(){
        Random random = new Random();
        int max = 99999;
        int min = 10000;
        return random.nextLong(max - min + 1) + min;
    }
}
