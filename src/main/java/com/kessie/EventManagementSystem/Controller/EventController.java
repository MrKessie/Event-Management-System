package com.kessie.EventManagementSystem.Controller;

import com.kessie.EventManagementSystem.Module.Event;
import com.kessie.EventManagementSystem.Module.Ticket;
import com.kessie.EventManagementSystem.Module.User;
import com.kessie.EventManagementSystem.Service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/event")
public class EventController {
    @Autowired
    EventService eventService;

    @PostMapping("/create")
    @ResponseBody
    public Event createEvent(@RequestParam String eventName, @RequestParam String description, @RequestParam String location
                             /*@RequestParam Set<Ticket> ticket*/, @RequestParam String eventDate, @RequestParam User organizer,
                             @RequestParam int capacity){
        Event event = eventService.createEvent(eventName, description, location, /*ticket*/ eventDate, organizer, capacity);
        return  event;
    }

    @GetMapping("/all")
    @ResponseBody
    public List<Event> allEvents(){
        List<Event> events = eventService.allEvents();
        return events;
    }

    @DeleteMapping("/remove")
    @ResponseBody
    public Event removeEvent(@RequestParam int eventId){
        Event event = eventService.removeEvent(eventId);
        return event;
    }
}
