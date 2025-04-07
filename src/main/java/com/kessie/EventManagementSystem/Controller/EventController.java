package com.kessie.EventManagementSystem.Controller;

import com.kessie.EventManagementSystem.Enums.EventType;
import com.kessie.EventManagementSystem.Enums.LifeCycle;
import com.kessie.EventManagementSystem.Model.Event;
import com.kessie.EventManagementSystem.Model.User;
import com.kessie.EventManagementSystem.Service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/setup/event")
public class EventController {
    @Autowired
    EventService eventService;

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<?> createEvent(@RequestParam String eventName, @RequestParam String description, @RequestParam EventType eventType,
                             @RequestParam LifeCycle lifeCycle, @RequestParam String location, @RequestParam int capacity,
                             @RequestParam LocalDate eventDate, @RequestParam LocalTime eventTime, @RequestParam User organizer){
        Long eventId = eventService.randomNumbers();
        try {
            if (eventService.existsByEventId(eventId)) {
                return ResponseEntity.status(HttpStatus.CONFLICT). body("Event with ID " + eventId + " already exists!");
            }
            Event event = eventService.createEvent(eventName, description, eventType, lifeCycle, location, capacity,  eventDate,
                    eventTime, organizer);
            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            response.put("message", "Event created successfully!");
            response.put("data", event);
            return ResponseEntity.ok(response);
        }
        catch (Exception e) {
            Map<String, Object> response = new HashMap<>();
            response.put("success", false);
            response.put("message", "Error creating event: " + e.getMessage());
            return ResponseEntity.ok(response);
        }
    }

    @GetMapping("/all")
    @ResponseBody
    public List<Event> allEvents(){
        List<Event> eventList = eventService.allEvents();
        return eventList;
    }

    @DeleteMapping("/delete/event/{eventId}")
    @ResponseBody
    public ResponseEntity<?> deleteEvent(@PathVariable Long eventId){
        try {
            if (eventService.existsByEventId(eventId)) {
                boolean deletedEvent = eventService.deleteEvent(eventId);
                Map<String, Object> response = new HashMap<>();
                response.put("success", true);
                response.put("message", "Event deleted successfully!");
                response.put("data", deletedEvent);
                return ResponseEntity.ok(response);
            }
            else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Event with ID: " + eventId + " not found.");
            }
        }
        catch (Exception e) {
            Map<String, Object> response = new HashMap<>();
            response.put("success", false);
            response.put("message", "Error deleting event: " + e.getMessage());
            return ResponseEntity.ok(response);
        }
    }

//    public ResponseEntity<?> updateEvent(@PathVariable Long eventId, @RequestBody Event updatedEvent) {
//
//    }
}
