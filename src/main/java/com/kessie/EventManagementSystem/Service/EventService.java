package com.kessie.EventManagementSystem.Service;

import com.kessie.EventManagementSystem.Module.Event;
import com.kessie.EventManagementSystem.Module.Ticket;
import com.kessie.EventManagementSystem.Module.User;
import com.kessie.EventManagementSystem.Repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.Set;

@Service
public class EventService {
    @Autowired
    EventRepository eventRepository;

    public Event createEvent(String eventName, String description, String location /*Set<Ticket> ticket*/, String eventDate,
                             User organizer, int capacity){
        int eventId = randomNumbers();
        Event event = new Event();
        event.setEventId(eventId);
        event.setEventName(eventName);
        event.setDescription(description);
        event.setLocation(location);
        //event.setTickets(ticket);
        event.setEventDate(eventDate);
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

    public int randomNumbers(){
        Random random = new Random();
        int max = 99999;
        int min = 10000;
        return random.nextInt(max - min + 1) + min;
    }
}
